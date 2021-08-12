package 设计模式.创建型模式.原型模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Rectangle
 * @date 2021.08.10
 */
public class Rectangle extends Shape {
    public int width;
    public int height;

    public Rectangle(){}

    public Rectangle(Rectangle target) {
        super(target);
        if (target != null) {
            this.width  = target.width;
            this.height = target.height;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Rectangle) || !super.equals(object2)) return false;
        Rectangle shape2 = (Rectangle) object2;
        return shape2.width == width && shape2.height == height;
    }
}
