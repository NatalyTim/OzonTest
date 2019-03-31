package autotests.steps;

import autotests.pages.LoginPage;
import cucumber.api.java.en.When;

public class LoginStep {

    private LoginPage loginPage = new LoginPage();

    @When("Нажать войти по почте")
    public void clickGoToEmailLink()throws Exception {
        loginPage.clickGoToEmailLink();
        System.out.println("Нажать войти по почте");
    }
    @When("Ввести логин \"(.*)\"")
    public void inputLogin(String loginEmail)throws Exception{
        loginPage.inputLogin(loginEmail);
        System.out.println("Ввести логин");
    }
    @When("Ввести пароль \"(.*)\"")
    public void inputPassword(String password)throws Exception{
        loginPage.inputPassword(password);
        System.out.println("Ввести пароль");
    }
    @When("Войти")
    public void clickEnter()throws Exception{
        loginPage.clickEnter();
        System.out.println("Войти");
    }
}
