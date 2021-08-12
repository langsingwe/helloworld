package 设计模式.创建型模式.原型模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Circle
 * @date 2021.08.10
 */
public class Circle extends Shape {
    public int radius;

    public Circle(){}

    public Circle(Circle target) {
        super(target);
        if (target != null) this.radius = target.radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circle) || !super.equals(object2)) return false;
        Circle shape2 = (Circle) object2;
        return shape2.radius == radius;
    }
}
