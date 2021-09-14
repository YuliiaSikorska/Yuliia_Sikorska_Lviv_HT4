package foxtrotTests;

import foxtrotUtils.CurrencyUtil;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.testng.Assert.assertEquals;

public class ProductDetailsPageTests extends BaseTest {

    @Test
    public void checkCreditMonthlyPayAmount() {
        getProductDetailsPage().implicitWait(30);
        BigDecimal productPrice = CurrencyUtil.removeCurrency(getProductDetailsPage().getProductPrice());
        getProductDetailsPage().clickBuyToCreditButton();
        getProductDetailsPage().visibilityWait(30, getProductDetailsPage().getMonthlyPayAmountElement());
        BigDecimal monthlyAmount = CurrencyUtil.removeCurrency(getProductDetailsPage().getMonthlyPayAmount());
        assertEquals(productPrice.divide(BigDecimal.valueOf(24), RoundingMode.CEILING).compareTo(monthlyAmount), 0);
    }

    @Test
    public void checkCompareTooltip() {
        getProductDetailsPage().implicitWait(30);
        getProductDetailsPage().clickCompareButton();
        assertEquals(getProductDetailsPage().getCompareBlockTooltip(), "1");
    }
}
