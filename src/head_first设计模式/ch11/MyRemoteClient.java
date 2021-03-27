package head_first设计模式.ch11;

import java.rmi.Naming;

/**
 * @Description
 * @ClassName MyRemoteClient
 * @Author weilc
 * @Date 2021-01-25
 * @Version 1.0
 */
public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }
    public void go() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            String s = service.sayHello();
            System.out.println(s);
        } catch (Exception e) {

        }
    }
}
