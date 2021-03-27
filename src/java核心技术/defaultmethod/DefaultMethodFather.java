package java核心技术.defaultmethod;

/**
 * @Description
 * @ClassName DefaultMethodFather
 * @Author weilc
 * @Date 2020-11-12
 * @Version 1.0
 */
public interface DefaultMethodFather {
    long getId();

    default String getName() {
        return "father 1";
    }
}
