package vn.com.dsk.demo.base.service;

import vn.com.dsk.demo.base.model.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details);

    String sendMailVerify(String emailAddress, String username);
}
