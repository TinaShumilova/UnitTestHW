package lv.gb.unittest.hw1.ShopFolder.Shop;
import lv.gb.unittest.hw1.ShopFolder.Product.GroupItem;
import lv.gb.unittest.hw1.ShopFolder.Product.Product;
import lv.gb.unittest.hw1.ShopFolder.Product.ProductComporatorByPrice;

import java.util.ArrayList;
import java.util.List;

public class Shop<P extends GroupItem> {
    private List<P> products;

    // Геттеры, сеттеры:
    public List<P> getProducts() {
        return products;
    }

    public void setProducts(List<P> products) {
        this.products = products;
    }

    public ArrayList<String> getProductTitles(){
        ArrayList<String> productsList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Product product = (Product) products.get(i);
            String title = product.getTitle();
            productsList.add(title);
        }
        return productsList;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<P> getSortedListProducts() {
        products.sort(new ProductComporatorByPrice<P>());
        return products;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        int maxCost = products.get(0).getCost();
        Product mostExpensiveProduct = (Product) products.get(0);
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCost() > maxCost) {
                maxCost = products.get(i).getCost();
                mostExpensiveProduct = (Product) products.get(i);
            }
        }
        return mostExpensiveProduct;
    }

}