package java核心技术.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description
 * @ClassName MyAnno
 * @Author weilc
 * @Date 2021-01-29
 * @Version 1.0
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {

    String value() default "default value";

    String[] abc() default "abc";
}
