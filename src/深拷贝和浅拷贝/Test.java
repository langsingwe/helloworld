package 深拷贝和浅拷贝;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test
 * @date 2021.03.01
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person("zhangsan", 1);
        p1.setAddress("安徽省", "合肥市");

        Person p2 = (Person) p1.clone();

        System.out.println("修改引用对象前==========");
        p1.display("p1");
        p2.display("p2");

        System.out.println("修改引用对象后==========");
        p2.setAddress("北京市","西城区");
        p2.setPname("lisi");
        p2.setage(2);
        p1.display("p1");
        p2.display("p2");
    }

}
