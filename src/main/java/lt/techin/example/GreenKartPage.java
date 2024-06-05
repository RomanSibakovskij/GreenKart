package lt.techin.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GreenKartPage {

    @FindBy(xpath = "//*[@id=\"page-menu\"]")
    private WebElement pageSizeDropDownMenu;

    @FindBy(xpath = "//*[@id=\"page-menu\"]/option[3]")
    private WebElement pageSizeOptionSelect;

    @FindBy(xpath = "//*[@id=\"search-field\"]")
    private WebElement searchQueryInput;

    @FindBy(xpath = "//tbody//tr//td[1]")
    private List<WebElement> tdDisplayedListItems;

    @FindBy(css = "th:nth-child(1) > span:nth-of-type(1)")
    private WebElement clickSortByName;

    @FindBy(css = "div.col-xs-8 > ul > li:nth-child(7) > a")
    private WebElement nextPaginationButton;
    @FindBy(css = "div.col-xs-8 > ul > li:nth-child(8) > a")
    private WebElement lastPaginationButton;



    WebDriver driver;
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public GreenKartPage(){}

    public GreenKartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //click on page size dropdown menu
    public void isPageSizeDropDownMenuEnabledAndPresent(){
        if(pageSizeDropDownMenu.isDisplayed() && pageSizeDropDownMenu.isEnabled()){
            pageSizeDropDownMenu.click();
        }
    }
    //select the page size view option
    public void selectPageSizeViewOption(){
        pageSizeOptionSelect.click();
    }
    //input a search query
    public void searchQueryInputIntoFieldIfItIsDisplayed(){
        if(searchQueryInput.isDisplayed()){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfAllElements(tdDisplayedListItems));
            searchQueryInput.sendKeys("at");
        }
    }
    //get displayed items output
    public List<WebElement> getDisplayedListItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(tdDisplayedListItems));
        return tdDisplayedListItems;
    }
    //display current vegetable list
    public List<String> currentVegetableList(){
        List<String> vegetableNames = new ArrayList<>();
        if (tdDisplayedListItems == null || tdDisplayedListItems.isEmpty()) {
            System.out.println("The vegetable list is empty");
        } else {
            for (WebElement vegetableItem : tdDisplayedListItems) {
                String vegetableName = vegetableItem.getText();
                vegetableNames.add(vegetableName);
                System.out.println("Added vegetable: " + vegetableName);
            }
        }
        return vegetableNames;
    }
    //sort name click
    public void clickSortByNameOnTable(){
        clickSortByName.click();
    }

    //next pagination button click
    public void clickNextPaginationButton(){
        scrollToElement(nextPaginationButton);
        if(nextPaginationButton.isDisplayed() && nextPaginationButton.isEnabled()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(nextPaginationButton));
            nextPaginationButton.click();
        }
    }
    //last pagination button click
    public void clickLastPaginationButton(){
        scrollToElement(lastPaginationButton);
        if(lastPaginationButton.isDisplayed() && lastPaginationButton.isEnabled()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(lastPaginationButton));
            lastPaginationButton.click();
        }
    }
}
