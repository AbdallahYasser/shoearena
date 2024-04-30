package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

//    File file = new File("properties/english.properties");

    public final static String filePath = getPath();
    final static Properties  properties =  PropertiesUtils.loadProperties();

    private static String getPath(){


        String language =  System.getProperty("lan","eng");
        return  switch (language) {
            case "arab" -> "src/main/java/properties/arabic.properties";
            case "eng" -> "src/main/java/properties/english.properties";
            default -> throw new RuntimeException(language + "language in not supported");
        };

    }


    private static Properties loadProperties(){
        File file = new File(filePath);

        try {
            InputStream inputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e+"error in load properties");
        }


    }



    public static String getBaseUrl(){

        String baseUrl = properties.getProperty("baseUrl");
        if(baseUrl != null)
            return baseUrl;
        else throw new RuntimeException("can not find baseUrl");


    }

    public static String getItemName(){

        String ItemName = properties.getProperty("itemName");
        if(ItemName != null)
            return ItemName;
        else throw new RuntimeException("can not find item name");


    }
}
