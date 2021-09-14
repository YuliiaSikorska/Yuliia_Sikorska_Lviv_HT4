package foxtrotTests;

import foxtrot.CheckoutPage;
import foxtrot.ProductDetailsPage;
import foxtrotUtils.CapabilityFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    private static final String FOXTROT_URL
            = "https://www.foxtrot.com.ua/ru/shop/noutbuki_acer_nitro-5-an515-44-r0dw-nh-q9geu-00g.html";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.0.106:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(FOXTROT_URL);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(getDriver());
    }

    public ProductDetailsPage getProductDetailsPage() {
        return new ProductDetailsPage(getDriver());
    }
}
