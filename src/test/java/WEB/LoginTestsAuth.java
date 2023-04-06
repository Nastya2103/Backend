package WEB;
import WEB1.LoginPage;
import WEB1.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;



public class LoginTestsAuth extends AbstractTest {


    @Test
    @DisplayName("Авторизация с валидными данными")
    @Tag("Positive")
    public void LoginValidTest() {
        getDriver().get("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("Nastya2103", "7b9b0f8005");

        WEB1.MainPage mainPage = new WEB1.MainPage(getDriver());

        WebElement logoHome = mainPage.getLogoHome();
        Assertions.assertNotNull(logoHome);

        String textAccount = mainPage.getMenuAcc().getText();
        Assertions.assertEquals(textAccount, "Hello, Nastya2103");

        WebElement lastPost = mainPage.getLastPost();
        Assertions.assertNotNull(lastPost);

        String actualUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://test-stand.gb.ru/");
        getDriver().close();
    }

    @Test
    @DisplayName("Авторизация с невалидными данными: пустой логин")
    @Tag("Negative")
    public void LoginInValidTestEmptyLogin() {
        getDriver().get("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("", "7b9b0f8005");

        WebElement error = loginPage.getErrorHeader();
        Assertions.assertNotNull(error);
        Assertions.assertEquals(error.getText(), "401");

        String actualUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://test-stand.gb.ru/login");
        getDriver().close();
    }

    @Test
    @DisplayName("Авторизация с невалидными данными: незарегистрированный пользователь")
    @Tag("Negative")
    public void LoginInValidTestNoRegistr() {
        getDriver().get("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("Andreeva", "7b9b0f8005");
        WebElement error = loginPage.getErrorHeader();
        Assertions.assertNotNull(error);
        Assertions.assertEquals(error.getText(), "401");

        String actualUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://test-stand.gb.ru/login");
        getDriver().close();
    }


    @Test
    @DisplayName("Авторизация c валидными граничными значениями. Логин - 3 символа.")
    @Tag("Positive")
    public void LoginValidCornerTestShort() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("Nas", "b05c017361");

        WEB1.MainPage mainPage = new WEB1.MainPage(getDriver());
        WebElement logoHome = mainPage.getLogoHome();
        Assertions.assertNotNull(logoHome);

        String actualUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://test-stand.gb.ru/login");
        getDriver().close();
    }

    @Test
    @DisplayName("Авторизация c валидными граничными значениями. Логин - 4 символа.")
    @Tag("Positive")
    public void LoginValidCornerTestFour() {
        getDriver().get("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage(getDriver());
            loginPage.login("Nast", "5c21fdd692");

        WEB1.MainPage mainPage = new WEB1.MainPage(getDriver());
        WebElement logoHome = mainPage.getLogoHome();
        Assertions.assertNotNull(logoHome);

        String actualUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://test-stand.gb.ru/login");
        getDriver().close();
    }

    @Test
    @DisplayName("Авторизация c валидными граничными значениями. Логин - 20 символов.")
    @Tag("Positive")
    public void LoginValidCornerTestLong() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("Nastya2103Adreeva198", "c9dba6ddf9");

        WEB1.MainPage mainPage = new WEB1.MainPage(getDriver());
        WebElement logoHome = mainPage.getLogoHome();
        Assertions.assertNotNull(logoHome);

        String actualUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://test-stand.gb.ru/login");
        mainPage.logout();
    }

    @Test
    @DisplayName("Авторизация c валидными граничными значениями. Логин - 19 символов.")
    @Tag("Positive")
    public void LoginValidCornerTestNineteen() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("Nastya2103Adreeva19", "a2840a9c1c");

        WEB1.MainPage mainPage = new WEB1.MainPage(getDriver());
        WebElement logoHome = mainPage.getLogoHome();
        Assertions.assertNotNull(logoHome);

        String actualUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://test-stand.gb.ru/login");
        mainPage.logout();
    }

    @Test
    @DisplayName("Авторизация c невалидными граничными значениями. Логин более 20 символов.")
    @Tag("Negative")
    public void LoginInValidCornerTestLong() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("Nastya2103Adreeva1989", "f5aca9fcd1");

        WEB1.MainPage mainPage = new WEB1.MainPage(getDriver());
        WebElement logoHome = mainPage.getLogoHome();
        Assertions.assertNotNull(logoHome);

        WebElement error = loginPage.getErrorHeader();
        Assertions.assertNotNull(error);
        Assertions.assertEquals(error.getText(), "401");

        String actualUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://test-stand.gb.ru/login");
    }

    @Test
    @DisplayName("Авторизация c невалидными граничными значениями. Логин менее 3 символов.")
    @Tag("Negative")
    public void LoginInValidCornerTestShort() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("hg", "40fe9ad494");

        WEB1.MainPage mainPage = new MainPage(getDriver());
        WebElement logoHome = mainPage.getLogoHome();
        Assertions.assertNotNull(logoHome);

        WebElement error = loginPage.getErrorHeader();
        Assertions.assertNotNull(error);
        Assertions.assertEquals(error.getText(), "401");

        String actualUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals(actualUrl, "https://test-stand.gb.ru/login");
    }
}








