package lt.techin.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreenKartTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
    }
    //Test 1
    @Test
    void searchElementsTest(){
        GreenKartPage greenKartPage = new GreenKartPage(driver);

        //click on dropdown menu
        greenKartPage.isPageSizeDropDownMenuEnabledAndPresent();
        System.out.println("The dropdown menu is clicked");
        System.out.println("");

        //select page size view option
        greenKartPage.selectPageSizeViewOption();
        System.out.println("The option was selected");
        System.out.println("");

        //input search query
        greenKartPage.searchQueryInputIntoFieldIfItIsDisplayed();
        System.out.println("The query has been input");

        //assert that the output elements contain 'at' in their composition
        List<WebElement> displayedItems = greenKartPage.getDisplayedListItems();
        for (WebElement item : displayedItems) {
            String itemText = item.getText();
            assertTrue(itemText.contains("at"), "Items that do contain 'at': " + itemText);
        }

    }

    //Test 2
    @Test
    void displayedVegetableListTest(){
        GreenKartPage greenKartPage = new GreenKartPage(driver);

        //click on dropdown menu
        greenKartPage.isPageSizeDropDownMenuEnabledAndPresent();

        //select page size view option
        greenKartPage.selectPageSizeViewOption();

        // input search query
        greenKartPage.searchQueryInputIntoFieldIfItIsDisplayed();
        System.out.println("The query has been input");
        System.out.println("");

        //display the newly created list
        greenKartPage.currentVegetableList();
        System.out.println("");
        System.out.println("The list is displayed");
        System.out.println("");

        //sort the said list by creating a separate list and using 'Collections'
        greenKartPage.clickSortByNameOnTable();
        List<String> outputs = greenKartPage.currentVegetableList();
        List<String> sortedOutputs = new ArrayList<>(outputs);
        Collections.sort(sortedOutputs);
        assertEquals(sortedOutputs, outputs);

    }

    //pagination buttons
    @Test
    void clickNextPaginationTest(){
        GreenKartPage greenKartPage = new GreenKartPage(driver);
        greenKartPage.clickNextPaginationButton();
    }

    @Test
    void clickLastPaginationTest(){
        GreenKartPage greenKartPage = new GreenKartPage(driver);
        greenKartPage.clickLastPaginationButton();
    }



    //close
    @AfterEach
    void close() throws InterruptedException{
        Thread.sleep(5000);
        driver.close();
    }
}
