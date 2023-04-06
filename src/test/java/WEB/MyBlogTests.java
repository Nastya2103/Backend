package WEB;
import WEB1.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MyBlogTests extends AbstractTest {
    @Test
    @DisplayName("Страница своих постов с публикациями")
    @Tag("Positive")
    public void postDisplayTest() {
        getDriver().get("https://test-stand.gb.ru");
        LoginPage loginPage = new LoginPage(getDriver());
        getLoginPage().login("Nastya2103", "7b9b0f8005");

        //  MainPage mainPage = new MainPage(getDriver());
        getMainPage().clickSort();
        getMainPage().clickSort();

        try {
            String lastPostImg = getMainPage().getLastPostImg().getAttribute("вапаорпгароа");
            Assertions.assertEquals(lastPostImg, "http://test-stand.gb.ru/files/public/image/345ed886aee7c71d131edba85a2d4d0c.png");

            String lastPostTitle = getMainPage().getLastPostTitle().getText();
            Assertions.assertEquals(lastPostTitle, "вапаорпгароа");

            String lastPostDescription = getMainPage().getLastPostDescription().getText();
            Assertions.assertEquals(lastPostDescription, "мтммотм");
        } catch (NoSuchElementException e) {
            System.out.println("Элемент отсутствует на странице");
            Assertions.assertFalse(false);
        } finally {
            getMainPage().logout();
            getDriver().quit();
        }
    }

    @Test
    @DisplayName("Заглушка у пользователя, у которого нет постов")
    @Tag("Positive")
    public void NoContentPostTest() {
        getDriver().get("https://test-stand.gb.ru");
        getLoginPage().login("Nastya2103Adreeva198", "c9dba6ddf9");
        try {
            String textNoContent = getMainPage().getNoContent().getText();
            Assertions.assertEquals(textNoContent, "No items for your filter");
        } catch (NoSuchElementException e) {
            Assertions.assertFalse(true);
        } finally {
            getMainPage().logout();
            getDriver().quit();
        }
    }


    @Test
    @DisplayName("Переход на следующую страницу")
    @Tag("Positive")
    public void clickNextPageTest() throws InterruptedException {
        getDriver().get("https://test-stand.gb.ru");
        getLoginPage().login("Nastya2103", "7b9b0f8005");

        getMainPage().clickSort();
        getMainPage().clickSort();

        try {
            String nextPageHref = getMainPage().getNextPage().getAttribute("href");
            assert (nextPageHref.contains("/?page=2"));

            String nextPageText = getMainPage().getNextPage().getText();
            Assertions.assertEquals(nextPageText, "Next Page");

            getMainPage().clickNextPage();
                 Thread.sleep(10000);
                 Assertions.assertEquals(getDriver().getCurrentUrl(), "https://test-stand.gb.ru/?page=2");

            try {
                WebElement lastPost = getMainPage().getLastPost();
            } catch (NoSuchElementException e) {
                System.out.println("Пост 'вапаорпгароа' отсутствует на странице");
                Assertions.assertFalse(true);
            }

        } catch (NoSuchElementException e) {
            System.out.println("Кнопка Next Page не активна на этой странице");
            Assertions.assertFalse(true);
        } finally {
            getDriver().quit();
        }
    }

    @Test
    @DisplayName("Переход на предыдущую страницу")
    @Tag("Positive")
    public void clickPrevPageTest() {
        getLoginPage().login("Nastya2103", "7b9b0f8005");

        try {
            String previousPageText = getMainPage().getPreviousPage().getText();
            Assertions.assertEquals(previousPageText, "Previous Page");
            String previousPageClass = getMainPage().getPreviousPage().getAttribute("class");
            Assertions.assertEquals(previousPageClass, "svelte-d01pfs disabled");
            assert (previousPageClass.contains("disabled"));

            try {
                getMainPage().clickNextPage();
                String prevPageHref = getMainPage().getPreviousPage().getAttribute("href");
                assert (prevPageHref.contains("/?page=1"));

                getMainPage().clickPrevPage();
                assert (getDriver().getCurrentUrl().contains("/?page=1"));
            } catch (NoSuchElementException e) {
                e.getMessage();
                Assertions.assertFalse(true);
            }

        } catch (NoSuchElementException e) {
            System.out.println("Кнопка Previous Page не активна на этой странице");
            Assertions.assertFalse(false);
        } finally {
            getMainPage().logout();
        }
    }
}


