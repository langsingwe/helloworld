package com.java.socket;

import java.net.Socket;
import java.util.Date;

/**
 * @author weilc
 * @description
 * @className IOClient
 * @date 2020-08-10
 */
public class IOClient {
    public static void main(String[] args) {
        new Thread(()->{
           try {
               Socket socket = new Socket("127.0.0.1",3333);
               while (true) {
                   try {
                       socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                       Thread.sleep(2000);
                   } catch (Exception e){}
               }
           } catch (Exception e) {}
        }).start();
    }
}
