package com.qingke.easyjava.jdbcapp.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyManager {
    
    private static Map<String, PropertyManager> propsMap = new HashMap<>();
    
    public static synchronized PropertyManager getInstance(String propsFile) {
        if (!propsMap.containsKey(propsFile)) {
            propsMap.put(propsFile, new PropertyManager(propsFile));
        }
        
        return propsMap.get(propsFile);
    }

    private Properties props;

    private PropertyManager(String propFile) {
        try {
            props = new Properties();
            props.load(new FileInputStream(propFile));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public String getProperty(String key) {
        return props.getProperty(key);
    }
    
    public String[] getPropertyList(String key) {
        String propValue = props.getProperty(key, "");
        return propValue.split(",");
    }
}
