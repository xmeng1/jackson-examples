package beans;

import java.util.List;

/**
 * User:    mengxin
 * Date:    07/07/17
 * Project: jackson-examples
 * Package: beans
 * Description: SfPojoDto.
 *
 * @author mengxin
 * @version 1.0
 */
public class SfPojoDto {
    private String device;
    private List<Ifce> ifces;

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public List<Ifce> getIfces() {
        return ifces;
    }

    public void setIfces(List<Ifce> ifces) {
        this.ifces = ifces;
    }
}

