package com.java.io;

import java.io.*;

/**
 * @author weilc
 * @description
 * @className TestStream
 * @date 2020-05-28
 */
public class TestStream {
    public static void main(String[] args) {
        try {
            readFile();
            writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFile() throws IOException{
        File file = new File("lol.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] all = new byte[(int) file.length()];
        fis.read(all);
        for (byte b : all) {
            System.out.println(b);
        }
        fis.close();
    }

    public static void writeFile() throws IOException {
        File file = new File("lol2.txt");
        byte[] data = {88, 89};
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
        fos.close();
    }

    public static void reader() throws IOException{
        File file = new File("lol.txt");
        try (FileReader fr = new FileReader(file)) {
            char[] all = new char[(int) file.length()];
            fr.read(all);
            for (char c : all) {
                System.out.println(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
