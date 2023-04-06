package WEB1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {

        super(driver);
    }
    @FindBy(xpath = ".//*[@id=\"login\"]/div[1]/label/input")
    private WebElement loginField;
    @FindBy(xpath = ".//*[@id=\"login\"]/div[2]/label/input")
    private WebElement passField;
    @FindBy(xpath = ".//*[@id=\"login\"]/div[3]/button/div")
    private WebElement loginSubmit;
    @FindBy(xpath = ".//div[@class=\"error-block svelte-uwkxn9\"]/h2")
    private WebElement errorHeader;


    public void login(String login, String pass) {
        Actions auth = new Actions(getDriver());
        auth
                .click(this.loginField)
                .sendKeys(login)
                .click(this.passField)
                .sendKeys(pass)
                .click(this.loginSubmit)
                .build()
                .perform();
    }

    public WebElement getErrorHeader() {
        return errorHeader;
    }
    public String getLoginPage() {
        return ("https://test-stand.gb.ru/login");
    }
}


