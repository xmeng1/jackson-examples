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

    def "test Zoo basic class serialize without polymorphic" (){
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
    def "test Zoo 1 class serialize for use:id.class" (){
        given: "Dog object"
        Zoo1.Dog dog = new Zoo1.Dog("DogName")
        and: "Zoo object"
        Zoo1 zoo = new Zoo1(dog)

        when: "do serialize"
        String result = new ObjectMapper().writeValueAsString(zoo)

        then: "the result should contain type and dog"
        println("with polymorphic" + result)
        //result.contains("type")
        //result.contains("dog")
        //with polymorphic{"animal":{"type":"Zoo1$Dog","name":"DogName","barkVolume":0.0}}
    }

    def "test Zoo 2 class serialize for include=JsonTypeInfo.As.OBJECT" (){
        given: "Dog object"
        Zoo2.Dog dog = new Zoo2.Dog("DogName")
        and: "Zoo object"
        Zoo2 zoo = new Zoo2(dog)

        when: "do serialize"
        String result = new ObjectMapper().writeValueAsString(zoo)

        then: "the result should contain type and dog"
        println("with polymorphic" + result)
        //result.contains("type")
        //result.contains("dog")
        // WRAPPER_OBJECT
        //with polymorphic{"animal":{"dog":{"name":"DogName","barkVolume":0.0}}}
        // WRAPPER_ARRAY
        //with polymorphic{"animal":["dog",{"name":"DogName","barkVolume":0.0}]}
    }


    def "test Zoo basic class serialize with global setting" (){
        given: "Dog object"
        ZooBasic.Dog dog = new ZooBasic.Dog("DogName")
        and: "Zoo object"
        ZooBasic zoo = new ZooBasic(dog)

        when: "do serialize"
        ObjectMapper objectMapper = new ObjectMapper()
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)
        String result = objectMapper.writeValueAsString(zoo)

        then: "the result should be right"
        println("enableDefaultTyping：NON_FINAL " + result)

        when: "do serialize"
        ObjectMapper objectMapper2 = new ObjectMapper()
        objectMapper2.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE)
        result = objectMapper2.writeValueAsString(zoo)

        then: "the result should be right"
        println("enableDefaultTyping：OBJECT_AND_NON_CONCRETE " + result)

        when: "do serialize"
        ObjectMapper objectMapper3 = new ObjectMapper()
        objectMapper3.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS)
        result = objectMapper3.writeValueAsString(zoo)

        then: "the result should be right"
        println("enableDefaultTyping：NON_CONCRETE_AND_ARRAYS " + result)

        when: "do serialize"
        ObjectMapper objectMapper4 = new ObjectMapper()
        objectMapper4.enableDefaultTyping(ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT)
        result = objectMapper4.writeValueAsString(zoo)

        then: "the result should be right"
        println("enableDefaultTyping：JAVA_LANG_OBJECT " + result)

        /*
         *
            enableDefaultTyping：NON_FINAL
            ["ZooBasic",{"animal":["ZooBasic$Dog",{"name":"DogName","barkVolume":0.0}]}]
            enableDefaultTyping：OBJECT_AND_NON_CONCRETE
            {"animal":{"name":"DogName","barkVolume":0.0}}
            enableDefaultTyping：NON_CONCRETE_AND_ARRAYS
            {"animal":{"name":"DogName","barkVolume":0.0}}
            enableDefaultTyping：JAVA_LANG_OBJECT
            {"animal":{"name":"DogName","barkVolume":0.0}}
         */
    }
}