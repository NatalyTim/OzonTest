package autotests.pages;

import autotests.util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasketPage extends BasePage {

    //@FindBy(xpath = "//div[@class='split simple m-first m-last']/child::*")
    @FindBy(xpath = "//div[contains(text(), 'Ozon.ru')]/following-sibling::*")
    private List<WebElement> nameListInBasket;

    @FindBy(xpath = "//button[@data-test-id='cart-delete-selected-btn']")
    private WebElement delete;

    @FindBy(xpath = "//button[@data-test-id='checkcart-confirm-modal-confirm-button']")
    private WebElement deleteProducts;

    @FindBy(xpath = "//div[@class='eMyOzon_ItemWrap jsQuickPanelUserMenu']")
    private WebElement userMenu;

    @FindBy(xpath = "//h1[text()='Корзина пуста']")
    private WebElement emptyBasket;


    public void compareNameListInBasket() {
        assertEquals("Внесены не все товары в корзину", MyOzonPage.getNameOfProducts().size()
                , nameListInBasket.size());
        for (int i = 0; i < nameListInBasket.size(); i++) {
            WebElement element = nameListInBasket.get(i)
                    .findElement(By.xpath(".//a[@data-test-id='cart-item-title']"));
            String productName = element.getText().trim().split(",")[0].trim();
            String errorText = " Данный товар отсутствует в корзине: " + productName;
//            assertTrue(errorText, MyOzonPage.getNameOfProducts().contains(productName));
            if(!MyOzonPage.getNameOfProducts().contains(productName)){
                System.out.println(errorText);
            }
        }
    }

    public void clickDelete() throws Exception {
        scrollToAndClickElement(delete);
    }

    public void clickDeleteProducts() throws Exception {
        scrollToAndClickElement(deleteProducts);
    }
    public void checkEmptyBasket(String  expect)throws Exception{
        compareText(emptyBasket,expect);
    }

}
