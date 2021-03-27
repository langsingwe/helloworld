package com.streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author weilc
 * @description
 * @className TextFileTest
 * @date 2020-05-25
 */
public class TextFileTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl", 75000, 1995, 12, 15);
        staff[1] = new Employee("Jack", 50000, 1994, 11, 11);
        staff[2] = new Employee("Mike", 60000, 1998, 10, 12);

        try (PrintWriter out = new PrintWriter("employee.dat","utf-8")){
            writeData(staff, out);
        }
        try (Scanner in = new Scanner(new FileInputStream("employee.dat"), "utf-8")) {
            Employee[] newStaff = readData(in);
            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }

    private static void writeData(Employee[] employees,PrintWriter out) throws IOException {
        out.println(employees.length);
        for (Employee e : employees) {
            writeEmployee(out, e);
        }
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    private static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay());
    }

    private static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        LocalDate hireDate = LocalDate.parse(tokens[2]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        return new Employee(name, salary, year, month, day);
    }
}
