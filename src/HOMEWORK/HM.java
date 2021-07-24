package HOMEWORK;

import HOMEWORK.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class HM {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\OCG\\Downloads\\chromedriver_win32_92\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseURL = "https://au-webhook-adc1.onshopbase.com/products/shimanos-new-polarized-fishing-glasses?variant=1000002759576958";
        driver.get(baseURL);
        HashMap<String, Product> hm = new HashMap<>();
        Product product = new Product();
        //Thêm sản phẩm với sl = 3 vào giỏ
        product.setName(driver.findElement(By.xpath(
                "//h3[contains(text(),'Polarized Fishing Glasses')]"
        )).getText());
        driver.findElement(By.xpath(
                "//body/div[@id='app']/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[2]/img[1]")).click();
        product.setVariant(driver.findElement(By.xpath(
                "//body/div[@id='app']/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/label[1]"
        )).getText());
        product.setPrice(driver.findElement(By.xpath(
                "//body/div[@id='app']/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]"
        )).getText());
        driver.findElement(By.xpath(
                "//body/div[@id='app']/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[5]/div[1]/div[1]/button[2]"
        )).click();
        driver.findElement(By.xpath(
                "//body/div[@id='app']/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[5]/div[1]/div[1]/button[2]"
        )).click();
        product.setQuantity(Integer.parseInt(driver.findElement(By.xpath(
                "//body/div[@id='app']/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[5]/div[1]/div[1]/input[1]"
        )).getAttribute("value")));
        hm.put(product.getName(),product);
        driver.findElement(By.xpath(
                "//button[@id='add-to-cart']"
        )).click();
        Thread.sleep(4000);
        System.out.println(driver.getCurrentUrl());
        //Giảm số lượng sản phẩm vừa thêm còn 2 sản phẩm
        Product product_1 = hm.get("POLARIZED FISHING GLASSES");
        driver.findElement(By.xpath(
              "//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/button[1]"
        )).click();
        Thread.sleep(1000);
        product_1.setQuantity(Integer.parseInt(driver.findElement(By.xpath(
                "//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/input[1]"
        )).getAttribute("value")));
        hm.put(product_1.getName(),product_1);
        //Thêm một sản phẩm mới vào giỏ
        driver.navigate().to("https://au-webhook-adc1.onshopbase.com/products/shirt-2");
        Product product_2 = new Product();
        product_2.setName(driver.findElement(By.xpath(
                "//h3[contains(text(),'Shirt')]"
        )).getText());
        product_2.setPrice(driver.findElement(By.xpath(
                "//body/div[@id='app']/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]"
        )).getText());
        product_2.setVariant("");
        product_2.setQuantity(Integer.parseInt(driver.findElement(By.xpath(
                "//body/div[@id='app']/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[5]/div[1]/div[1]/input[1]"
        )).getAttribute("value")));
        driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
        hm.put(product_2.getName(),product_2);
        //In ra tất cả sản phẩm trong giỏ
        Set<String > keySet = hm.keySet();
        for(String key: keySet){
            System.out.println(hm.get(key));
        }
   }





}

