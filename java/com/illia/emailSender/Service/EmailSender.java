package com.illia.emailSender.Service;

public interface EmailSender {
    boolean sendEmail(String subject, String message, String to, String from, String password);
}
