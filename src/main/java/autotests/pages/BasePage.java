package autotests.pages;

import autotests.util.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class BasePage {
    protected WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void waitVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitMessage(WebElement element, String expected) {
        ExpectedCondition<Boolean> condition
                = (WebDriver driver) -> {
            if (expected.equalsIgnoreCase(element.getText()))
                return true;
            else
                return false;
        };
        wait.until(condition);
    }


    public void selectMenuItem(List<WebElement> items, String itemName) {
        for (WebElement item : items)
            if (item.getText().equals(itemName)) {
                System.out.println("Item.getText = " + item.getText());
                item.click();
                return;
            }
    }

    public void compareText(WebElement element, String expect) throws Exception {
        scrollElementToBottom(element);
        waitMessage(element, expect);
        String errorText = "Исходного текста нет. Actual =  " + element.getText()
                + "; expected = " + expect;
        assertTrue(errorText,
                expect.contains(element.getText()));
        System.out.println("Исходный текст есть:" + expect);
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void scrollElementToBottom(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void scrollToAndClickElement(WebElement element) throws Exception {
        scrollToElement(element);
//        waitVisible(element);
//        waitClickable(element);
        element.click();
    }

    public void clickElement(WebElement element) throws Exception {
        waitVisible(element);
        waitClickable(element);
        element.click();
        return;

    }

    public void pressCtrlA(WebElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }

    public void clickDropDown(WebElement element, String itemPath) throws Exception {
        element.click();
        WebElement el = DriverManager.getDriver().findElement(
                By.xpath(itemPath));
        el.click();
        System.out.println(el.getText());
    }
}
