package head_first设计模式.ch11;

import java.rmi.Remote;

/**
 * @Description
 * @ClassName MyRemote
 * @Author weilc
 * @Date 2021-01-25
 * @Version 1.0
 */
public interface MyRemote extends Remote {
    String sayHello();
}
