package 设计模式.结构性模式.代理模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ProxyTest
 * @date 2021.08.16
 */

interface Subject {
    void request();
}

class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("真实的主题方法...");
    }
}

class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        System.out.println("访问真实主题前的处理...");
        realSubject.request();
        System.out.println("访问真实主题后的处理...");
    }

}

public class ProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
