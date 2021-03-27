package test.集合类;

import java.io.*;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className TransientTest
 * @date 2021.03.19
 */
public class TransientTest {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");
        System.out.println("---------序列化前读取---------");
        System.out.println(user.toString());
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/weiliangchun/Downloads/a.txt"));
            out.writeObject(user);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/weiliangchun/Downloads/a.txt"));
            user = (User) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---------序列化后读取---------");
        System.out.println(user.toString());
    }

}

class User implements Externalizable {
    private String username;
    private transient String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(username);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        username = (String) in.readObject();
    }
}
