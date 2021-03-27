package com.java.internet;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author weilc
 * @description
 * @className Client
 * @date 2020-07-02
 */
public class Client {
    public static void main(String[] args) throws IOException{
        Socket localhost = new Socket("localhost", 6666);
        try (InputStream input = localhost.getInputStream()) {
            try (OutputStream output = localhost.getOutputStream()){
                handle(input,output);
            }
        }
        localhost.close();
        System.out.println("disconnected");

    }

    private static void handle(InputStream input, OutputStream output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        System.out.println("[server] " + reader.readLine());
        for (;;) {
            // 打印提示
            System.out.print(">>> ");
            // 读取一行输入b
            String s = scanner.nextLine();
            writer.write(s);
            writer.newLine();
            writer.flush();
            String resp = reader.readLine();
            System.out.println("<<< " + resp);
            if (resp.equals("bye")) {
                break;
            }
        }
    }
}
