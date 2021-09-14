package foxtrot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
    @FindBy(xpath = "//a[contains(@class,'js-toggle-buy-credit-popup')]")
    private WebElement buyToCreditButton;

    @FindBy(xpath = "//p[@id='monthly-pay']")
    private WebElement monthlyPayAmount;

    @FindBy(xpath = "//div[contains(@class,'response-buttons')]//div[contains(@class,'compare-button')]")
    private WebElement compareButton;

    @FindBy(xpath = "//div[contains(@class,'count js-toggle-tooltip')]")
    private WebElement compareBlock;

    @FindBy(xpath = "//div[contains(@class,'button product-box__main-buy')]")
    private WebElement toBuyButton;

    @FindBy(xpath = "//div[contains(@class,'header')]//a[@class='button']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[contains(@class,'product-box__main-price')]//div[@class='card-price']")
    private WebElement productPrice;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickBuyToCreditButton() {
        buyToCreditButton.click();
    }

    public String getMonthlyPayAmount() {
        return monthlyPayAmount.getText();
    }

    public void clickBuyButton() {
        toBuyButton.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public void clickCompareButton() {
        compareButton.click();
    }

    public String getCompareBlockTooltip() {
        return compareBlock.getText();
    }

    public WebElement getMonthlyPayAmountElement() {
        return monthlyPayAmount;
    }

    public String getProductPrice() {
        return productPrice.getText();
    }
}
