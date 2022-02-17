package java核心技术.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className MyObject
 * @date 2022.02.16
 */
public class MyObject {
    private String name;
    public MyObject() {
        name = "小伟";
    }

    public void publicMethod(String s) {
        System.out.println("public method: " + s);
    }

    public void privateMethod(String s) {
        System.out.println("private method: " + s);
    }

    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("java核心技术.reflect.MyObject");
        MyObject object = (MyObject) clazz.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        Method privateMethod = clazz.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(object, "private");
    }
}
