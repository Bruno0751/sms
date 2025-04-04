package props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import sms.SMS;

/**
 *
 * @author Bruno
 */
public class PropertiesBean {

    static Properties props = null;

    public static Properties readFilePropeties() {
        java.lang.System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        if (props == null) {
            String sConfigFile = "props/prpeties.properties";
            InputStream in = SMS.class.getClassLoader().getResourceAsStream(sConfigFile);
            if (in != null) {
                props = new Properties();
                try {
                    props.load(in);
                    in.close();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        return props;
    }

}
