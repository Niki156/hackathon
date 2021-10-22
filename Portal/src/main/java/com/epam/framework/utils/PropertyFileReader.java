package com.epam.framework.utils;

import com.epam.framework.exceptions.PropertyFileException;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {
     private  static Properties prop = new Properties();
     private PropertyFileReader(String filePath){
        try (FileInputStream ip = new FileInputStream(filePath)) {
            prop.load(ip);
            } catch(Exception e) {
            throw new PropertyFileException("Error occured while reading the property file");
        }
    }
    public static Properties getPropLoader(String propertyFilePath){
        new PropertyFileReader(propertyFilePath);
        return prop;
    }
}
