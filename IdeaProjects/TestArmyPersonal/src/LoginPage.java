import org.openqa.selenium.By;



public class LoginPage extends BasePage{

    private final By inputLogin = By.cssSelector("#inputEmail3");
    private final By inputPassword = By.cssSelector("#inputPassword3");
    private final By loginButton = By.cssSelector("Button.btn");

    public void Login(String username, String password){
        System.out.println("Login with: " + username + ", " + password);
        firefoxDriver.findElement(inputLogin).sendKeys(username);
        firefoxDriver.findElement(inputPassword).sendKeys(password);
        firefoxDriver.findElement(loginButton).click();
    }
}
