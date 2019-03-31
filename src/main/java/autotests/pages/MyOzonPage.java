package autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class MyOzonPage extends BasePage {
    private static List<String> nameOfProducts = new ArrayList<String>();

    @FindBy(xpath = "search_bar_container")
    private WebElement lookForOnOzon;
    @FindBy(xpath = "//input[@data-test-id='header-search-input']")
    private WebElement input;

    @FindBy(xpath = "//a[@class='link-base forgot-password-link']")
    private WebElement windowLogin;

    @FindBy(xpath = "//button[@data-test-id='header-search-go']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='tiles']/child::*")
    private List<WebElement> listOfProduct;

    @FindBy(xpath = "//div[@data-test-id='header-cart']")
    private WebElement basket;

    public void waitUntilLoginPageClose() {
        wait.until(ExpectedConditions.invisibilityOf(windowLogin));
    }

    public void clickLookForOnOzon(String nameOfProduct) throws Exception {
        //     waitUntilLoginPageClose();//Не работает.
//        waitVisible(input);//Не работает.
//        waitClickable(input);//Не работает.
        for (int i = 0; i < 100; i++) {
            System.out.println("I= " + i);
            try {
                input.click();
                input.sendKeys(nameOfProduct);
                return;
            } catch (Exception e) {
                if (i >= 99)
                    throw new Exception("Ввести текст невозможно");
                continue;
            }
        }

    }

    public void clickSearchButton() throws Exception {
        clickElement(searchButton);
    }

    public void choseProduct(int quantity) throws Exception {
        int quantityOfProduct = Math.min(listOfProduct.size(), quantity);
        nameOfProducts.clear();

        for (int i = 0; i < quantityOfProduct; i++) {
            WebElement button = listOfProduct.get(i).findElement(By.xpath(".//button[@data-test-id='tile-buy-button']/.."));
            scrollToAndClickElement(button);
            WebElement name = listOfProduct.get(i).findElement(By.xpath(".//div[@data-test-id='tile-name']"));
            nameOfProducts.add(name.getText().trim());
            System.out.println(name.getText().trim());
        }

    }

    public void clickBasket() throws Exception {
        scrollToAndClickElement(basket);
    }

    public static List<String> getNameOfProducts() {
        return nameOfProducts;
    }

}
