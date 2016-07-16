package ObserverExample1;

import java.util.*;

public class CurrentConditionsDisplay implements java.util.Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    Observable observable;

    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: "+ temperature+ "F degrees and "+ humidity + "% humidity, atmosphere pressure "+ pressure + " Bar");
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }

    }
}
