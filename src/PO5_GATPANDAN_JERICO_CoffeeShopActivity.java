import java.util.ArrayList;
import java.util.Scanner;

public class PO5_GATPANDAN_JERICO_CoffeeShopActivity {
    static ArrayList<ArrayList<String>> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        mainMenu(input);
//        preOrder();
//        viewMenu();
//        viewOrder();
    }

    private static void mainMenu(Scanner input) {
            // Display the main menu
            System.out.println("=== Coffee Shop Main Menu ===");
            System.out.println(" 1. Add Product\n 2. Edit Product\n 3. Delete Product\n 4. Take Pre-Order\n 5. View Menu\n 6. View Order\n 7. Inventory\n 8. Exit\n");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addProduct(input);
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    takePreOrder();
                    break;
                case 5:
                    viewMenu();
                    break;
                case 6:
                    viewOrder();
                    break;
                case 7:
                    viewInventory();
                    break;
                case 8:
                    return;

            }
            mainMenu(input);
    }

    private static void addProduct(Scanner input) {
        ArrayList<String> product = new ArrayList<>();

        int productNumber = 1;
        while (true) {
            String ID = generateProductID(productNumber);
            System.out.println("Product ID: " + ID);

            System.out.print("Enter Product Name: ");
            String productName = input.nextLine();

            System.out.print("Enter the Product Ingredient: ");
            String productIngredient = input.nextLine();

            System.out.print("Enter Product Status (0 or 1): ");
            String productStatus = input.nextLine();

            System.out.print("Enter Product price: ");
            String productPrice = input.nextLine();

            productNumber++;

            product.add(ID);
            product.add(productName);
            product.add(productIngredient);
            product.add(productStatus);
            product.add(productPrice);

            products.add(product);

            System.out.print("Would you like to add more? (Y/N): ");
            char choice = input.nextLine().toUpperCase().trim().charAt(0);
            if (choice == 'N') {
                return;
            }
        }
    }

    private static void editProduct() {
    }

    private static void deleteProduct() {
    }

    private static void takePreOrder() {
    }

    private static void viewMenu() {
    }

    private static void viewOrder() {
    }

    private static void viewInventory() {
        for (ArrayList<String> product : products) {
            for (String s : product) {
                System.out.print(s + " ");
            }
            System.out.print("\n");
        }
    }


    private static String generateProductID(int productID) {
        return String.format("%04d", productID);
    }
}
