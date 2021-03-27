package java核心技术.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className QQServer
 * @date 2021.02.22
 */
public class QQServer {
    static byte[] bytes = new byte[1024];

public static void main(String[] args) {
    try {
        ServerSocket serverSocket = new ServerSocket(8001);
        //阻塞
        Socket socket = serverSocket.accept();
        //阻塞
        int read = socket.getInputStream().read(bytes);
        String content = new String(bytes);
        System.out.println(content);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
