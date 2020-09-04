package time;

import com.example.consumingwebservice.wsdl.GetTimeRequest;
import com.example.consumingwebservice.wsdl.GetTimeResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.logging.Logger;

/**
 * todo Document type TimeClient
 */
public class TimeClient extends WebServiceGatewaySupport {

    private static final Logger log = Logger.getLogger(TimeClient.class.getName());

    public GetTimeResponse getTime(String name){

        GetTimeRequest request = new GetTimeRequest();
        request.setName(name);

        log.info("Requesting: " + name);

        GetTimeResponse response = (GetTimeResponse) getWebServiceTemplate()
            .marshalSendAndReceive("http://localhost:8888/ws/time", request,
                new SoapActionCallback("http://webservice.kubgear.com"));

        return response;
    }
}
