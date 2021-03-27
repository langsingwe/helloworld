package com.java.io;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author weilc
 * @description
 * @className CountInputStream
 * @date 2020-06-23
 */
public class CountInputStream extends FilterInputStream {

    private int count = 0;

    public CountInputStream(InputStream in) {
        super(in);
    }

    public int getByteRead() {
        return this.count;
    }

    @Override
    public int read() throws IOException {
        int n = in.read();
        if (n != -1) {
            this.count++;
        }
        return n;
    }

    @Override
    public int read(byte[] b,int off,int len) throws IOException {
        int n = in.read(b, off, len);
        this.count += n;
        return n;
    }

    public static void main(String[] args) throws IOException{
        byte[] data = "hello world".getBytes("UTF-8");
        try (CountInputStream input = new CountInputStream(new ByteArrayInputStream(data))) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println((char) n);
            }
            System.out.println("Total read " + input.getByteRead() + "bytes");
        }
    }
}
