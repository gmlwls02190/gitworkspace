package web.mail;

import javax.mail.Authenticator;

import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator {

	PasswordAuthentication pa;

	public MailAuth() {
		String mail_id = "사용할이메일"; // 
		String mail_pw = "해당이메일비밀번호"; // 

		pa = new PasswordAuthentication(mail_id, mail_pw);
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}
