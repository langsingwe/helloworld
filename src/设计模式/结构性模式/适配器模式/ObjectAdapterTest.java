package 设计模式.结构性模式.适配器模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ObjectAdapterTest
 * @date 2021.08.12
 */

class ObjectAdapter implements Target {
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

public class ObjectAdapterTest {
    public static void main(String[] args) {
        System.out.println("对象适配器测试...");
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}
