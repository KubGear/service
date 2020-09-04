package time;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * todo Document type TimeConfiguration
 */
@Configuration
public class
TimeConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");
        return marshaller;
    }
    @Bean
    public TimeClient timeClient(Jaxb2Marshaller marshaller){
        TimeClient client = new TimeClient();
        client.setDefaultUri("http://localhost:8888/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }

}

