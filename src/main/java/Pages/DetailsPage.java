package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailsPage {
    public DetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;

    public By getHotelNameTxt() {
        return HotelNameTxt;
    }

    private final By HotelNameTxt = By.xpath("//h2[@id='hp_hotel_name']");
}
