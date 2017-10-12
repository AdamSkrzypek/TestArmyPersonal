import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static FirefoxDriver firefoxDriver = null;

    private DriverManager(){
    }

    public static FirefoxDriver getDriver(){
        if(firefoxDriver == null){
            firefoxDriver = new FirefoxDriver();
        }
        return firefoxDriver;
    }
}
