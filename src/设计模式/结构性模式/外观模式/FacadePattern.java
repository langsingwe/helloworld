package 设计模式.结构性模式.外观模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className FacadePattern
 * @date 2021.08.16
 */

//外观角色
class Facade {
    private SubSystem1 system1 = new SubSystem1();
    private SubSystem2 system2 = new SubSystem2();
    private SubSystem3 system3 = new SubSystem3();

    public void method() {
        system1.method1();
        system2.method2();
        system3.method3();
    }
}

//子系统1
class SubSystem1 {
    public void method1() {
        System.out.println("子系统1的method1被调用!");
    }
}

//子系统2
class SubSystem2 {
    public void method2() {
        System.out.println("子系统2的method2被调用!");
    }
}

//子系统3
class SubSystem3 {
    public void method3() {
        System.out.println("子系统3的method3被调用!");
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}
