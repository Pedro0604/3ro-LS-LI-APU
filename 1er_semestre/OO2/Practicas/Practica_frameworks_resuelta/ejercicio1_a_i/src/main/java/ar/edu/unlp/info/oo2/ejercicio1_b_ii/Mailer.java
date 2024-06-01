package ar.edu.unlp.info.oo2.ejercicio1_b_ii;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Mailer {
	public static void sendMail(String text) {
		try {
			String from = "example@logger.com";
			String to = "destination@mail.com";

			// credenciales
			// La clase MailTrapCredentials solo tiene dos métodos
			// estáticos que retornan username y password
			// excluidos del repositorio remoto de github
			String username = MailTrapCredentials.getUsername();
			String password = MailTrapCredentials.getPassword();

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.mailtrap.io");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from, "Java logging mail"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Logging - Ejercicio 1_b_ii");
			message.setText(text);
			Transport.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}