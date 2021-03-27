package java核心技术.defaultmethod;

/**
 * @Description
 * @ClassName DefaultMethodChild
 * @Author weilc
 * @Date 2020-11-12
 * @Version 1.0
 */
public class DefaultMethodChild implements DefaultMethodFather, DefaultMethodFather2 {
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "child";
    }

    public static void main(String[] args) {
        DefaultMethodChild child = new DefaultMethodChild();
        String name = child.getName();
        System.out.println(name);
    }

}
