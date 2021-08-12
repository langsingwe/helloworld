package 设计模式.创建型模式.原型模式;

import java.util.Objects;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Shape
 * @date 2021.08.10
 */
public abstract class Shape {
    public int x;
    public int y;
    public String color;

    public Shape(){}

    public Shape(Shape target) {
        if (null != target) {
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Shape)) return false;
        Shape shape2 = (Shape) obj;
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
    }
}
