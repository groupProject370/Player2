import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaMailUtil {
	public static void sendMail(String rec) throws MessagingException {
        System.out.println("Testing");
        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp-mail.outlook.com");
        props.setProperty("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.auth", "true");
        //props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");

        String user = "player2.project370@gmail.com";
        String password = "Player2Itec370";

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        Message message = prepareMessage(session, user, rec);
        Transport.send(message);
        System.out.println("Message sent");
    }

    private static Message prepareMessage(Session session, String user, String rec) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(rec));
            message.setSubject("Code for Player 2");
            Random ran = new Random();
            int rando = 0;
            while (rando < 1000) rando = ran.nextInt(10000);
            message.setText(String.format("Your code is : %4d", rando));
            return message;
        }
        catch (Exception e) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
