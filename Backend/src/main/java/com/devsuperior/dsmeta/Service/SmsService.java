package com.devsuperior.dsmeta.Service;

import com.devsuperior.dsmeta.Repository.SaleRepository;
import com.devsuperior.dsmeta.entidades.Sale;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Value("${twilio.sid}")
    private static String twilioSid;

    @Value("${twilio.key}")
    private static String twilioKey;

    @Value("${twilio.phone.from}")
    private static String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private static String twilioPhoneTo;

    @Autowired
    private static SaleRepository saleRepository;
    public static void sendSms(Long saleId) {

        Sale sale = saleRepository.findById(saleId).get();

        String msg = "Vendedor" + sale.getSellerName();

        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, "msg").create();

        System.out.println(message.getSid());
    }
}