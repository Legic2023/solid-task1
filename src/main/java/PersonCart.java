import java.util.ArrayList;
import java.util.Scanner;

public class PersonCart implements PersonInterface {

    private String personName;
    private ArrayList<Product> personCartList;

    public PersonCart() {
        personName = serviceAuthorization();
        personCartList = new ArrayList<>();
    }

    @Override
    public void addToCart(Product product) {
        this.personCartList.add(product);
    }

    @Override
    public ArrayList<Product> getPersonCartList() {
        return this.personCartList;
    }

    @Override
    public String getPersonName() {
        return this.personName;
    }

    @Override
    public String serviceAuthorization() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите свое имя: ");
        return scanner.next();
    }

    @Override
    public int personChoice(String[] serviceFunctions) {
        Scanner scanner = new Scanner(System.in);
        Shop.printServiceFunctions(getPersonName());
        System.out.print("Введите номер функции: ");
        return scanner.nextInt();
    }

}
