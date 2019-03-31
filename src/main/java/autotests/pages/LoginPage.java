package autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[@data-test-id='goToEmailLink']")
    private WebElement goToEmailLink;

    @FindBy(xpath ="//input[@data-test-id='emailField']")
    private WebElement login;

    @FindBy(xpath ="//input[@data-test-id='passwordField']")
    private WebElement password;

    @FindBy(xpath ="//button[@data-test-id='loginFormSubmitButton']")
    private WebElement enter;


    public void clickGoToEmailLink()throws Exception{
        clickElement(goToEmailLink);
    }

    public void inputLogin(String loginName)throws Exception{
        clickElement(login);
        login.sendKeys(loginName);
    }
    public void inputPassword(String password)throws Exception{
        clickElement(this.password);
        this.password.sendKeys(password);
    }
    public void clickEnter()throws Exception{
        clickElement(enter);
        Thread.sleep(2000);
    }
}
