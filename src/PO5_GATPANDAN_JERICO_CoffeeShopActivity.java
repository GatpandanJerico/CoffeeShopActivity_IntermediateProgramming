import java.util.Scanner;

public class PO5_GATPANDAN_JERICO_CoffeeShopActivity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        mainMenu(input);
//        preOrder();
//        viewMenu();
//        viewOrder();
    }

    private static void mainMenu(Scanner input) {

        int productID = 99;
        while (true) {
            String convertProductID = String.format("%04d", productID);
            System.out.println(convertProductID);
        }
    }
}
