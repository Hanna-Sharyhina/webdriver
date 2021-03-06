package com.training.hardcore.page.tenminuteemail;

import com.training.hardcore.page.googlecloud.PricingCalculatorResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class TenMinuteEmailHomePage {

    private static final String HOME_PAGE_URL = "https://10minutemail.com/";
    private final WebDriver driver;
    private final PricingCalculatorResultPage calculatorResultPage;

    @FindBy(id = "copy_address")
    private WebElement copyEmailButton;

    public TenMinuteEmailHomePage(WebDriver driver, PricingCalculatorResultPage calculatorResultPage) {
        this.driver = driver;
        this.calculatorResultPage = calculatorResultPage;
        PageFactory.initElements(driver, this);
    }

    public TenMinuteEmailHomePage openPage() {
        driver.get(HOME_PAGE_URL);
        return this;
    }

    public TenMinuteEmailHomePage copyEmailFromBox() {
        new WebDriverWait(driver, 15).until((ExpectedCondition<Boolean>) driver ->
                driver.findElement(By.xpath("//input[@id = 'mail_address']")).getAttribute("value").length() != 0);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(copyEmailButton)).click();
        return this;
    }

    public PricingCalculatorResultPage switchToCalculatorResultPage() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return calculatorResultPage;
    }
}
