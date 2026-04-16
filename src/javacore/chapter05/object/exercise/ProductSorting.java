package javacore.chapter05.object.exercise;

import java.util.Arrays;

public class ProductSorting {
    static final double EURO_RATE_TO_USD = 0.95;
    static final double POUND_RATE_TO_USD = 0.79;
    static final double YUAN_RATE_TO_USD = 7.27;

    public String name;
    public String category;

    public double price;
    public char currency;

    public ProductSorting(String name, String category, double price, char currency) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.currency = currency;
    }

    public void displayProduct() {
        System.out.println("Product Name : " + this.name + " | Category : " + this.category + " | Price : " + this.price + this.currency);
    }

    @Override
    public String toString() {
        return "Product { Name : " + this.name + " | Category : " + this.category + " | Price = " + this.price + this.currency + " }";
    }

    public static ProductSorting[] convertToUsdPricesArray(ProductSorting[] productArray) {
        for (ProductSorting product : productArray) {
            switch (product.currency) {
                case '€':
                    product.price = convertToUsd(product.price, EURO_RATE_TO_USD);
                    product.currency = '$';
                    break;
                case '£':
                    product.price = convertToUsd(product.price, POUND_RATE_TO_USD);
                    product.currency = '$';
                    break;
                case '¥':
                    product.price = convertToUsd(product.price, YUAN_RATE_TO_USD);
                    product.currency = '$';
                    break;
                default:
                    break;
            }

        }

        return productArray;
    }

    public static void main(String[] args) {

        ProductSorting[] productArray = generateFakeProductList();

        // Écrivez votre code ci-dessous
        ProductSorting[] tempSortedProductArray = insertionSorting(productArray);

        ProductSorting[] tempSortedDollarsPricedProductArray = convertToUsdPricesArray(tempSortedProductArray);

        ProductSorting[] dollarsPricedSortedArray = insertionSorting(tempSortedDollarsPricedProductArray);

        System.out.println(Arrays.toString(dollarsPricedSortedArray));

    }

    public static ProductSorting[] insertionSorting(ProductSorting[] productArray) {
        for (int i = 0; i < productArray.length; i++) {

            ProductSorting cProduct = productArray[i];
            double cProductPrice = cProduct.price;

            int prevIndex = i - 1;

            while (prevIndex >= 0 && productArray[prevIndex].price < cProductPrice) {
                productArray[prevIndex + 1] = productArray[prevIndex];
                prevIndex--;
            }
            productArray[prevIndex + 1] = cProduct;
            cProduct.displayProduct();
        }

        return productArray;
    }

    public static double convertToUsd(double price, double rate) {
        return price / rate;
    }

    public static ProductSorting[] generateFakeProductList() {

        ProductSorting[] productArray = new ProductSorting[10];

        productArray[0] = new ProductSorting("Samsung G9", "Gaming Screen", 1499.99, '$');
        productArray[1] = new ProductSorting("Porsche 911", "Car", 120000, '€');
        productArray[2] = new ProductSorting("IKEA Sofa", "Seating", 599.99, '£');
        productArray[3] = new ProductSorting("MacBook Pro M3", "Laptop", 2499.99, '$');
        productArray[4] = new ProductSorting("Rolex Submariner", "Watch", 9500, '€');
        productArray[5] = new ProductSorting("Bose QuietComfort 45", "Headphones", 329.99, '$');
        productArray[6] = new ProductSorting("Dyson V15 Detect", "Vacuum Cleaner", 7390.10, '¥');
        productArray[7] = new ProductSorting("Harley-Davidson Fat Boy", "Motorcycle", 20300, '€');
        productArray[8] = new ProductSorting("Canon EOS R5", "Camera", 3899, '$');
        productArray[9] = new ProductSorting("Lego Millennium Falcon", "Toy", 849.99, '$');

        return productArray;

    }

}
