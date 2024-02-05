package org.archer.Website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Facebook {


    @FindBy(id="email")
    public WebElement start_email_textBox;

    @FindBy(id="pass")
    WebElement start_pass_textBox;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    WebElement start_login_Btn;

    @FindBy(xpath = "(//input[@aria-label='Search Marketplace'])[1]")
    WebElement search_box;










}
