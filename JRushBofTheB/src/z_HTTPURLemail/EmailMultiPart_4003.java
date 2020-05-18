package z_HTTPURLemail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/* 
Отправка письма с файлом
*/
// Исправь реализацию метода setAttachment. Этот метод должен прикреплять файл к письму.
//Подсказки:
//1. Используй библиотеку JavaMail API версии 1.4.7.
//2. Письмо должно содержать только одну часть (MimeBodyPart) с файлом.

//Валидатор прошла, но при проверке зависала на методе Transport.send. Оказалось надо
// также добавить: props.put("mail.smtp.ssl.enable", "true"); После этого письмо сразу отправилось.
// Может кому поможет (а то до меня долго доходило) надо 2 библиотеки подключить
// com.sun.mail:javax.mail:1.4.7
// javax.mail:javax.mail-api:1.4.7
// и JavaBeans(TM) Activation Framework » 1.1.1

// Если получаете ошибку отправки:
//Could Not convert socket to TLS
//просто надо добавить: //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
// https://fooobar.com/questions/187535/sending-mail-attachment-using-java

// https://javarush.ru/tasks/com.javarush.task.task40.task4003#discussion
public class EmailMultiPart_4003 {

    public static void main(String[] args) {
        EmailMultiPart_4003 solution = new EmailMultiPart_4003();
        solution.sendMail("name.lastname@gmail.com", "password", "friend@gmail.com");
    }

    public void sendMail(final String username, final String password, final String recipients) {
        // заполняем нужные параметры
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // сеттим их в сессию, и авторизуемся
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session); // создаем сообщение из сесии (wrapper обертка)
            message.setFrom(new InternetAddress(username)); // указываем отправителя
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));

            setSubject(message, "Тестовое письмо"); // тема письма
            setAttachment(message, "c:/text.txt"); // текст письма из файла

            Transport.send(message);  // отправка письма
            System.out.println("Письмо было отправлено.");

        } catch (MessagingException e) {
            System.out.println("Ошибка при отправке: " + e.toString());
        }
    }

    public static void setSubject(Message message, String subject) throws MessagingException {
        message.setSubject(subject);
    }

    public static void setAttachment(Message message, String filename) throws MessagingException {
//        message.setText(filename);
        // Create a multipart message
        Multipart multipart = new MimeMultipart();
        BodyPart messageBodyPart = new MimeBodyPart();

        //Set File
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);

        //Add "file part" to multipart
        multipart.addBodyPart(messageBodyPart);

        //Set multipart to message
        message.setContent(multipart);
    }

    // from https://github.com/DenisS2/JavaRushTasks/blob/c6978a344ffa25f346512d3a3cd11ff9a7612e57/4.JavaCollections/src/com/javarush/task/task40/task4003/Solution.java
    public static void setAttachmentV2(Message message, String filename) throws MessagingException {
//        message.setText(filename);
        //message.setText(filename);
        // Создание и заполнение первой части
        //MimeBodyPart p1 = new MimeBodyPart();
        //p1.setText("This is part one of a test multipart e-mail." +
        //        "The second part is file as an attachment");


        // Создание второй части
//        MimeBodyPart p2 = new MimeBodyPart();
//
//        // Добавление файла во вторую часть
//        FileDataSource fds = new FileDataSource(filename);
//        p2.setDataHandler(new DataHandler(fds));
//        p2.setFileName(fds.getName());
//
//        // Создание экземпляра класса Multipart. Добавление частей сообщения в него.
//        Multipart mp = new MimeMultipart();
//        //mp.addBodyPart(p1);
//        mp.addBodyPart(p2);
//
//        // Установка экземпляра класса Multipart в качестве контента документа
//        message.setContent(mp);
    }
}