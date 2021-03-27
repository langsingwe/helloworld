package head_first设计模式.ch02;

/**
 * @Description
 * @ClassName Observer
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public interface Observer {
    void update(float temp, float humidity, float pressure);
}
