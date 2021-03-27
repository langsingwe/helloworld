package head_first设计模式.ch02;

/**
 * @Description
 * @ClassName StaticsDisplay
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class StaticsDisplay implements Observer,DisplayElement {
    private float temp;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public StaticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("统计信息布告板：温度：" + temp + ", 湿度：% " + humidity + ", 气压：" + pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
