import java.util.ArrayList;
import java.util.Scanner;

public class PO5_GATPANDAN_JERICO_CoffeeShopActivity {
    static ArrayList<ArrayList<String>> products = new ArrayList<>();
    static ArrayList<ArrayList<ArrayList<String>>> orders = new ArrayList<>();
    private static int productNumber = 1;
    private static int orderID = 1000;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        mainMenu(input);
    }

    private static void mainMenu(Scanner input) {
        // Display the main menu
        System.out.println("=== Coffee Shop ===");
        System.out.println(" 1. Add Product\n 2. Edit Product\n 3. Delete Product\n 4. Take Pre-Order\n 5. View Menu\n 6. View Order\n 7. Inventory\n 8. Exit\n");

        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                addProduct(input);
                break;
            case 2:
                editProduct(input);
                break;
            case 3:
                deleteProduct(input);
                break;
            case 4:
                takePreOrder(input);
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
        System.out.println(orders);
    }


    private static void addProduct(Scanner input) {

        while (true) {
            ArrayList<String> product = new ArrayList<>();

            String ID = generateProductID(productNumber);
            System.out.println("\nProduct ID: " + ID);

            // TODO product name should not be duplicated

            System.out.print("Enter Product Name: ");
            String productName = input.nextLine();

            System.out.print("Enter the Product Ingredient: ");
            String productIngredient = input.nextLine();

            String productStatus;
            while (true) {
                System.out.print("Enter Product Status (0 or 1): ");
                productStatus = input.nextLine().trim();
                if (productStatus.matches("[01]")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 0 or 1.");
                }
            }

            String productPrice;
            while (true) {
                System.out.print("Enter Product price: ");
                productPrice = input.nextLine().trim();
                if (productPrice.matches("\\d+")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }

            productNumber++;

            product.add(ID);
            product.add(productName);
            product.add(productIngredient);
            product.add(productStatus);
            product.add(productPrice);

            products.add(product);

            while (true) {
                System.out.print("Would you like to add more? (Y/N): ");
                char choice = input.nextLine().toUpperCase().trim().charAt(0);

                if (choice == 'N') {
                    return;
                } else if (choice == 'Y') {
                    break;
                } else System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
    }

    private static void editProduct(Scanner input) {

    }

    private static void deleteProduct(Scanner input) {
    }

    private static void takePreOrder(Scanner input) {
        ArrayList<ArrayList<String>> customerOrder = new ArrayList<>();
        while (true) {
            ArrayList<String> order = new ArrayList<>();

            String ID = generateOrderID(orderID);
            System.out.println("Order ID: " + ID);

            System.out.print("Enter Customer Name: ");
            String customerName = input.nextLine();

            viewMenu();
            System.out.println("Enter Order Name: ");
            String orderName = input.nextLine();

            System.out.println("Enter the quantity of the product: ");
            String orderQuantity = input.nextLine();

            System.out.println("Enter sugar level: ");
            String sugarLevel = input.nextLine();

            orderID++;

            order.add(ID);
            order.add(customerName);
            order.add(orderName);
            order.add(orderQuantity);
            order.add(sugarLevel);

            customerOrder.add(order);
            while (true) {
                System.out.print("Would you like to order more? (Y/N): ");
                char choice = input.nextLine().toUpperCase().trim().charAt(0);

                if (choice == 'N') {
                    return;
                } else if (choice == 'Y') {
                    break;
                } else System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
            orders.add(customerOrder);
        }

    }

    private static void viewMenu() {

    }

    private static void viewOrder() {
    }

//    private static void viewInventory() {
//
//        System.out.printf("________________________________________________________________________%n");
//        System.out.printf("| %8s | %12s | %12s | %12s | %12s |\n", "ID", "Product Name", "Ingredients", "Status", "Price");
//        for (ArrayList<String> product : products) {
//            product.set(3, product.get(3).equals("0") ? "Available" : "Not Available");
//            System.out.printf("| %8s | %12s | %12s | %12s | %-10s |\n", product.get(0), product.get(1), product.get(2), product.get(3), "PHP " +product.get(4));
//        }
//        System.out.printf("________________________________________________________________________%n");
//
//    }

    private static void viewInventory() {
        int ID_WIDTH = 8;
        int NAME_WIDTH = 14;
        int INGREDIENTS_WIDTH = 14;
        int STATUS_WIDTH = 14;
        int PRICE_WIDTH = 14;
        int totalWidth = ID_WIDTH + NAME_WIDTH + INGREDIENTS_WIDTH + STATUS_WIDTH + PRICE_WIDTH + 14;
        String border = "-".repeat(totalWidth);

        System.out.println(border);
        System.out.printf("| %" + ID_WIDTH + "s | %" + NAME_WIDTH + "s | %" + INGREDIENTS_WIDTH + "s | %" + STATUS_WIDTH + "s | %" + PRICE_WIDTH + "s |\n",
                "ID", "Product Name", "Ingredients", "Status", "Price");
        System.out.println(border);

        for (ArrayList<String> product : products) {
            String id = product.get(0);
            String name = product.get(1);
            String ingredients = product.get(2);
            String status = product.get(3).equals("0") ? "Available" : "Not Available";
            double price = Double.parseDouble(product.get(4));
            String formattedPrice = String.format("PHP %.2f", price);

            System.out.printf("| %" + ID_WIDTH + "s | %" + NAME_WIDTH + "s | %" + INGREDIENTS_WIDTH + "s | %" + STATUS_WIDTH + "s | %-" + PRICE_WIDTH + "s |\n",
                    id, name, ingredients, status, formattedPrice);
        }
        System.out.println(border);
    }

    private static String generateProductID(int productID) {
        return String.format("%04d", productID);
    }

    private static String generateOrderID(int orderID) {
        return String.format("%04d", orderID);
    }
}
