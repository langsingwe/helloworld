package 设计模式.创建型模式.原型模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Test
 * @date 2021.08.10
 */
public class Test {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        copyAndCompare(shapes,shapesCopy);
    }

    private static void copyAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes 是不同的对象");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": 他们相同");
                } else {
                    System.out.println(i + ": 他们不相同");
                }
            } else {
                System.out.println(i + ": Shapes 是相同的对象");
            }
        }
    }
}
