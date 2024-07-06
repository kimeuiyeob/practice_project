package com.daeduk.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.daeduk.dto.UserDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailService {

    private JavaMailSender emailSender;

    public void sendSimpleMessage(UserDto user) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("admin@gmail.com");
        message.setTo(user.getEmail());
        message.setSubject("비밀번호 안내입니다.");
        message.setText(user.getPassword());
        emailSender.send(message);
    }

}
