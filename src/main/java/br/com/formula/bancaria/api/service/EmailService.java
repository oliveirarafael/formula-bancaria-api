package br.com.formula.bancaria.api.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender enviadorEmail;

    public void enviar(String email, String assunto, String corpo) {
        try {
            MimeMessage mensagem = enviadorEmail.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mensagem);
            //helper.setFrom("");
            helper.setTo(email);
            helper.setSubject(assunto);
            helper.setText("<p>"+corpo+"</p>", true);
            enviadorEmail.send(mensagem);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Não foi possivel enviar E-mail");
        }
    }
    
}