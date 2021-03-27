package head_first设计模式.ch02;

/**
 * @Description
 * @ClassName ForecastDisplay
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class ForecastDisplay implements Observer,DisplayElement {

    private float temp;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("天气预报");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
