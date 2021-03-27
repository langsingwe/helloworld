package java核心技术.statis;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Employee
 * @date 2021.03.06
 */
public class Employee {
    private static Integer nextId = 1;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setId(1);


        Employee e2 = new Employee();
        e2.setId(2);

        
    }
}
