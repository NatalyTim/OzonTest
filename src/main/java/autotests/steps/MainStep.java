package autotests.steps;

import autotests.pages.MainPage;
import cucumber.api.java.en.When;

public class MainStep {
    MainPage mainPage = new MainPage();

    @When("Зайти в личный кабинет")
    public void clickMyOzon() throws Exception {
        mainPage.clickEnter();
        System.out.println("2.Зайти в личный кабинет");
    }

    @When("Нажать на кнопку Вход или регистрация")
    public void clickEnter() throws Exception {
        mainPage.clickEnterItem();
        System.out.println("2.Нажать на кнопку Вход или регистрация");
    }

    @When("Нажать на кнопку Выйти")
    public void clickExit() throws Exception {
        mainPage.clickExit();
        Thread.sleep(2000);
        System.out.println("2.Нажать на кнопку Выйти");
    }

}
