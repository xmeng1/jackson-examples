import org.apache.commons.io.FileUtils

/**
 * User:    mengxin
 * Date:    06/07/17
 * Project: jackson-examples
 * Package: 
 * Description: TestUtil.
 * @author mengxin
 * @version 1.0
 */
class TestUtil {

    protected static String getBeanJsonFileName(Class<?> beanType, int sn) {
        return "json/" + beanType.getSimpleName() + "_" + String.valueOf(sn) + ".json"
    }

    protected static File getBeanJsonFile(Class<?> invoker, Class<?> beanType, int sn) {
        return new File(invoker.getResource(getBeanJsonFileName(beanType, sn))
                .getFile())
    }

    protected static String getBeanJson(Class<?> invoker, Class<?> beanType, int sn) {
        File file = getBeanJsonFile(invoker, beanType, sn)
        return FileUtils.readFileToString(file, "UTF-8")
    }

}
