import java.util.ArrayList;
import java.util.Scanner;

public class Shop implements ShopService {

    private static final String[] serviceFunctionNames = {"Вывести доступные товары",
            "Выборка товаров по имени", "Выборка товаров по максимальной цене", "Выборка товаров по производителю",
            "Показать корзину", "Добавить товар в корзину"};

    public static final int MENU_FUNCTIONS_NUMBER = serviceFunctionNames.length; // Правило Magic: не используй числа напрямую в коде
    public static final int MENU_CHANGE_USER = MENU_FUNCTIONS_NUMBER + 1; // Правило Magic: не используй числа напрямую в коде
    public static final int MENU_EXIT = MENU_FUNCTIONS_NUMBER + 2; // Правило Magic: не используй числа напрямую в коде

    private final ArrayList<Product> shopProductRange;
    private PersonCart personCart;

    public Shop(ArrayList<Product> shopProductRange) {
        this.shopProductRange = shopProductRange;
        personCart = new PersonCart();
    }

    public String[] getServiceFunctionNames() {
        return serviceFunctionNames;
    }

    public static void printServiceFunctions(String personName) {
        System.out.println();
        System.out.println("Функции магазина: ");
        System.out.printf("(пользователь: %s)%n", personName);

        for (int i = 0; i < serviceFunctionNames.length; i++) {
            System.out.printf("%d. %s%n", i + 1, serviceFunctionNames[i]);
        }
        System.out.printf("%d. %s%n", MENU_CHANGE_USER, "Сменить пользователя");
        System.out.printf("%d. %s%n", MENU_EXIT, "Завершить покупки (выход)");

    }

    public int adaptChoice(int personChoice) {
        if ((personChoice > 0) && (personChoice < Shop.MENU_EXIT)) {
            return personChoice;
        } else {
            return Shop.MENU_EXIT;
        }

    }

    public void serviceFunctionExecute() {
        while (true) {
            int personChoice = adaptChoice(personCart.personChoice(getServiceFunctionNames()));
            int functionAddress = personChoice - 1;
            if (personChoice == MENU_EXIT) { // Правило Magic: не используй числа напрямую в коде
                break;
            } else if (personChoice == MENU_CHANGE_USER) { // Правило Magic: не используй числа напрямую в коде
                personCart = new PersonCart();
                displayProducts(shopProductRange); // Правило DRY (Don’t Repeat Yourself): не повторяйте свой код
            } else if ("Вывести доступные товары".equals(serviceFunctionNames[functionAddress])) { // Правило Magic: не используй числа напрямую в коде
                System.out.println();
                System.out.println("Ассортимент продукции: ");
                displayProducts(shopProductRange); // Правило DRY (Don’t Repeat Yourself): не повторяйте свой код
            } else if ("Выборка товаров по имени".equals(serviceFunctionNames[functionAddress])) { // Правило Magic: не используй числа напрямую в коде
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите ключевое слово: ");
                String keyWord = scanner.nextLine();
                filterProductsByName(keyWord);
            } else if ("Выборка товаров по максимальной цене".equals(serviceFunctionNames[functionAddress])) { // Правило Magic: не используй числа напрямую в коде
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите максимальную цену: ");
                int maxPrice = scanner.nextInt();
                filterProductsByPrice(maxPrice);
            } else if ("Выборка товаров по производителю".equals(serviceFunctionNames[functionAddress])) { // Правило Magic: не используй числа напрямую в коде
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите ключевое слово: ");
                String keyWord = scanner.nextLine();
                filterProductsByCompany(keyWord);
            } else if ("Показать корзину".equals(serviceFunctionNames[functionAddress])) { // Правило Magic: не используй числа напрямую в коде
                System.out.println();
                System.out.printf("Корзина покупателя: %s %n", personCart.getPersonName());
                displayProducts(personCart.getPersonCartList());
            } else if ("Добавить товар в корзину".equals(serviceFunctionNames[functionAddress])) { // Правило Magic: не используй числа напрямую в коде
                displayProducts(shopProductRange); // Правило DRY (Don’t Repeat Yourself): не повторяйте свой код
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите ID товара для добавления в корзину: ");
                String productId = scanner.nextLine();
                personCart.addToCart((shopProductRange.stream()
                        .filter(x -> x.productId.toLowerCase().contains(productId))
                        .findFirst()).get());
                System.out.printf("Корзина покупателя: %s %n", personCart.getPersonName());
                displayProducts(personCart.getPersonCartList()); // Правило DRY (Don’t Repeat Yourself): не повторяйте свой код
            }
        }
    }

    @Override
    public void displayProducts(ArrayList<Product> products) {
        System.out.printf("%5s %10s %5s %s%n", "ID", "Продукт", "Цена", "Компания");
        for (Product item : products) {
            System.out.printf("%5s %10s %5s %s%n", item.productId, item.productName, item.productPrice, item.productCompany);
        }
    }

    @Override
    public void filterProductsByName(String keyWord) {
        System.out.printf("%5s %10s %5s %s%n", "ID", "Продукт", "Цена", "Компания");
        shopProductRange.stream()
                .filter(x -> x.productName.toLowerCase().contains(keyWord))
                .forEach(System.out::print);
    }

    @Override
    public void filterProductsByPrice(int maxPrice) {
        System.out.printf("%5s %10s %5s %s%n", "ID", "Продукт", "Цена", "Компания");
        shopProductRange.stream()
                .filter(x -> x.productPrice < maxPrice)
                .forEach(System.out::print);
    }

    @Override
    public void filterProductsByCompany(String keyWord) {
        System.out.printf("%5s %10s %5s %s%n", "ID", "Продукт", "Цена", "Компания");
        shopProductRange.stream()
                .filter(x -> x.productCompany.toLowerCase().contains(keyWord))
                .forEach(System.out::print);

    }

}
