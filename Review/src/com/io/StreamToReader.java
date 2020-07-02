package com.io;

import java.io.*;

public class StreamToReader {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/aa.txt"));
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        char[] c = new char[1024];
        int len = -1;
        StringBuilder stringBuilder = new StringBuilder();
        while((len = inputStreamReader.read(c))!=-1){
            stringBuilder.append(c,0,len);
            charArrayWriter.append("dad");
        }
        System.out.println(stringBuilder);
        inputStreamReader.close();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File("src/ff.txt")));
        outputStreamWriter.write("wertyujhgfdcdbfbew fhewhfurfh fuhwe ifh wifweuif rwhiufwh rifwueifh iuwefhw\n");
        outputStreamWriter.write("wertyujhgfdcdbfbew fhewhfurfh fuhwe ifh wifweuif rwhiufwh rifwueifh iuwefhw\n");
        outputStreamWriter.write("wertyujhgfdcdbfbew fhewhfurfh fuhwe ifh wifweuif rwhiufwh rifwueifh iuwefhw\n");
        outputStreamWriter.write("wertyujhgfdcdbfbew fhewhfurfh fuhwe ifh wifweuif rwhiufwh rifwueifh iuwefhw\n");
        outputStreamWriter.write("wertyujhgfdcdbfbew fhewhfurfh fuhwe ifh wifweuif rwhiufwh rifwueifh iuwefhw\n");
        outputStreamWriter.write("wertyujhgfdcdbfbew fhewhfurfh fuhwe ifh wifweuif rwhiufwh rifwueifh iuwefhw\n");
        outputStreamWriter.write("wertyujhgfdcdbfbew fhewhfurfh fuhwe ifh wifweuif rwhiufwh rifwueifh iuwefhw\n");
        outputStreamWriter.write("wertyujhgfdcdbfbew fhewhfurfh fuhwe ifh wifweuif rwhiufwh rifwueifh iuwefhw\n");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

}
