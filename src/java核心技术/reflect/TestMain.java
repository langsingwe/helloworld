package java核心技术.reflect;

import java.lang.reflect.Field;

/**
 * @Description
 * @ClassName TestMain
 * @Author weilc
 * @Date 2020-12-14
 * @Version 1.0
 */
public class TestMain {
    public static void main(String[] args) {
        Son son = new Son();
        Class<? extends Son> clazz = son.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        Class<?> superclass = clazz.getSuperclass();
        Field[] declaredFields1 = superclass.getDeclaredFields();
        for (Field name : declaredFields) {
            System.out.println(name);
        }
        for (Field field : declaredFields1) {
            System.out.println(field);
        }
    }
}
