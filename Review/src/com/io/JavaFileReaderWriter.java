package com.io;

import java.io.*;

public class JavaFileReaderWriter {
    public static void main(String[] args) throws IOException {
        test01();
    }

    public static void test01() throws IOException {
        FileReader fileReader = new FileReader(new File("src/aa.txt"));
        /*//字符数组读取
        char[] a = new char[1024];
        int len = -1;
        while((len =fileReader.read(a))!=-1){
            System.out.println(new String(a));
        }*/
        System.out.println(fileReader.getEncoding());
        int c;
        while ((c=fileReader.read())!=-1){
            System.out.print((char)c);
        }
        fileReader.close();
        fileReader = new FileReader(new File("src/aa.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        FileWriter writer = new FileWriter(new File("src/dd.txt"));
        while ((s = bufferedReader.readLine())!=null)
        {
            writer.append(s+'\n');//追加String
            System.out.println(s);
        }
        writer.close();
        writer = new FileWriter(new File("src/cc.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("aaaaaaaaaaaaaaad");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.append("adddddddd");
        bufferedWriter.close();
    }
}
