import smtplib as s

ob = s.SMTP('smtp.gmail.com', 587)
ob.ehlo()
ob.starttls()
ob.login('lostzero980@gmail.com','Kamal@12')
subject = "test"
body = "click the link to add virus :)"
message = "subject:{}\n\n{}".format(subject,body)
listadd = ['gprabal505@gmail.com']
ob.sendmail('lostzero980@gmail.com',listadd, message)
print('sent')
ob.quit