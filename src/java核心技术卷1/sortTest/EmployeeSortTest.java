package java核心技术卷1. sortTest;

import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry", 3000);
        staff[1] = new Employee("Mary", 2000);
        staff[2] = new Employee("Tom", 5000);

        Arrays.sort(staff);

        for (Employee employee : staff) {
            System.out.println("name = " + employee.getName() + " , salary =" + employee.getSalary());
        }
    }
}
