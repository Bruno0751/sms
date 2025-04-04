package sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import java.util.Properties;

/**
 *
 * @author Bruno Gressler da Silveira
 * @since 22/02/2025
 * @version 1
 */
public class SMS {

    public static String account_sid = null;
    public static String auth_token = null;
    public static String phoneTwiiio = null;
    public String name;
    public String phone;
    public String menssage;

    public SMS() {
        Properties properties = props.PropertiesBean.readFilePropeties();
        SMS.account_sid = properties.getProperty("TWILIO_ACCOUNT_SID");
        SMS.auth_token = properties.getProperty("TWILIO_AUTH_TOKEN");
        SMS.phoneTwiiio = properties.getProperty("TWILIO_PHONE");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }

    public static void readPropeties() {

    }

    public void enviarSMS() throws Exception {

        if (SMS.account_sid == null || SMS.auth_token == null || SMS.phoneTwiiio == null) {
            throw new Exception("sem permissao");
        }

        Twilio.init(account_sid, auth_token);
        try {
            MessageCreator messageCreator = Message.creator(
                    new com.twilio.type.PhoneNumber("+5551" + this.phone), new com.twilio.type.PhoneNumber(SMS.phoneTwiiio), this.menssage
            );
            Message message = messageCreator.create();

        } catch (Exception e) {
            System.out.println("ERROR");
            System.out.println(e.getMessage());
        }
    }

}
