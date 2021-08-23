package 设计模式.结构性模式.适配器模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ClassAdapterTest
 * @date 2021.08.12
 */
//目标接口
interface Target {
    public void request();
}
//适配者
class Adaptee {
    public void specificRequest() {
        System.out.println("适配者中的业务代码被调用");
    }
}

//类适配器
class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}

public class ClassAdapterTest {
    public static void main(String[] args) {
        System.out.println("类适配器模式测试");
        Target target = new ClassAdapter();
        target.request();
    }
}
