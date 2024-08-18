package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Careers_Page {

    public Careers_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[text()='Accept All']")
    public WebElement acceptCookie;

    @FindBy(xpath = "//*[text()='See all teams']")
    public WebElement seeAllTeamButton;

    @FindBy(css = "#career-our-location > div > div > div > div.col-12.col-md-6 > h3")
    public WebElement locations;

    @FindBy(xpath = "//*[text()='Life at Insider']")
    public WebElement life;




}
