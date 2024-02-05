package org.archer;

import org.archer.Utilities.Driver;
import org.archer.Utilities.TGBot;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;

import static org.archer.Flows.CraigsListFlow.crProcess;
import static org.archer.Utilities.CommonMethods.getTimestampInMinutes;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        boolean runFlag = true;

        long chatId = System.getenv("CHATID");
        String apikey = System.getenv("APIKEY");
        //_______________________________________________________________
        TGBot mb = new TGBot(apikey);
        mb.start();
        mb.sendMessage(chatId, "Started: " + getTimestampInMinutes());
        WebDriver driver = Driver.setUp();

        System.out.println("Check 1");

        //Craigslist process (How many last entities will process, bot object, driver)

        crProcess(2, mb, driver);


        mb.sendMessage(chatId, "Stopped ---------------------------\n: " + LocalDateTime.now());

        Driver.tearDown();
        System.exit(0);

    }


}