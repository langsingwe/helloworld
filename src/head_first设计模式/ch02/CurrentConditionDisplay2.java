package head_first设计模式.ch02;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description
 * @ClassName CurrentConditionDisplay2
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class CurrentConditionDisplay2 implements Observer, DisplayElement {

    Observable observable;
    private float temp;
    private float humidity;

    public CurrentConditionDisplay2(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前状态。。。。。");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData2) {
            WeatherData2 weatherData2 = (WeatherData2) o;
            this.temp = weatherData2.getTemp();
            this.humidity = weatherData2.getHumidity();
            display();
        }
    }
}
