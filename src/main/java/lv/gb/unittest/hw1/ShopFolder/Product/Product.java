package lv.gb.unittest.hw1.ShopFolder.Product;

public class Product implements GroupItem {
    private int cost; // Стоимость продукта
    private String title; // Название


    public Product(String title, int cost) {
        this.cost = cost;
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product title: ");
        sb.append(getTitle());
        sb.append(", product price: ");
        sb.append(getCost());
        return sb.toString();
    }
    @Override
    public String toString() {
        return getInfo();
    }


}
