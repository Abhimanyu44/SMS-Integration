package com.sms.controller;

import com.sms.dto.SmsRequest;
import com.sms.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/sendSms")
    public void sendSMS(@RequestBody SmsRequest smsRequest){
        smsService.sendSms(smsRequest.getTo(), smsRequest.getMessage());
    }

//    @PostMapping("/send-sms")
//    public ResponseEntity<String> sendSMS(@RequestParam String to, @RequestParam String message) {
//        smsService.sendSms(to, message);
//        return ResponseEntity.ok("SMS sent successfully.");
//    }

}
