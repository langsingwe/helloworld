package head_first设计模式.ch11;

import java.lang.reflect.Proxy;

/**
 * @Description
 * @ClassName Test
 * @Author weilc
 * @Date 2021-01-28
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }

    public void test() {
        PersonBean joe = new PersonBeanImpl();
        joe.setName("Joe");
        PersonBean ownerProxy = getOwnerProxy(joe);
        System.out.println("Name = " + ownerProxy.getName());
        ownerProxy.setInterests("pc");
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {

        }
        System.out.println("rating=" + ownerProxy.getHotOrNotRating());


        PersonBean noOwnerProxy = getNoOwnerProxy(joe);
        System.out.println("name = " + noOwnerProxy);
        try {
            noOwnerProxy.setInterests("fuck");
        } catch (Exception e) {
        }
        noOwnerProxy.setHotOrNotRating(3);
        System.out.println("rating=" + noOwnerProxy.getHotOrNotRating());
    }

    public static PersonBean getOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new OwnerInvocationHandler(personBean));
    }

    public static PersonBean getNoOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new NoOwnerInvocationHandler(personBean));
    }
}
