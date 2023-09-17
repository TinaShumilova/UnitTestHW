import lv.gb.unittest.hw1.ShopFolder.Product.Product;
import lv.gb.unittest.hw1.ShopFolder.Shop.Shop;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<Product>();

        productList.add(new Product("Bread", 30));
        productList.add(new Product("Apple", 450));
        productList.add(new Product("Orange", 12));
        productList.add(new Product("Water", 100));
        productList.add(new Product("Meat", 345));
        productList.add(new Product("Salad", 33));
        productList.add(new Product("Tomato", 22));

        Shop<Product> shop = new Shop<>();
        shop.setProducts(productList);

        checkingProduct(shop);
    }

    public static void checkingProduct(Shop shop) {

//        1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
        assertThat(shop.getProducts())
                .isNotEmpty()
                .hasSize(7);

        assertThat(shop.getProductTitles()).contains("Orange", "Tomato", "Bread", "Salad", "Water", "Meat", "Apple");

//        2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
        String mep = "Product title: Apple, product price: 450";
        assertThat(shop.getMostExpensiveProduct().getInfo()).isEqualTo(mep);
//        3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
        List<Product> sortedList = shop.getSortedListProducts();
        String actualList = "" + sortedList + "";
        String expectedList = "[Product title: Orange, product price: 12, " +
                   "Product title: Tomato, product price: 22, " +
                   "Product title: Bread, product price: 30, " +
                   "Product title: Salad, product price: 33, " +
                   "Product title: Water, product price: 100, " +
                   "Product title: Meat, product price: 345, " +
                   "Product title: Apple, product price: 450]";
        assertThat(actualList).isEqualTo(expectedList);
    }
}

