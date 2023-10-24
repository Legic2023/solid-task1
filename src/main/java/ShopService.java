import java.util.ArrayList;

public interface ShopService {

    public void displayProducts(ArrayList<Product> shopProductRange);

    public void filterProductsByName(String keyWord);

    public void filterProductsByPrice(int maxPrice);

    public void filterProductsByCompany(String keyWord);

}
