package head_first设计模式.ch12;

/**
 * @Description
 * @ClassName AbstractDuckFactory
 * @Author weilc
 * @Date 2021-01-29
 * @Version 1.0
 */
public abstract class AbstractDuckFactory  {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedheadDuck();
    public abstract Quackable createDuckCall();
    public abstract Quackable createRubberDuck();
}
