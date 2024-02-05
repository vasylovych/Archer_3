package org.archer.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.sql.SQLOutput;

public class Driver {
    public static WebDriver driver;

    public static WebDriver setUp() {
        String driverPath = System.getenv("DRIVER");
        String binaries = System.getenv("BINARIES");
        System.out.println(driverPath);
        System.out.println(binaries);


        System.getenv().forEach((k, v) -> System.out.println(k + ":" + v));

        System.setProperty("webdriver.gecko.driver", driverPath);
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(binaries);
        options.setHeadless(true);
        options.addPreference("general.useragent.override", "Mozilla/5.10 (Windows NT 10.0; Win64; x64; rv:88.0) Gecko/20100101 Firefox/88.0");
        driver = new FirefoxDriver(options);
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
