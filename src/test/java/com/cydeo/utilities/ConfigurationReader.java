package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();        // private: not accessible, static: will run first


    static {


        try {
            FileInputStream file = new FileInputStream("configuration.properties");     //2- We need to open the file in java memory: FileInputStream
            properties.load(file);      // 3- Load the properties object using FileInputStream object
            file.close();               // closes the file in java memory

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something happened in the configurationReader class");
        }
    }

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }




}
