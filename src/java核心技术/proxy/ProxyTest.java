package java核心技术.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ProxyTest
 * @date 2021.03.07
 */
public class ProxyTest {

    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            int val = i + 1;
            TraceHandler handler = new TraceHandler(val);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }
        int key = new Random().nextInt(elements.length) + 1;
        int result = Arrays.binarySearch(elements, key);
        if (result > 0) {
            System.out.println(elements[result]);
        }
    }


   static class TraceHandler implements InvocationHandler {

        private Object target;

        public TraceHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.print(target);
            System.out.print("." + method.getName() + "(");
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    System.out.print(args[i]);
                    if (i < args.length - 1) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println(")");
            return method.invoke(target,args);
        }
    }
}
