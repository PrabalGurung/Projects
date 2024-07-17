import java.util.Random;

public class Food {

    //initializing position of food
    private final int posX;
    private final int posY;

    //generates food in game
    public Food() {
        posX = generatePos(Graphic.WIDTH);
        posY = generatePos(Graphic.HEIGHT);
    }

    //makes the position of food random
    private int generatePos(int size) {
        Random random = new Random();
        //makes the position of food be inside of graphic window
        return random.nextInt(size / Graphic.TICK_SIZE) * Graphic.TICK_SIZE;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
