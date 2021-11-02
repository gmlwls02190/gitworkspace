package web.mail;

import javax.mail.Authenticator;

import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator {

	PasswordAuthentication pa;

	public MailAuth() {
		String mail_id = "ksh02190@gmail.com"; // 
		String mail_pw = "dus856852!@"; // 

		pa = new PasswordAuthentication(mail_id, mail_pw);
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}
