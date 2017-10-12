import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PersonalPage extends BasePage{

    private final By inputFirstName = By.xpath("//input[@formcontrolname='name']");
    private final By inputLastName = By.xpath("//input[@formcontrolname='surname']");
    private final By buttonGender = By.name("gender");
    private final By buttonCalendar = By.cssSelector(".datepicker-container");
    private final By buttonCalendarSelectYear = By.xpath("//div[@class='datepicker-input-icon armyicon-calendar']");
    private final By allYears = By.xpath("//button[@type='button']");
    private final By correctYear = By.cssSelector("span.year:nth-child(75)");
    private final By correctMonth = By.cssSelector(".ion-ios-arrow-back");
    private final By allDays = By.cssSelector(".datepicker-calendar-days-container");
    private final By correctDay =By.xpath("//span[contains(.,'             24           ')]");
    private final By buttonSave = By.xpath("//button[@class='btn btn-default save']");

    public void Personal(String name, String lastName){

        firefoxDriver.findElement(inputFirstName).sendKeys(name);
        firefoxDriver.findElement(inputLastName).sendKeys(lastName);
        firefoxDriver.findElement(buttonGender).click();

        firefoxDriver.findElement(buttonCalendar).click();
        firefoxDriver.findElement(buttonCalendarSelectYear).click();

        List<WebElement> myElementsYear =firefoxDriver.findElements(allYears);
        for (WebElement e: myElementsYear) {
            if (e.getText().contains("1991")){
                firefoxDriver.findElement(correctYear).click();
            }
        }
        for (int setMonth=0;setMonth<9;setMonth++) {
            firefoxDriver.findElement(correctMonth).click();
        }

        List<WebElement> myElementsDay = firefoxDriver.findElements(allDays);
        for (WebElement e: myElementsDay) {
            if (e.getText().contains("24")){
                firefoxDriver.findElement(correctDay);
            }

        }

        firefoxDriver.findElement(buttonSave).click();
    }
}
