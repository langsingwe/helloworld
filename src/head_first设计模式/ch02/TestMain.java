package head_first设计模式.ch02;

/**
 * @Description
 * @ClassName TestMain
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class TestMain {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        WeatherData2 weatherData2 = new WeatherData2();
        CurrentConditionDisplay2 currentConditionDisplay = new CurrentConditionDisplay2(weatherData2);
        StaticsDisplay staticsDisplay = new StaticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(78, 64, 28.5f);
        weatherData2.setMeasurements(78, 64, 28.5f);
    }
}
