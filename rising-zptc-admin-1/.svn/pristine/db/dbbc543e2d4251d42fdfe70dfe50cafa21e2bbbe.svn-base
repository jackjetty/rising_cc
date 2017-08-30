package com.bhyf.common.configurer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rising.common.util.PathUtil;
import com.rising.common.util.PropertiesUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by admin on 2016/4/22.
 */
@Component
public class UeditorConfigConfigurer  {

    private static Properties properties = PropertiesUtils.getProps("/properties/other.properties");

    @PostConstruct
    private void exec(){
        String path = properties.getProperty("article_path");
        String fileName = PathUtil.getRootPath()+"resources/ueditor/jsp/config.json";
        File file = new File(fileName);
        Scanner scanner = null;
        StringBuilder buffer = new StringBuilder();
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        String str= buffer.toString();
        str = str.replaceAll("article_path",path);
        FileOutputStream out= null;
        try {
            out  = new FileOutputStream(file,false);
            out.write(str.getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
