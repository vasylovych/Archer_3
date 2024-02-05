package org.archer.Flows;

import org.archer.Utilities.TGBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.archer.Utilities.CommonMethods.*;


public class CraigsListFlow {

    public static void crProcess(int x, TGBot tgBot, WebDriver driver) throws InterruptedException {

        boolean runflag = true;


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3850));
        driver.get("https://washingtondc.craigslist.org/search/cta?purveyor=owner#search=1~list~0~0");
        Thread.sleep(1750);

        Set<Car> cars = new HashSet<>();
        // Find all car elements on the page
        while (runflag) {

            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li[data-pid]")));
            Thread.sleep(timeRandomizer(1000, 2000));
            List<WebElement> carElements = driver.findElements(By.cssSelector("li[data-pid]"));
            Thread.sleep(timeRandomizer(700, 1000));


            // Iterate through the car elements and extract the car details.
            for (int count = 2; count <= x; count++) {
                WebElement carElement = carElements.get(count);
                wait.until(ExpectedConditions.visibilityOf(carElement));
                String title = carElement.findElement(By.xpath("/html/body/div[1]/main/div/div[5]/ol/li[" + count + "]/div/a")).getText();
                String href = carElement.findElement(By.xpath("/html/body/div[1]/main/div/div[5]/ol/li[" + count + "]/div/a")).getAttribute("href");
                String elementBody = carElement.findElement(By.xpath("/html/body/div[1]/main/div/div[5]/ol/li[" + count + "]/div/span")).getText();
                Car carr = textToCarObject(title, elementBody, href, tgBot);
                //Send message
                if ((cars.add(carr)) && (carr.getTitle().toLowerCase().contains("lexus"))) {
                    tgBot.sendMessage(534604212, getTimestampInMinutes() + "\n" + Car.getInfo(carr));
                }// else tgBot.sendMessage(534604212, " No update :" + getTimestampInMinutes());
                System.out.println(cars.size() + " Size of SET");


            }
            Thread.sleep(timeRandomizer(420000, 450000));
            driver.navigate().refresh();
        }

    }
}


