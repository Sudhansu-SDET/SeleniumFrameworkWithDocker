package com.tmb.utils;

import com.sun.istack.internal.NotNull;
import com.tmb.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtils {

    private PropertyUtils(){}

    private static Properties property = new Properties();
    private static final Map<String,String> CONFIGMAP = new HashMap<>();


    static {
        try {
            FileInputStream file =  new FileInputStream(FrameworkConstants.getCONFIGFILEPATH());
            property.load(file);

            for (Object key :property.keySet()){
                CONFIGMAP.put(String.valueOf(key),String.valueOf(property.get(key)).trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
     public static String getFromPropFile(@NotNull String key) throws Exception {

                if (Objects.isNull(CONFIGMAP.get(key))){
                    throw new Exception("Property key : " + key + " is not found in config.properties file");
                }
        return CONFIGMAP.get(key);
    }
}
