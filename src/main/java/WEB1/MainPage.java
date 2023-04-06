package WEB1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

    public class MainPage extends AbstractPage {

        @FindBy(xpath = ".//li[@class=\"svelte-1rc85o5 mdc-menu-surface--anchor\"]/a")
        private WebElement menuAcc;
        @FindBy(xpath = ".//ul[@role=\"menu\"]/li[3]")
        private  WebElement logout;
        @FindBy(xpath = ".//a[@href=\"/posts/16084\"]")
        private WebElement lastPost;

        @FindBy(xpath = ".//a[@href=\"/posts/16084\"]/img")
        private WebElement lastPostImg;

        @FindBy(xpath = ".//a[@href=\"/posts/16084\"]/h2")
        private WebElement lastPostTitle;

        @FindBy(xpath = ".//a[@href=\"/posts/16084\"]/div")
        private WebElement lastPostDescription;

        @FindBy(xpath =".//a[@href=\"/posts/15979\"]")
        private WebElement twoPagePost;

        @FindBy(xpath =".//a[@href=\"/posts/15979\"]/img")
        private WebElement twoPageImg;

        @FindBy(xpath =".//a[@href=\"/posts/15979\"]/h2")
        private WebElement twoPageTitle;

        @FindBy(xpath =".//a[@href=\"/posts/15979\"]/div")
        private WebElement twoPagePostDescription;

        @FindBy(xpath = ".//a[@class=\"logo svelte-1rc85o5\"]/span")
        private WebElement logoHome;

        @FindBy(xpath = ".//div[@class=\"content\"]")
        private WebElement noContent;

        @FindBy(xpath = ".//button[@aria-pressed]")
        private WebElement sortButton;

        @FindBy(xpath = ".//a[@href=\"/?page=1\"]")
        private WebElement previousPage;

        @FindBy(xpath = ".//div[@class=\"pagination svelte-d01pfs\"]/a[2]")
        private WebElement nextPage;


        public void clickSort() {
            this.sortButton.click();
        }
        public void clickNextPage() {
            this.nextPage.click();
        }
        public void clickPrevPage() {
            this.previousPage.click();
        }
        public void logout(){
            Actions logout = new Actions(getDriver());
            logout
                    .click(this.menuAcc)
                    .click(this.logout)
                    .build()
                    .perform();
        }
        public MainPage(WebDriver driver) {
            super(driver);
        }

        public WebElement getLogoHome() {
            return logoHome;
        }
        public WebElement getMenuAcc() {
            return menuAcc;
        }
        public WebElement getLastPost() {
            return lastPost;
        }
        public WebElement getLastPostImg() {
            return lastPostImg;
        }
        public WebElement getLastPostTitle() {
            return lastPostTitle;
        }
        public WebElement getLastPostDescription() {
            return lastPostDescription;
        }
        public WebElement getLogout() {
            return logout;
        }
        public WebElement getPreviousPage() {
            return previousPage;
        }
        public WebElement getNextPage() {
            return nextPage;
        }
        public WebElement getNoContent() {
            return noContent;
        }
        public WebElement getSortButton() {
            return sortButton;
        }

    }


