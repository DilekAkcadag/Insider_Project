package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Insider_Home_Page {

    public Insider_Home_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//*[@id=\"navbarDropdownMenuLink\"])[5]")
    public WebElement companyLocate;
    @FindBy (xpath = "//*[text()='Careers']")
    public WebElement careersLocate;








}
