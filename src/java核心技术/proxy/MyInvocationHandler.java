package java核心技术.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className MyInvocationHandler
 * @date 2021.02.09
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备插入数据");
        Object value = method.invoke(target, args);
        System.out.println("插入结束");
        return value;
    }

    public static void main(String[] args) {
        IUserService target = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(target);
        IUserService proxy = (IUserService) Proxy.newProxyInstance(handler.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        proxy.add("张三");
    }
}
