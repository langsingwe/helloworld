package 深拷贝和浅拷贝;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Student
 * @date 2021.03.01
 */
public class Person implements Cloneable{

    public String pname;
    public int age;
    public Address address;
    public Person() {}

    public Person(String pname,int age){
        this.pname = pname;
        this.age = age;
        this.address = new Address();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.address = (Address) address.clone();
        return p;
    }

    public void setAddress(String provices,String city ){
        address.setAddress(provices, city);
    }
    public void display(String name){
        System.out.println(name+":"+"pname=" + pname + ", age=" + age +","+ address);
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getage() {
        return age;
    }

    public void setage(int age) {
        this.age = age;
    }

}
