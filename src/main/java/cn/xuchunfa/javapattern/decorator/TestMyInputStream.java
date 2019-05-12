package cn.xuchunfa.javapattern.decorator;

import java.io.*;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-08 14:21
 **/
public class TestMyInputStream {

    public static void main(String[] args) throws IOException {
        File file = new File("d:/test.txt");

        //InputStream inputStream = new MyInputStream(new FileInputStream(file));

        //java io 中的BufferedInputStream装饰类
        //字节流
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        //字符流读取，"gbk"解决中文乱码
        //Reader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk"));
        int c = 0;
        while ((c = inputStream.read()) != -1){
            System.out.print((char) c);
        }
        inputStream.close();
    }
}
