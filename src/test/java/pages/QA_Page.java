package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QA_Page {

    public QA_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='See all QA jobs']")
    public WebElement seeAllQAJob;

    @FindBy(xpath = "//*[@id=\"top-filter-form\"]/div[1]/span/span[1]/span/span[2]")
    public WebElement locationSelection;

    @FindBy(xpath = "(//*[text()='Istanbul, Turkey'])[1]")
    public WebElement istanbulSelection;
    @FindBy(xpath = "(//*[text()='All'])[1]")
    public WebElement allSelection;

    @FindBy(xpath = "//*[text()='Senior Software Quality Assurance Engineer']")
    public WebElement qaTestFirst;
    @FindBy(xpath = "//*[text()='Software Quality Assurance Engineer']")
    public WebElement qaTestSecond;
    @FindBy(css = "#select2-filter-by-department-container")
    public WebElement departmentSelection;
    @FindBy(xpath = "(//*[text()='All'])[3]")
    public WebElement departmentSelectionAll;
    @FindBy(css = "#select2-filter-by-department-container > span")
    public WebElement departmentCancelSymbol;
    @FindBy(xpath = "(//*[text()='Istanbul, Turkey'])[2]")
    public WebElement locationControl;
    @FindBy(xpath = "(//*[text()='Quality Assurance'])[2]")
    public WebElement departmentControl;
    @FindBy(xpath = "(//*[text()='Quality Assurance'])[3]")
    public WebElement positionControl1;
    @FindBy(xpath = "(//*[text()='Quality Assurance'])[4]")
    public WebElement positionControl2;
    @FindBy(css = "#jobs-list > div:nth-child(1) > div > a")
    public WebElement viewRoleButton;

















}
