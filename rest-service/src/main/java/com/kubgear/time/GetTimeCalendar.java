package com.kubgear.time;

import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import time.TimeClient;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * todo Document type GetTimeCalendar
 */
public class GetTimeCalendar {

    public static XMLGregorianCalendar getCalendar(){
        return timeClient(marshaller()).getTime("name").getTime();
    }

    public static Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");
        return marshaller;
    }
    public static TimeClient timeClient(Jaxb2Marshaller marshaller){
        TimeClient client = new TimeClient();
        client.setDefaultUri("http://localhost:8888/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }
}
