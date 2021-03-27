package com.java.socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author weilc
 * @description
 * @className IOServer
 * @date 2020-08-10
 */
public class IOServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(3333);
        new Thread(() -> {
            try {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try {
                        int len;
                        byte[] data = new byte[1024];
                        InputStream in = socket.getInputStream();
                        while ((len = in.read(data)) != -1) {
                            System.out.println(new String(data, 0, len));
                        }
                    } catch (Exception e){}
                }).start();
            } catch (Exception e){}
        }).start();
    }
}
