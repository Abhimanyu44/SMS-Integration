package com.sms.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

    @Value("${twilio.accountSID}")
    public String accountSID;

    @Value("${twilio.authToken}")
    public String authToken;
    @Value("${twilio.twilioPhoneNo}")
    public String twilioPhoneNo;  // +16562130877-----Twilio phone number

    public void sendSms(String to, String message){
        System.out.println("authToken: "+authToken);
        System.out.println("accountSID: "+accountSID);

        Twilio.init(accountSID, authToken);   // it will check whether user is authenticated or not

       Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(twilioPhoneNo),   // Use your Twilio phone number
                message
        ).create();

    }

}



