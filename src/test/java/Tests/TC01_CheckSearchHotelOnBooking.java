package Tests;

import Pages.Home;
import Pages.ResultPage;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Verifications;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC01_CheckSearchHotelOnBooking {
    private WebDriver driver;
    private JSONFileManager destination;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        destination = new JSONFileManager(System.getProperty("testDataFolderPath") + "Destinations.json");
    }

    @Test
    public void CheckSearchResult() {
        var topPicksBtn = new Home(driver).OpenBooking()
                .search(destination.getTestData("FirstDestination.country"))
                .clickCloseMapBtn()
                .getTopPicksBtn();
        Assertions.assertElementAttribute(driver,
                topPicksBtn,
                "text",
                "Our Top Picks",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }

    @Test(dependsOnMethods = "CheckSearchResult")
    public void CheckSecondHotelRating() {
        var review = new ResultPage(driver)
                .filterByGoodPlus()
                .checkRateIsGoodOrAbove();
        Assertions.assertTrue(review);
    }

    @Test(dependsOnMethods = "CheckSecondHotelRating")
    public void CheckSecondHotelNameAndPriceAndPic() {
        var secHotelName = new ResultPage(driver).getNameSecondHotel();
        var secHotelPrice = new ResultPage(driver).getPriceSecondHotel();

        var secHotelImg = new ResultPage(driver).getPicSecondHotel();
        Verifications.verifyElementExists(driver, secHotelName);
        Verifications.verifyElementExists(driver, secHotelPrice);
        Assertions.assertElementExists(driver, secHotelImg);
    }

    @Test(dependsOnMethods = "CheckSecondHotelNameAndPriceAndPic")
    public void CheckSecondHotelDetailsPage() {
        var secHotelName = new ResultPage(driver).getNameSecondHotelTxt();
        var hotelName = new ResultPage(driver)
                .openSecondHotelDetailsPage()
                .getHotelNameTxt();
        Assertions.assertElementAttribute(driver,
                hotelName,
                "text",
                secHotelName,
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }


}
