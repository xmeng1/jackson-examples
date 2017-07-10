package beans;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import deserializer.DeviceDeserializer;

/**
 * User:    mengxin
 * Date:    07/07/17
 * Project: jackson-examples
 * Package: beans
 * Description: SfPojo1.
 *
 * @author mengxin
 * @version 1.0
 */
@JsonDeserialize(using = DeviceDeserializer.class)
public class SfPojo {
    private String device;
    private String port;
    private String reservbleBw;

    public SfPojo() {
    }

    public SfPojo(String device, String port, String reservbleBw) {
        this.device = device;
        this.port = port;
        this.reservbleBw = reservbleBw;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getReservbleBw() {
        return reservbleBw;
    }

    public void setReservbleBw(String reservbleBw) {
        this.reservbleBw = reservbleBw;
    }
}
