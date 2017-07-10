import beans.BeanWithDate
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import spock.lang.Narrative
import spock.lang.Subject
import spock.lang.Title
/**
 * User:    mengxin
 * Date:    06/07/17
 * Project: jackson-examples
 * Package: 
 * Description: BeanWithDateSpec.
 * @author mengxin
 * @version 1.0
 */

@Narrative("""
""")
@Title("Unit test for BeanWithDate")
@Subject(BeanWithDate)
class BeanWithDateSpec extends TestBase {



    def "Deserialize the BeanWithDate with date is ZonedDateTime"() {
        given: "get the json from the file"
        String json = TestUtil.getBeanJson(getClass(), BeanWithDate.class, 1)
        when: "when"
        JavaTimeModule javaTimeModule = new JavaTimeModule()
        ObjectMapper mapper = new ObjectMapper()
        mapper.registerModule(javaTimeModule)
        BeanWithDate input = mapper.readValue(json, BeanWithDate.class)
        then: "then"
        input.getName()
        input.getDate()
    }
}