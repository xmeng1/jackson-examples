package deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * User:    mengxin
 * Date:    06/07/17
 * Project: jackson-examples
 * Package: deserializer
 * Description: MyLocalDateTimeDeserializer.
 *
 * @author mengxin
 * @version 1.0
 */
public class MyLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser jsonparser, DeserializationContext context)
            throws IOException {
        String date = jsonparser.getText();

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(javaTimeModule);
        ZonedDateTime zonedDateTime = mapper.readValue(date, ZonedDateTime.class);
        return zonedDateTime.toLocalDateTime();
    }
}
