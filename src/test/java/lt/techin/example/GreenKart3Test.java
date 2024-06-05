package lt.techin.example;

import org.junit.jupiter.api.Test;

public class GreenKart3Test extends GreenKartTest {

    @Test
    void firstButtonClickTest() {
        GreenKart2Page greenKartPage = new GreenKart2Page(driver);
        greenKartPage.clickFirstPaginationButton();
    }

    @Test
    void nextButtonClickTest() {
        GreenKart2Page greenKartPage = new GreenKart2Page(driver);
        greenKartPage.clickNextPaginationButton();
    }

    @Test
    void previousButtonClickTest() {
        GreenKart2Page greenKartPage = new GreenKart2Page(driver);
        greenKartPage.clickPreviousPaginationButton();
    }

    @Test
    void lastButtonClickTest() {
        GreenKart2Page greenKartPage = new GreenKart2Page(driver);
        greenKartPage.clickLastPaginationButton();
    }
}
