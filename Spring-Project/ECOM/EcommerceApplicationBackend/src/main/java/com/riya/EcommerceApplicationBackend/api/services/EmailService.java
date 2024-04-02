package com.riya.EcommerceApplicationBackend.api.services;


import com.riya.EcommerceApplicationBackend.api.exception.EmailFailureException;
import com.riya.EcommerceApplicationBackend.model.VerificationToken;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService {

    @Value("${email.from}")
    private String fromAddress;

    @Value("${app.frontend.url}")
    private String url;

    @Autowired
    private JavaMailSender javaMailSender;

    private SimpleMailMessage makeMailMessge() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(fromAddress);
        return simpleMailMessage;
    }

    public void sendVerificationEmail(VerificationToken verificationToken) throws EmailFailureException {
        SimpleMailMessage message = makeMailMessge();
        message.setTo(verificationToken.getUser().getEmail());
        message.setSubject("Verify your mail to active your account.");
        message.setText("Please follow the link to verify your mail to active your account.\n"
        + url + "/auth/verifytoken=" + verificationToken.getToken());
        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            throw new EmailFailureException();
        }
    }


}
