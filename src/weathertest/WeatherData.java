/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package weathertest;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class WeatherData implements Subject {
    
    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherData(){
           observers = new ArrayList();
    }
    
    public void registerObserver(Observer o){
           observers.add(o);
    }
    
    public void removeObserver(Observer o){
           int i = observers.indexOf(o);
           if (i >= 0){
               observers.remove(i);
           }
    }
    
    public void notifyObservers(){
           for(int i = 0; i < observers.size();i++){
               Observer observer = (Observer)observers.get(i);
               observer.update(temperature, humidity, pressure);
           }
    }
    
    public void measurementChanged(){
        notifyObservers();
    }
    
    public void setMeasurements(float temprature, float humidity, float pressure){
        this.temperature = temprature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
                
    }
    
}
