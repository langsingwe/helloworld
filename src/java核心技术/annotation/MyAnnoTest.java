package java核心技术.annotation;

import java.lang.reflect.Method;

/**
 * @Description
 * @ClassName MyAnnoTest
 * @Author weilc
 * @Date 2021-01-29
 * @Version 1.0
 */
public class MyAnnoTest {
    @MyAnno
    private String str1;

    @MyAnno(abc = "aaaa")
    private String str2;

    @MyAnno("value的值")
    private String str3;

    @MyAnno(value = "value的值", abc = "aaaa")
    private String str4;

    @MyAnno(value = "VALUE", abc = "abcabc")
    public void show() {
        System.out.println("=========show=========");
    }

    public static void main(String[] args) throws Exception {
        MyAnnoTest test = new MyAnnoTest();

        Class<? extends MyAnnoTest> clazz = test.getClass();
        Method method = clazz.getMethod("show");
        boolean b = method.isAnnotationPresent(MyAnno.class);
        if (b) {
            MyAnno annotation = method.getAnnotation(MyAnno.class);
            String value = annotation.value();

            if ("VALUE".equals(value)) {
                method.invoke(test);
            }
        }

    }
}
