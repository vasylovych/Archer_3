package org.archer.Flows;

import java.util.Objects;

public class Car {
    private String title;
    private int price;
    private int mileage;
    private String listTime;
    private String location;
    private String href;

    // Title            //location //listTime    //mileage   //price
    public Car(String title, String location, String listTime, int mileage, int price, String href) {
        this.title = title;
        this.price = price;
        this.mileage = mileage;
        this.location = location;
        this.listTime = listTime;
        this.href = href;
    }

    // Getters for the fields

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mileage == car.mileage &&
                price == car.price &&
                Objects.equals(title, car.title) &&
                Objects.equals(location, car.location) &&
                Objects.equals(href, car.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, mileage, location, href);
    }

    public static String getInfo(Car car) {
        String carInfo = "############################\nTITLE: " + car.getTitle() + "\nLOCATION: " + car.getLocation() + "\nTIME LISTED: " + car.getListTime() + "\nMILEAGE: " + car.getMileage() + " k" + "\nPRICE: " + car.getPrice() + " $" + "\nLINK: " + car.getHref() +"\n############################";
        return carInfo;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMileage() {
        return mileage;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getListTime() {
        return listTime;
    }

    public void setListTime(String listTime) {
        this.listTime = listTime;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


}

