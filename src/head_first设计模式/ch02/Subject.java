package head_first设计模式.ch02;

/**
 * @Description
 * @ClassName Subject
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
