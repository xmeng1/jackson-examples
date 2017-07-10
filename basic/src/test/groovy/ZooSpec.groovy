import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification


/**
 * Created by mengxin on 10/07/2017.
 */
class ZooSpec extends Specification {
    def "test Zoo class serialize" (){
        given: "Dog object"
        Zoo.Dog dog = new Zoo.Dog("DogName")
        and: "Zoo object"
        Zoo zoo = new Zoo(dog)

        when: "do serialize"
        String result = new ObjectMapper().writeValueAsString(zoo)

        then: "the result should contain type and dog"
        println("with polymorphic" + result)
        result.contains("type")
        result.contains("dog")
    }

    def "test Zoo class serialize without polymorphic" (){
        given: "Dog object"
        ZooBasic.Dog dog = new ZooBasic.Dog("DogName")
        and: "Zoo object"
        ZooBasic zoo = new ZooBasic(dog)

        when: "do serialize"
        String result = new ObjectMapper().writeValueAsString(zoo)

        then: "the result should contain type and dog"
        println("without polymorphic" + result)
        !result.contains("type")
        !result.contains("dog")
    }
}