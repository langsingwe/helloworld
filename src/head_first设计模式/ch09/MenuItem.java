package head_first设计模式.ch09;

/**
 * @Description
 * @ClassName MenuItem
 * @Author weilc
 * @Date 2021-01-21
 * @Version 1.0
 */
public class MenuItem {
    String name;
    String desc;
    String veget;
    double price;

    public MenuItem(String name, String desc, String veget, double price) {
        this.name = name;
        this.desc = desc;
        this.veget = veget;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVeget() {
        return veget;
    }

    public void setVeget(String veget) {
        this.veget = veget;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
