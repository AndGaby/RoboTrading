package br.com.robotrading.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import br.com.robotrading.web.model.Contato;

@Component
public class ContatoService {

	@Autowired
	private JavaMailSender mailSender;

	public void enviarEmail(Contato contato) {

		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(contato.getEmail());
			msg.setFrom("tbsoaresvalkms@gmail.com");
			msg.setSubject("Fale Conosco - Mammon Trading");
			msg.setText("Olá " + contato.getNome()
					+ "\n\nRecebemos sua menssagem e iremos responder o mais rapido possivel.\n\n");
			mailSender.send(msg);
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
