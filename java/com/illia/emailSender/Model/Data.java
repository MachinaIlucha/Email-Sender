package com.illia.emailSender.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Data {
    private String to;
    private String from;
    private String message;
    private String subject;
    private String password;
}
