package foxtrot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//div[@class='checkout-tovar__price-main']")
    private WebElement mainProductPrice;

    @FindBy(xpath = "//span[@class='checkout-tovar__count_scale']")
    private WebElement increaseQuantity;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getMainProductPrice() {
        return mainProductPrice.getText();
    }

    public void clickIncreaseQuantity() {
        increaseQuantity.click();
    }
}
