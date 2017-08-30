package com.bhyf.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.io.*;
import java.util.*;

/**
 * 项目名称：monitoring-admin
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/12/4 10:35
 * 修改人：caizh
 * 修改时间：2015/12/4 10:35
 * 修改备注：
 */
public class CSVUtils {
    public static File createCSVFile(List exportData, LinkedHashMap rowMapper,
                                     String outPutPath, String filename) {

        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            csvFile = new File(outPutPath + filename + ".csv");
            // csvFile.getParentFile().mkdir();
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            // GB2312使正确读取分隔符","
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(csvFile), "GB2312"), 1024);
            // 写入文件头部
            for (Iterator propertyIterator = rowMapper.entrySet().iterator(); propertyIterator.hasNext();) {
                Map.Entry propertyEntry = (Map.Entry) propertyIterator
                        .next();
                csvFileOutputStream.write("\""
                        + propertyEntry.getValue().toString() + "\"");
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            csvFileOutputStream.newLine();




            // 写入文件内容
            for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
                // Object row = (Object) iterator.next();
                LinkedHashMap row = (LinkedHashMap) iterator.next();
                System.out.println(row);

                for (Iterator propertyIterator = row.entrySet().iterator(); propertyIterator.hasNext();) {
                    Map.Entry propertyEntry = (Map.Entry) propertyIterator.next();
                    // System.out.println( BeanUtils.getProperty(row, propertyEntry.getKey().toString()));
                    csvFileOutputStream.write("\""
                            +  propertyEntry.getValue().toString() + "\"");
                    if (propertyIterator.hasNext()) {
                        csvFileOutputStream.write(",");
                    }
                }
                if (iterator.hasNext()) {
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }
    public static File createCSVFile(JSONArray exportData,  LinkedHashMap head,
                                     String outPutPath, String filename) {

        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            csvFile = new File(outPutPath + filename + ".csv");
            // csvFile.getParentFile().mkdir();
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            // GB2312使正确读取分隔符","
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(csvFile), "GB2312"), 1024);
            List<String> heads = Lists.newArrayList();
            // 写入文件头部
            // 写入文件头部
            for (Iterator propertyIterator = head.entrySet().iterator(); propertyIterator.hasNext();) {
                Map.Entry propertyEntry = (Map.Entry) propertyIterator
                        .next();
                heads.add(propertyEntry.getKey().toString());
                csvFileOutputStream.write("\""
                        + propertyEntry.getValue().toString() + "\"");
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            csvFileOutputStream.newLine();




            // 写入文件内容
            for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
                // Object row = (Object) iterator.next();
                JSONObject row = (JSONObject) iterator.next();

                for (int i = 0;i<heads.size();i++) {
                    csvFileOutputStream.write("\""
                            +  row.get(heads.get(i)) + "\"");
                    if (i<heads.size()-1) {
                        csvFileOutputStream.write(",");
                    }
                }
                if (iterator.hasNext()) {
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }
    public static void appendCSVFile(JSONArray exportData,  LinkedHashMap head,
                                     String outPutPath, String filename) {

        BufferedWriter csvFileOutputStream = null;
        try {
            // GB2312使正确读取分隔符","
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(outPutPath + filename + ".csv",true), "GB2312"), 1024);
            List<String> heads = Lists.newArrayList();
            for (Iterator propertyIterator = head.entrySet().iterator(); propertyIterator.hasNext();) {
                Map.Entry propertyEntry = (Map.Entry) propertyIterator
                        .next();
                heads.add(propertyEntry.getKey().toString());
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            csvFileOutputStream.newLine();
            // 写入文件内容
            for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
                // Object row = (Object) iterator.next();
                JSONObject row = (JSONObject) iterator.next();

                for (int i = 0;i<heads.size();i++) {
                    csvFileOutputStream.write("\""
                            +  row.get(heads.get(i)) + "\"");
                    if (i<heads.size()-1) {
                        csvFileOutputStream.write(",");
                    }
                }
                if (iterator.hasNext()) {
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        JSONArray array = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1","5");
        jsonObject.put("2","6");
        jsonObject.put("3","7");
        jsonObject.put("4", "8");
        List exportData = new ArrayList<Map>();
        Map row1 = new LinkedHashMap<String, String>();
        row1.put("1", "11");
        row1.put("2", "12");
        row1.put("3", "13");
        row1.put("4", "14");
        exportData.add(row1);
        array.add(jsonObject);
        row1 = new LinkedHashMap<String, String>();
        row1.put("1", "21");
        row1.put("2", "22");
        row1.put("3", "23");
        row1.put("4", "24");
        exportData.add(row1);
        array.add(JSON.parseObject(JSON.toJSONString(row1)));
        List propertyNames = new ArrayList();

        JSONArray object = new JSONArray();
        object.add("1");
        object.add("2");
        object.add("3");
        object.add("4");
        LinkedHashMap map = new LinkedHashMap();
        map.put("1", "第一列");
        map.put("2", "第二列");
        map.put("3", "第三列");
        map.put("4", "第四列");
        CSVUtils.appendCSVFile(array, map, "d:/", "20151204");
    }
}
