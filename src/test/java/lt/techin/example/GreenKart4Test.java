package lt.techin.example;

import org.junit.jupiter.api.Test;

public class GreenKart4Test extends GreenKartTest {

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
}
