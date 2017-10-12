import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {
    LoginPage loginPage = new LoginPage();
    PersonalPage personalPage = new PersonalPage();
    PersonalInformationPage personalInformationPage = new PersonalInformationPage();
    private final String loginURL = "https://my.testarmy.com/login";

    @BeforeTest
    public void SetupTestLogin() {

        DriverManager.getDriver().get(loginURL);
    }
    @Test
    public void LoginWithValidData(){
        loginPage.Login("adam_skr@interia.pl", "hasloTab2017");
        Assert.assertEquals(personalInformationPage.getSelectedSubPageOnLeftMenu(), "Dashboard",
                "After Login Dashboard should be selected!");
    }

    @Test
    public void CheckingSavedData(){
        personalPage.Personal("Adam", "Skrzypek");
        Assert.assertEquals(personalInformationPage.getMessageReceived(),"Profile has been saved","Something went wrong");
    }

    @AfterTest

    public void QuitTest() {

        DriverManager.getDriver().quit();
    }
}