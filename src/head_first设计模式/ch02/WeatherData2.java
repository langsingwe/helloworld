package head_first设计模式.ch02;

import java.util.Observable;

/**
 * @Description
 * @ClassName WeatherData2
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class WeatherData2 extends Observable {
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData2() {}

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemp(){
        return temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
