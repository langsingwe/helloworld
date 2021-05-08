package 廖雪峰java.reflect;

import java.lang.reflect.Method;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className HelloReflect
 * @date 2021.04.28
 */
public class HelloReflect {
    public static void main(String[] args) {
        try {
            //动态加载类
            HelloReflect helloReflect = (HelloReflect) Class.forName("廖雪峰java.reflect.HelloReflect").newInstance();
            helloReflect.sayHello();
            //方法调用
            HelloReflect test = new HelloReflect();
            Method method = test.getClass().getDeclaredMethod("sayHello");
            method.invoke(test);
        } catch (Exception e) {

        }

    }

    public void sayHello() {
        System.out.println("hello");
    }
}
