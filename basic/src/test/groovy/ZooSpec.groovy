import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification


/**
*  User:    mengxin
*  Date:    10/07/2017
*  Project: jackson-examples
*  Package: $ { PACKAGE_NAME }
*  Description: $ { NAME } .
* @author mengxin
* @version 1.0
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
    /*
    with    polymorphic{"animal":{"type":"dog","name":"DogName","barkVolume":0.0}}
    without polymorphic{"animal":{"name":"DogName","barkVolume":0.0}}
    */
}