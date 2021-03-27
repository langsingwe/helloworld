package head_first设计模式.ch12;

/**
 * @Description
 * @ClassName QuackObservable
 * @Author weilc
 * @Date 2021-01-29
 * @Version 1.0
 */
public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();
}
