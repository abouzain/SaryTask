package Pages;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Home {
    private final WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;

    }

    private final By SearchTxtBox = By.id("ss");
    private final By FirstDestination = By.xpath("//ul[@class='c-autocomplete__list sb-autocomplete__list sb-autocomplete__list-with_photos -visible']//li[1]");
    private final By Calendar = By.xpath("(//table[@class='bui-calendar__dates'])[1]");
    private final By CheckInDate = By.xpath("//td[@data-date='" + getCurrentDate() + "']");
    private final By CheckOutDate = By.xpath("//td[@data-date='" + getCheckoutDate() + "']");
    private final By SearchButton = By.className("sb-searchbox__button");


    public Home OpenBooking() {
        if (System.getProperty("targetBrowserName").equals("MozillaFirefox")) {
            driver.manage().window().maximize();
        }
        BrowserActions.navigateToURL(driver, System.getProperty("baseURL"));
        return this;
    }

    public ResultPage search(String destination) {
        new ElementActions(driver)
                .type(SearchTxtBox, destination)
                .click(FirstDestination)
                .click(Calendar)
                .click(CheckInDate)
                .click(CheckOutDate)
                .click(SearchButton);

        return new ResultPage(driver);
    }

    public String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String getCheckoutDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now().plusDays(1);
        return dtf.format(now);
    }


}
