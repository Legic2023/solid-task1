import java.util.ArrayList;

public interface PersonInterface {
    public String serviceAuthorization();

    public int personChoice(String[] serviceFunctions);

    public String getPersonName();

    public ArrayList<Product> getPersonCartList();

    public void addToCart(Product product);


}
