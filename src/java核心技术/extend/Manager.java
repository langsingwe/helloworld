package java核心技术.extend;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Manager
 * @date 2021.03.06
 */
public class Manager extends Employee {
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }
}
