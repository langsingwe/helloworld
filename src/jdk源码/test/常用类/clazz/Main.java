package test.常用类.clazz;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Main
 * @date 2021.03.19
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Class<?> sun = Class.forName("sun");
        sun.getName();
    }
}
