import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(productRange());
        shop.serviceFunctionExecute();

    }

    private static ArrayList<Product> productRange() {
        ArrayList<Product> productsList = new ArrayList<>();
        String[] productIds = {"001", "002", "003", "004", "005", "006"};
        String[] productNames = {"Хлеб", "Молоко", "Яблоко", "Мясо", "Чай", "Гречка"};
        int[] productPrices = {50, 80, 150, 400, 100, 150};
        String[] productCompanies = {"Хлебoзавод", "Колхоз", "Сад", "Мясокомбинат", "Чаеразвесочная фабрика", "Колхоз"};

        for (int i = 0; i < productIds.length; i++) {
            productsList.add(new Product(productIds[i], productNames[i], productPrices[i], productCompanies[i]));
        }
        return productsList;
    }


}

