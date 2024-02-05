package org.archer.Website;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cragislist {

    @FindBy (xpath ="//*[@id=\"logo\"]/a" )
    public WebElement mainLogo;

    @FindBy (xpath ="//*[@id=\"sss0\"]/li[16]/a/span")
    public WebElement mainCarsParts;




}
