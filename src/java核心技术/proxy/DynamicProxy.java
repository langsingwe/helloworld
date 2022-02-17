package java核心技术.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className DynamicProxy
 * @date 2022.02.17
 */
public class DynamicProxy {
    public static void main(String[] args) {
        SmsService2 smsService2 = (SmsService2) JdkProxyFactory.getProxy(new SmsService2Impl());
        smsService2.send("haha");
    }
}

interface SmsService2 {
    void send(String msg);
}

class SmsService2Impl implements SmsService2 {

    @Override
    public void send(String msg) {
        System.out.println("send: " + msg);
    }
}

class DynamicSmsInvocationHandler implements InvocationHandler {

    private Object target;

    public DynamicSmsInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before send: " + method.getName());
        Object object = method.invoke(target, args);
        System.out.println("after send: " + method.getName());
        return null;
    }
}

class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DynamicSmsInvocationHandler(target));
    }
}