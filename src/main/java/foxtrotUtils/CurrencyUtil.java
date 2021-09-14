package foxtrotUtils;

import java.math.BigDecimal;

public class CurrencyUtil {

    public static BigDecimal removeCurrency(String salePrice) {
        String price = salePrice.replace("₴", "").replace(" ", "");
        return new BigDecimal(price);
    }
}
