package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {

    private final WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By MapCloseBtn = By.xpath("//div[@aria-label= 'Close map']");

    private final By TopPicksBtn = By.xpath("//li[@data-id='popularity']//a");

    public By getTopPicksBtn() {
        return TopPicksBtn;
    }

    private final By GoodReviewScoreBtn = By.xpath("//div[@data-filters-item='review_score:review_score=70']");

    public Boolean checkRateIsGoodOrAbove() {
        var rate = new ElementActions(driver).getText(ReviewScoreSecondHotelLabel);
        return rate.equalsIgnoreCase("Good")
                || rate.equalsIgnoreCase("Very good")
                || rate.equalsIgnoreCase("Superb")
                || rate.equalsIgnoreCase("Exceptional");
    }

    private final By NameSecondHotelTxt = By.xpath("(//div[@data-testid='title'])[2]");

    public By getNameSecondHotel() {
        return NameSecondHotelTxt;
    } //returns the By object

    public String getNameSecondHotelTxt() {
        return new ElementActions(driver).getText(NameSecondHotelTxt);
    }

    private final By ReviewScoreSecondHotelLabel = By.xpath("(//div[@data-testid='review-score'])[2]//div[2]//div[1]");

    private final By PriceSecondHotelTxt = By.xpath("(//div[@data-testid='price-and-discounted-price'])[2]//span");

    public By getPriceSecondHotel() {
        return PriceSecondHotelTxt;
    }

    private final By PicSecondHotel = By.xpath("(//img[@data-testid='image'])[2]");

    public By getPicSecondHotel() {
        return PicSecondHotel;
    }

    public ResultPage clickCloseMapBtn() {
        new ElementActions(driver)
                .click(MapCloseBtn);
        return this;
    }

    public ResultPage filterByGoodPlus() {
        new ElementActions(driver)
                .click(GoodReviewScoreBtn);
        return this;
    }

    // User navigates to a new tab which opens "Second hotel details page"
    public DetailsPage openSecondHotelDetailsPage() {
        var windows = new ElementActions(driver)
                .click(NameSecondHotelTxt)
                .getWindowHandles(driver);
        ElementActions.switchToWindow(driver, windows.get(1));
        return new DetailsPage(driver);
    }


}
