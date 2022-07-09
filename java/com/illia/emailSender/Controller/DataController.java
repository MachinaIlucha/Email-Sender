package com.illia.emailSender.Controller;

import com.illia.emailSender.Model.Data;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.illia.emailSender.Service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DataController {

    private final EmailSender emailSender;

    @Autowired
    public DataController(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody String json) throws JsonProcessingException {
        Data data = new ObjectMapper().readValue(json, Data.class);

        boolean res = emailSender.sendEmail(data.getSubject(),data.getMessage(),data.getTo(),data.getFrom(),data.getPassword());

        return res ? ResponseEntity.ok("Email is Sent Successfully") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not Sent");
    }

}
