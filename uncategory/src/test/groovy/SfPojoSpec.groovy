import beans.SfPojo
import beans.SfPojoDto
import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title
/**
 * User:    mengxin
 * Date:    07/07/17
 * Project: jackson-examples
 * Package: 
 * Description: SfPojo1Spec.
 * @author mengxin
 * @version 1.0
 */

@Narrative("""
""")
@Title("Unit test for SfPojo")
@Subject(SfPojo)
class SfPojoSpec extends Specification {

    def "Deserialize the SfPojoDto with custom deserializer"() {
        given: "get the json from the file"
        String json = TestUtil.getBeanJson(getClass(), SfPojo.class, 1)
        when: "when"
        ObjectMapper mapper = new ObjectMapper()
        SfPojoDto input = mapper.readValue(json, SfPojoDto.class)
        then: "then"
        input
        System.out.println(input.toString())
    }

    def "Deserialize the SfPojo with custom deserializer"() {
        given: "get the json from the file"
        String json = TestUtil.getBeanJson(getClass(), SfPojo.class, 1)
        when: "when"
        ObjectMapper mapper = new ObjectMapper()
        SfPojo input = mapper.readValue(json, SfPojo.class)
        then: "then"
        input
        System.out.println(input.toString())
    }
}