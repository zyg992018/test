package com.io;

import java.io.*;

/**********
 * 字节输入输出流
 */
public class JavaFileInputStream {

    public static void main(String[] args) throws Exception {
//        test01();
//        test02();
        test03();
    }
    public static void test01() throws Exception {
        FileInputStream input = new FileInputStream(new File("C:\\Users\\28120\\Desktop\\数据库.txt"));
        FileOutputStream output  =new FileOutputStream(new File("src/aa.txt"));
        byte[] array = new byte[1024*10];
        int len = -1;
        while ((len = input.read(array))!=-1){
            String s = new String(array,0,len);
            System.out.println(s);
            output.write(array,0,len);
        }
        output.write("文件结尾".getBytes());
        output.close();
        input.close();
    }

    /*****
     * 字节数组
     */
    public static void test02() throws IOException {
        byte[] info = "abcdefghigk".getBytes();
        ByteArrayInputStream inputArray = new ByteArrayInputStream(info);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write("fasfvgfvfvbbabga".getBytes());
        outputStream.write("1234567890".getBytes());
        String s = new String(outputStream.toByteArray());
        String d = outputStream.toString("UTF-8");
        System.out.println(s);
        System.out.println(d);
    }
    /**********
     * 字节缓存
     */
    public static void test03() throws IOException {
        byte[] array = new byte[1024*10];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("src/aa.txt")));
        int len = -1;
        ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("src/bb.txt")));
        while ((len = bufferedInputStream.read(array))!=-1){
            byteArrayOutputStream.write(array,0,len);
            bufferedOutputStream.write(array,0,len);
            byteArrayOutputStream.flush();
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
        System.out.println(byteArrayOutputStream.toString("UTF-8"));
        ByteArrayOutputStream bb = new ByteArrayOutputStream();
        BufferedOutputStream b = new BufferedOutputStream(bb);
        b.write("adddddddf".getBytes());
        b.write("dasafdsfsdaf".getBytes());
        b.flush();
        System.out.println(bb.toString());
    }

}
