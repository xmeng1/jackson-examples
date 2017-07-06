package beans;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import deserializer.MyLocalDateTimeDeserializer;
import java.time.LocalDateTime;

/**
 * User:    mengxin
 * Date:    06/07/17
 * Project: jackson-examples
 * Package: PACKAGE_NAME
 * Description: beans.BeanWithDate.
 *
 * @author mengxin
 * @version 1.0
 */
public class BeanWithDate {
    private String name;


    //We want to use other deserializer to deserialize ZonedDateTime to LocalDateTime
    @JsonDeserialize(using = MyLocalDateTimeDeserializer.class)
    private LocalDateTime date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
