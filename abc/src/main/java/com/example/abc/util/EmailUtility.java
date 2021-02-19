//package com.example.abc.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//
//@Component
//public class EmailUtility {
//
//    @Autowired
//    private JavaMailSender sender;
//
//    public void sendItinerary(String toAddress, String filePath){
//        MimeMessage message =  sender.createMimeMessage();
//
//        MimeMessageHelper messageHelper = null;
//        try {
//            messageHelper = new MimeMessageHelper(message,true);
//
//            messageHelper.setTo(toAddress);
//            messageHelper.setSubject("Itinerary");
//            messageHelper.setText("please find your attachment");
//
//            messageHelper.addAttachment("ItineraryFile",new File(filePath));
//
//            sender.send(message);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
