package org.jibx.test;

import org.jibx.runtime.*;

import java.io.ByteArrayOutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

/**
 * todo Document type JibxService
 */
public class JibxService {
    public final static String STRING_ENCODING = "UTF8";
    public final static String URL_ENCODING = "UTF-8";

    public static Object getProduct(){

        String system = "ping";
        Object message = createMessage();
        String xml = marshalObject(message, system);
        System.out.println(xml);

        message = unmarshalMessage(xml, system);
        return message;
    }

    /**
     * Create a default ping message.
     * @return
     */
    public static Object createMessage()
    {
        Product ping = new Product();
        ProductType type = new ProductType();
        ProductType type1 = new ProductType();
        type.setName("t1");
        type.setCreateDate(Date.valueOf("2020-02-12"));
        type.setDescription("asdsadsad");
        type.setSerialNumber("123asdsad");

        type1.setName("t2");
        type1.setCreateDate(Date.valueOf("2020-02-12"));
        type1.setDescription("asdsadsad");
        type1.setSerialNumber("123asdsad");

        ping.addProduct(type);
        ping.addProduct(type1);
        return ping;
    }
    public static final int FLIGHT_NO = 5;

    static String packageName = "org.jibx.test";
    static String bindingName = "binding";
    public static String marshalObject(Object message, String system)
    {
        try {
            IBindingFactory jc = BindingDirectory.getFactory(bindingName, packageName);
            IMarshallingContext marshaller = jc.createMarshallingContext();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            marshaller.marshalDocument(message, URL_ENCODING, null, out);
            String xml = out.toString(STRING_ENCODING);
            return xml;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JiBXException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Unmarshal this xml Message to an object.
     * @param xml
     * @param system
     * @return
     */
    public static Object unmarshalMessage(String xml, String system)
    {
        try {
            IBindingFactory jc = BindingDirectory.getFactory(bindingName, packageName);
            IUnmarshallingContext unmarshaller = jc.createUnmarshallingContext();
            Reader inStream = new StringReader(xml);
            Object message = unmarshaller.unmarshalDocument( inStream, bindingName);
            return message;
        } catch (JiBXException e) {
            e.printStackTrace();
        }
        return null;
    }
}
