package core;

import java.io.*;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ReadProperties {

    public static void main(String[] args) throws Exception {
        classpathProperties();
        streamProperties();
        bundleProperties();
    }

    /**
     * 1.基于ClassLoder读取配置文件
     * 注：该方式只能读取类路径下的配置文件，有局限但是如果配置文件在类路径下比较方便
     */
    public static void classpathProperties() throws Exception {
        Properties properties = new Properties();
        //使用ClassLoder加载properties配置文件生成对应的输入流
        InputStream in = ReadProperties.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //使用properties对象加载输入流
        properties.load(in);
        //获取key对应的value值
        System.out.println(properties.getProperty("username"));
    }
    /**
     * 2.基于InputStream读取配置文件
     * 注：该方式的优点在于可以读取任意路径下的配置文件
     */
    public static void streamProperties() throws Exception {
        Properties properties = new Properties();
        //使用InputStream流读取配置文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader("F:/java.text/idea/springboot/webProject/resource/jdbc.properties"));
        properties.load(bufferedReader);
        //获取key对应的value值
        System.out.println(properties.getProperty("password"));
    }
    /**
     * 3.通过java.util.ResourceBundle类来获取，这种方式比使用Properties要方便一些
     */
    public static void bundleProperties() throws IOException {
        /*
        1>通过ResourceBundle.getBundle()静态方法来获取（RescourceBundle是一个抽象类），这种方式获取peoperties属性文件不需要加.properties后缀名，只需要文件名
         */
        //config为属性文件名，放在包resource下，如果是放在src下，直接用config即可
        ResourceBundle resource = ResourceBundle.getBundle("jdbc");
        System.out.println(resource.getString("driver"));
        /*
        2>从InputStream中读取
         */
        InputStream inStream = ReadProperties.class.getClassLoader().getResourceAsStream("jdbc.properties");
        ResourceBundle propertyResource = new PropertyResourceBundle(inStream);
        System.out.println(propertyResource.getString("username"));
    }

}
