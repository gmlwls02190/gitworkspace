package web.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.RandomStringUtils;

public class QamailSend {
	
	public String QaMailSend(String myMail) {
		String mcontent=null;
		
		Properties prop=System.getProperties();
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "465");
		
		Authenticator auth=new MailAuth();
		Session session=Session.getDefaultInstance(prop,auth);
		MimeMessage msg=new MimeMessage(session);
		
		try {
			msg.setSentDate(new Date());
			msg.setFrom(new InternetAddress(myMail, "HJ Art Gallery Admin"));
			InternetAddress to=new InternetAddress(myMail);
			mcontent=RandomStringUtils.randomAlphanumeric(15);
			
			msg.setRecipient(Message.RecipientType.TO, to);
			msg.setSubject("임시비밀번호입니다.","UTF-8");
			msg.setText(mcontent,"UTF-8");
			
			Transport.send(msg);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mcontent;
	}
}
