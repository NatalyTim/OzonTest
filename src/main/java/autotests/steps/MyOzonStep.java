package autotests.steps;

import autotests.pages.MyOzonPage;
import cucumber.api.java.en.When;

public class MyOzonStep {
    private MyOzonPage myOzonPage = new MyOzonPage();

    @When("Ввести название продукта \"(.*)\"")
    public void clickLookForOnOzon(String nameOfProduct)throws Exception{
        myOzonPage.clickLookForOnOzon(nameOfProduct);
        System.out.println("Ввести название продукта");
    }

    @When("Нажать поиск")
    public void clickSearchButton()throws Exception{
        myOzonPage.clickSearchButton();
        System.out.println("Нажать поиск");
    }
    @When("Выбрать (\\d+) товаров")
    public void choseProducts(int quantity)throws Exception{
        myOzonPage.choseProduct(quantity);
        System.out.println("Выбрать товары");
    }
    @When("Зайти в корзину")
    public void clickBasket()throws Exception{
        myOzonPage.clickBasket();
        System.out.println("Зайти в корзину");
    }
}
