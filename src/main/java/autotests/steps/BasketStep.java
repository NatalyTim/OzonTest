package autotests.steps;

import autotests.pages.BasketPage;
import cucumber.api.java.en.When;

public class BasketStep {

    BasketPage basketPage = new BasketPage();

    @When("Сравниваем внесенные товары")
    public void compareProducts()throws Exception{
        basketPage.compareNameListInBasket();
        System.out.println("Сравниваем внесенные товары");
        System.out.println("Все товары внесены");
    }
    @When("Удаляем содержимое корзины")
    public void clickDelete()throws Exception{
        basketPage.clickDelete();
        System.out.println("Удаляем содержимое корзины");
    }
    @When("Подтверждаем удаление")
    public void clickDeleteProducts()throws Exception{
        basketPage.clickDeleteProducts();
        System.out.println("Подтверждаем удаление");
    }
    @When("Проверяем корзину \"(.*)\"")
    public void checkEmptyBasket(String expect)throws Exception{
        System.out.println("Проверяем корзину");
        basketPage.checkEmptyBasket(expect);


    }

}
