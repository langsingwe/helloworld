package java核心技术.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className QQClient
 * @date 2021.02.22
 */
public class QQClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8001);
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            socket.getOutputStream().write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
