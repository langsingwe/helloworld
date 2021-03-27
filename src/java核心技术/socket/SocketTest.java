package java核心技术.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className SocketTest
 * @date 2021.03.15
 */
public class SocketTest {
    public static void main(String[] args) {
        try (Socket socket = new Socket("java核心技术.time-a.nist.gov",13);
             Scanner in = new Scanner(socket.getInputStream(),"UTF-8")){
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
