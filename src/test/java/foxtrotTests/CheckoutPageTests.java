package foxtrotTests;

import foxtrotUtils.CurrencyUtil;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class CheckoutPageTests extends BaseTest {

    @Test
    public void checkProductPriceAfterIncreasingQuantity() {
        getProductDetailsPage().waitForPageLoadComplete(30);
        getProductDetailsPage().waitForAjaxToComplete(30);
        getProductDetailsPage().clickBuyButton();
        getProductDetailsPage().visibilityWait(30, getProductDetailsPage().getCheckoutButton());
        getProductDetailsPage().clickCheckoutButton();
        BigDecimal firstPrice = CurrencyUtil.removeCurrency(getCheckoutPage().getMainProductPrice());
        getCheckoutPage().clickIncreaseQuantity();
        BigDecimal totalPrice = CurrencyUtil.removeCurrency(getCheckoutPage().getMainProductPrice());
        assertEquals(totalPrice.compareTo(firstPrice.multiply(BigDecimal.valueOf(2))), 0);
    }
}