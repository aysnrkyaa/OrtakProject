import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestScenarios extends BaseTest {

    @Test(priority = 1)
    public void checkTitleTest() {
        //check title in the page
        String graphicTitle = driver.findElement(By.xpath("//h1[@class='css-3b5rn7']")).getText();
        String expectedGraphicTitle = "Bitcoin Price(BTC)";
        Assert.assertEquals(graphicTitle, expectedGraphicTitle);
        String graphicDate = driver.findElement(By.xpath("//div[@class='css-1tassqi']")).getText();
        System.out.println("Graphic Date :\n " + graphicDate);
        String expectedGraphicdate = "1D\n" + "7D\n" + "1M\n" + "3M\n" + "1Y\n" + "YTD";
        Assert.assertEquals(graphicDate, expectedGraphicdate);

    }

    @Test(priority = 2)
    public void checkCurrencyTest() {
        //change currency and check the currency symbol
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//div[@class='css-13c2b5p'])[1]")).click();
        driver.findElement(By.xpath("//li[@id='EUR_USD']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String value = driver.findElement(By.xpath("//div[@class='axis-label right-axis-label']")).getText();
        System.out.println("Currency value " + value);
        Assert.assertEquals(value, "EUR");

        WebElement priceElement = driver.findElement(By.xpath("//div[@class='css-1267ixm']"));
        String elementText = priceElement.getText();
        if (elementText.contains("€")) {
            System.out.println("The Euro symbol is present in the text.");
        } else {
            System.out.println("The Euro symbol is NOT present in the text.");
        }


    }

    @Test(priority = 3)
    public void checkDateTest() {
        //change date and check the date symbol
        driver.findElement(By.xpath("//span[text()='3M']")).click();
        String date = driver.findElement(By.xpath("//div[@class='css-1267ixm']")).getText();
        System.out.println("Date " +  date);
        if (date.contains("3M")) {
            System.out.println("3M symbol is present in the text.");
        } else {
            Assert.assertEquals(date, "3M");
            System.out.println("3M symbol is NOT present in the text.");
        }

    }

}
