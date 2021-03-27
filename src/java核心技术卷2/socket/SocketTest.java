package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author weilc
 * @description
 * @className SocketTest
 * @date 2020-05-27
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        try(Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13)) {
            InputStream inputStream = s.getInputStream();
            Scanner in = new Scanner(inputStream);
            while (in.hasNext()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
