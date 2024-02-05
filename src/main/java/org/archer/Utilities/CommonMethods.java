package org.archer.Utilities;

import org.archer.Flows.Car;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CommonMethods {
    // Title            //location //listTime    //mileage   //price
    String s = "2005 Toyota Camry�ROCKVILLE�38 minutes ago�239k mi�$2,450pichere";

    public static Car textToCarObject(String title, String input, String href,TGBot tgBot) {
     //   System.out.println("Input is =" + input);
           String[] arr = input.split("[·]");

        if (arr.length < 4) {
            return new Car("Less the 4 array size", "-", "-", 0, 0, "");
        }

        int price = Integer.parseInt(arr[4].replaceAll("[^0-9]+", ""));
        int mileage = Integer.parseInt(arr[3].replaceAll("[^0-9]+", ""));
        Car another_Car = new Car(title, arr[1], arr[2], mileage, price, href);
        String posibleResponse ="TITLE is :" + another_Car.getTitle() + "\nLOCATION: " + another_Car.getLocation() + "\nTIME LISTED: " + another_Car.getListTime() + "\nMILEAGE: " + another_Car.getMileage() +" k"+ "\nPRICE: " + another_Car.getPrice()+" $"+"\nLink: "+ another_Car.getHref();
        System.out.println(posibleResponse);
        System.out.println();


        return another_Car;
    }

    public static int timeRandomizer (int minSleepDuration, int maxSleepDuration) {
        Random random = new Random();

        // Calculate a random sleep duration within the range
        int randomSleepDuration = minSleepDuration + random.nextInt(maxSleepDuration - minSleepDuration + 1);
        return randomSleepDuration;
    }

    public static String getTimestampInMinutes() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return now.format(formatter);
    }
}

