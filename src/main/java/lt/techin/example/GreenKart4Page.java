package lt.techin.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GreenKart4Page extends GreenKartPage{

    @FindBy(xpath = "//*[@id=\"search-field\"]")
    private WebElement searchQueryInput;

    @FindBy(xpath = "//tbody//tr//td[1]")
    private List<WebElement> tdDisplayedListItems;

    @FindBy(css = "div.col-xs-8 > ul > li:nth-child(1) > a")
    private WebElement firstPaginationButton;
    @FindBy(css = "div.col-xs-8 > ul > li:nth-child(2) > a")
    private WebElement previousPaginationButton;

    public GreenKart4Page(WebDriver driver) {
        super(driver);
    }

    //js scroll to element for scrolling pages
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //first pagination button click
    public void clickFirstPaginationButton(){
        scrollToElement(firstPaginationButton);
        if (firstPaginationButton.isDisplayed() && firstPaginationButton.isEnabled()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.elementToBeClickable(firstPaginationButton));
            firstPaginationButton.click();
        }
    }
    //previous pagination button click
    public void clickPreviousPaginationButton(){
        scrollToElement(previousPaginationButton);
        if(previousPaginationButton.isDisplayed() && previousPaginationButton.isEnabled()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.stalenessOf(previousPaginationButton));
            previousPaginationButton.click();
        }
    }

}
