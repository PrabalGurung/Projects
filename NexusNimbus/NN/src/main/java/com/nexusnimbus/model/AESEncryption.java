package com.nexusnimbus.model;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import javax.crypto.KeyGenerator;

public class AESEncryption {
    private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";
    private static final int TAG_LENGTH_BIT = 128;
    private static final int IV_LENGTH_BYTE = 12;
    private static final int SALT_LENGTH_BYTE = 16;
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    public static byte[] getRandomNonce(int numBytes) {
        byte[] nonce = new byte[numBytes];
        new SecureRandom().nextBytes(nonce);
        return nonce;
    }

    // AES secret key
    public static SecretKey getAESKey(int keysize) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(keysize, SecureRandom.getInstanceStrong());
        return keyGen.generateKey();
    }

    // Encrypt with AES/GCM/NoPadding
    public static String encrypt(byte[] pText, String password) throws Exception {
        byte[] salt = getRandomNonce(SALT_LENGTH_BYTE);
        byte[] iv = getRandomNonce(IV_LENGTH_BYTE);

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        SecretKey aesKey = new SecretKeySpec(password.getBytes(UTF_8), "AES");
        GCMParameterSpec spec = new GCMParameterSpec(TAG_LENGTH_BIT, iv);
        cipher.init(Cipher.ENCRYPT_MODE, aesKey, spec);

        byte[] cipherText = cipher.doFinal(pText);

        byte[] cipherTextWithIvSalt = ByteBuffer.allocate(iv.length + salt.length + cipherText.length)
                .put(iv)
                .put(salt)
                .put(cipherText)
                .array();

        return Base64.getEncoder().encodeToString(cipherTextWithIvSalt);
    }

    // Decrypt with AES/GCM/NoPadding
    public static String decrypt(String cText, String password) throws Exception {
        byte[] decode = Base64.getDecoder().decode(cText);

        ByteBuffer bb = ByteBuffer.wrap(decode);
        byte[] iv = new byte[IV_LENGTH_BYTE];
        bb.get(iv);

        byte[] salt = new byte[SALT_LENGTH_BYTE];
        bb.get(salt);

        byte[] cipherText = new byte[bb.remaining()];
        bb.get(cipherText);

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        SecretKey aesKey = new SecretKeySpec(password.getBytes(UTF_8), "AES");
        GCMParameterSpec spec = new GCMParameterSpec(TAG_LENGTH_BIT, iv);
        cipher.init(Cipher.DECRYPT_MODE, aesKey, spec);

        byte[] plainText = cipher.doFinal(cipherText);

        return new String(plainText, UTF_8);
    }
}

