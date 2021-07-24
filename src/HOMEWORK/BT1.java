package HOMEWORK;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class BT1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://au-webhook-adc1.onshopbase.com/admin/discounts/9999754162933");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("shopbase2@beeketing.net");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("*esAS!z(:YeZ-5q");
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[3]/div[2]/button[1]")).click();
        Thread.sleep(10000);
        String discount_code =
                driver.findElement(By.xpath("//p[contains(text(),'testing')]"))
                .getText();
        String discount_money = "- $"+
                driver.findElement(By.xpath("//body/div[@id='app']/div[1]/main[1]/div[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]"))
                .getAttribute("value")+".00";
        System.out.println(discount_code+" , "+discount_money);
        driver.navigate().to("https://au-webhook-adc1.onshopbase.com/checkouts/8002e445bfc8485b90091ec41865f8e5?step=shipping_method");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
                .sendKeys("testing");
        driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
        Thread.sleep(2000);
        String tag_discount = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/span[2]"))
                .getText();
        System.out.println(tag_discount);
        if(discount_code.toUpperCase().equals(tag_discount))
        {
            String discount =
                    driver.findElement(By.xpath("//span[contains(text(),'- $5.00')]")).getText();
            System.out.println(discount);
            if(discount_money.equals(discount))
            {
                System.out.println("Test Passed");
            }
            else {
                System.out.println("Test failed ");
            }
        }
        else
        {
            System.out.println("Test failed");
        }


    }
}
