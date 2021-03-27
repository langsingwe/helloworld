package head_first设计模式.ch10;

import java.io.Serializable;

/**
 * @Description
 * @ClassName Staet
 * @Author weilc
 * @Date 2021-01-25
 * @Version 1.0
 */
public interface State extends Serializable {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
