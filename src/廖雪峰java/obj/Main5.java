package com.java.obj;

/**
 * @author weilc
 * @description
 * @className Main5
 * @date 2020-06-04
 */
public class Main5 {
    public static void main(String[] args) {
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }

    static String buildInsertSql(String table, String[] fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(table).append(" (");
        for(int i = 0;i<fields.length;i++){
            sb.append(fields[i]);
            if(i!=2) {
                sb.append(", ");
            }
        }
        sb.append(") VALUES (?, ?, ?)");
        return sb.toString();
    }

}
