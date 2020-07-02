package com.file.utils;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class UuidUtils {
    public static String Filename(String filename){
        return UUID.randomUUID().toString().replaceAll("-","")+"_"+filename;
    }
    public static String FilePath(String basePath, String filename){
        int file1 = filename.hashCode()&15;
        int file2 = (filename.hashCode()>>4)&15;
        String path = basePath+"\\"+file1+"\\"+file2;
        File file = new File(path);
        if(!file.exists())file.mkdirs();
        return path;
    }
    public static void Files(HashMap<String,String> hashMap,File file){
        if(file.exists()){
            for(File i :file.listFiles()){
                if(i.isFile()){
                    String key = i.getName().split("_")[0];
                    String value = i.getName().split(("_"))[1];
                    hashMap.put(key,value);
                }
                else {
                    Files(hashMap,i);
                }
            }
        }
    }
    public static File FindFile(String basePath,String filename){
        int file1 = filename.split("_")[1].hashCode()&15;
        int file2 = filename.split("_")[1].hashCode()>>4&15;
        String path = basePath+"\\"+file1+"\\"+file2+"\\"+filename;
        File file = new File(path);
        return file;
    }
}
