package head_first设计模式.ch02;

/**
 * @Description
 * @ClassName CurrentConditionDisplay
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class CurrentConditionDisplay implements Observer,DisplayElement {
    private float temp;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前状态布告板：温度：" + temp + ", 湿度：% " + humidity);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }
}
