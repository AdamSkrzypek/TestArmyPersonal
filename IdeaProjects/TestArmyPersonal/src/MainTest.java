import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {
    LoginPage loginPage = new LoginPage();
    PersonalPage personalPage = new PersonalPage();
    PersonalInformationPage personalInformationPage = new PersonalInformationPage();
    private final String loginURL = "https://my.testarmy.com/login";
    private final String PersonalURL = "https://my.testarmy.com/profile/personal";

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
    public void SetupTestSavedData(){
        DriverManager.getDriver().navigate().to(PersonalURL);

    }
    @Test
    public void CheckingSavedData(){
        personalPage.inputFirstAndLastName("Adam", "Skrzypek");
        personalPage.selectGender();
        personalPage.enterYearOfBirth();
        personalPage.savePersonalData();
        Assert.assertEquals(personalInformationPage.getMessageReceived(),"Profile has been saved","Something went wrong");
    }

    @AfterTest

    public void QuitTest() {

        DriverManager.getDriver().quit();
    }
}