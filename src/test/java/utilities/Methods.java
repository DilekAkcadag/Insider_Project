package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Methods {

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }
    public static void scroll_partual() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 500);");

    }

    public static void switchToWindow(int sayi) {
        List<String> tumWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tumWindowHandles.get(sayi));
    }

    public static void selectOptionByTextUsingJS(String dropdownXPath, String optionText) {
        // Dropdown menüsünü tıklayın
        WebElement dropdown = Driver.getDriver().findElement(By.xpath(dropdownXPath));
        dropdown.click();

        // JavaScript ile seçeneğe tıklayın
        WebElement option = Driver.getDriver().findElement(By.xpath("//li[contains(text(),'" + optionText + "')]"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", option);
    }
}
