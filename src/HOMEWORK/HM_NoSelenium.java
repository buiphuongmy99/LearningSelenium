package HOMEWORK;

import HOMEWORK.Product;

import java.util.HashMap;
import java.util.Set;

public class HM_NoSelenium {
    public static void main(String[] args) {
        HashMap<String, Product> hm = new HashMap<>();
        click_3_product(hm);
        reduce_2_product(hm);
        add_product(hm);
        show(hm);
    }
    public static void click_3_product(HashMap<String, Product> hm)
    {
        Product product = new Product();
        product.setName("POLARIZED FISHING GLASSES");
        product.setPrice("$69.99");
        product.setVariant("Black");
        product.setQuantity(3);
        hm.put(product.getName(),product);
    }
    public static void reduce_2_product(HashMap<String, Product> hm){
        Product product = hm.get("POLARIZED FISHING GLASSES");
        product.setQuantity(2);
        hm.put(product.getName(),product);
    }
    public static void add_product(HashMap<String, Product> hm){
        Product product = new Product();
        product.setName("SHIRT");
        product.setPrice("$10.00");
        product.setVariant("");
        product.setQuantity( 1);
        hm.put(product.getName(),product);
    }
    public static void show(HashMap<String,Product> hm){
        Set<String > keySet = hm.keySet();
        for(String key: keySet){
            System.out.println(hm.get(key));
        }
    }
}
