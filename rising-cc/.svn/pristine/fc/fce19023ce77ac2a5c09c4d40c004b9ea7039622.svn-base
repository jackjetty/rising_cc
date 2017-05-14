package com.rising.cc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 123 on 2015/5/18.
 */
public class PropertiesUtil {


    private Properties properties = null;
    private final String PROP_PATH = "/config.properties";


    private void init() {
        try {
            InputStream inputStream = getInputStream();
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
    }

    public static Properties getProp(String path) {
        Properties props = new Properties();
        InputStream in = null;
        try {
            // 讲文件信息读取到输出流
            in = PropertiesUtil.class.getResourceAsStream(path);
            props.load(in);
            return props;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return props;
    }

    private InputStream getInputStream() {
        return PropertiesUtil.class.getResourceAsStream(PROP_PATH);
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        PropertiesUtil util = new PropertiesUtil();
        util.init();
    }
}


