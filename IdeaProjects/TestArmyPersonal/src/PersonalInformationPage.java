import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalInformationPage extends BasePage {
    private final By selectedSubPageOnLeftMenu = By.cssSelector("li.al-sidebar-list-item.selected");
    private final By flashMessage = By.xpath("//p[contains(.,'Profile has been saved')]");



    public String getSelectedSubPageOnLeftMenu(){
        WebDriverWait webDriverWait = new WebDriverWait(firefoxDriver, 4);
        webDriverWait.until(x -> x.findElement(selectedSubPageOnLeftMenu));
        return firefoxDriver.findElement(selectedSubPageOnLeftMenu).getText();
    }

    public String getMessageReceived(){
        WebDriverWait webDriverWait = new WebDriverWait(firefoxDriver,4);
        webDriverWait.until(y->y.findElement(flashMessage));
        return firefoxDriver.findElement(flashMessage).getText();

    }
}

