package cn.xuchunfa.javapattern.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 自定义输入流：大写转小写，小写转大写。具体的装饰者类
 * @author: Xu chunfa
 * @create: 2018-11-08 12:00
 **/
public class MyInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected MyInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = 0;

        if ((c = super.read()) != -1){
            if (Character.isLowerCase(c)) {
                //将小写转化为大写
                return Character.toUpperCase(c);
            } else if (Character.isUpperCase(c)) {
                //大写转化成小写
                return Character.toLowerCase(c);
            } else {
                return c;
            }
        }else
            return -1;
    }
}
