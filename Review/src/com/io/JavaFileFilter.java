package com.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class JavaFileFilter {
    public static void main(String[] args) {
        File file = new File("src");
        File[] files = file.listFiles(new FileFilter(){
            public boolean accept(File name){
                if(name.getName().endsWith(".java"))
                    return true;
                return false;
            }
        });
        for (File f: files){
            System.out.println(f.getName());
        }
        System.out.println("---------------------------");
        String[] files1 = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println(dir.getName()+"  "+name);
                if(dir.isFile())return true;
                if(dir.list().length>0)return true;
                return false;
            }
        });
        System.out.println("---------------------------");
        for (String s:files1){
            System.out.println(s);
        }
    }

}
