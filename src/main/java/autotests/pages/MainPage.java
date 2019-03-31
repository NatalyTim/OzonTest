package autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@data-test-id='header-my-ozon-icon']")
    private WebElement myOzon;

    @FindBy(xpath = "//*[contains(text(),'Вход')]")
    private WebElement enterItem;

    @FindBy(xpath = "//div[@class='header-top']")
    private WebElement top;

    @FindBy(xpath = "//*[contains(text(),'Выйти')]")
    private WebElement exit;


    public void clickEnter() throws Exception {
        scrollToElement(top);
        waitVisible(myOzon);
        waitClickable(myOzon);
        clickElement(myOzon);
    }

    public void clickEnterItem() throws Exception {
        clickElement(enterItem);
    }

    public void clickExit() throws Exception {
        clickElement(exit);
    }

}
