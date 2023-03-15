import javax.mail.MessagingException;

public class JavaMail {
	public static void main(String[] args) throws MessagingException {
		JavaMailUtil.sendMail("cscott12@radford.edu");
	}
}