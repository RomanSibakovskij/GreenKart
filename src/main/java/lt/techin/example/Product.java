package lt.techin.example;

import org.openqa.selenium.WebDriver;

public class Product extends GreenKartPage{
    public Product(WebDriver driver) {
        super(driver);
    }

    private String name;
    private String price;
    private String discountedPrice;

    public Product(String name, String price, String discountedPrice){
        super();
        this.name = name;
        this.price = price;
        this.discountedPrice = discountedPrice;
    }

    public boolean contains(String text){

        return name.toLowerCase().contains(text.toLowerCase()) || price.contains(text) || discountedPrice.contains(text);
    }
}
