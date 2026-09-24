

import java.util.ArrayList;
import java.util.Scanner;

// Interface
interface Discountable {
    double calculateDiscount();
}

// Abstract class used only inside this package
abstract class Product implements Discountable {

    // Encapsulation
    private String id;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Stock Quantity: " + stockQuantity+"months");
    }

    // Abstract Method
    public abstract String getCategory();
}


// Inheritance
class ElectronicDevice extends Product {

    private int storage;
    private int warranty;

    public ElectronicDevice(
            String id,
            String name,
            double price,
            int stockQuantity,
            int storage,
            int warranty) {

        super(id, name, price, stockQuantity);

        this.storage = storage;
        this.warranty = warranty;
    }

    public int getStorage() {
        return storage;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    // Polymorphism
    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Storage: " + storage + " GB");
        System.out.println("Warranty: " + warranty + " months");
        System.out.println("Discount: $" + calculateDiscount());
    }

    @Override
    public String getCategory() {
        return "Electronic Device";
    }

    // Interface method
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }
}


// Inheritance
class Clothes extends Product {

    private String size;
    private String color;

    public Clothes(
            String id,
            String name,
            double price,
            int stockQuantity,
            String size,
            String color) {

        super(id, name, price, stockQuantity);

        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Polymorphism
    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Size: " + size);
        System.out.println("Color: " + color);
        System.out.println("Discount: $" + calculateDiscount());
    }

    @Override
    public String getCategory() {
        return "Clothes";
    }

    // Interface method
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }
}


// Inheritance
class Cosmetics extends Product {

    private String skinType;
    private String expirationDate;

    public Cosmetics(
            String id,
            String name,
            double price,
            int stockQuantity,
            String skinType,
            String expirationDate) {

        super(id, name, price, stockQuantity);

        this.skinType = skinType;
        this.expirationDate = expirationDate;
    }

    public String getSkinType() {
        return skinType;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    // Polymorphism
    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Skin Type: " + skinType);
        System.out.println("Expiration Date: " + expirationDate);
        System.out.println("Discount: $" + calculateDiscount());
    }

    @Override
    public String getCategory() {
        return "Cosmetics";
    }

    // Interface method
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }
}


// Main Class
public class Moving {

    static ArrayList<Product> products = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println();
            System.out.println("======================================");
            System.out.println(" E-COMMERCE PRODUCT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.println("======================================");

            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 -> System.out.println("Thank you for using the system!");
                default -> {
                    System.out.println("Invalid choice!");
                    System.out.println("Please choose from 1 to 5.");
                }
            }

        } while (choice != 5);

        scanner.close();
    }


    public static void addProduct() {

        System.out.println();
        System.out.println("========== ADD PRODUCT ==========");
        System.out.println("1. Electronic Device");
        System.out.println("2. Clothes");
        System.out.println("3. Cosmetics");

        int category;

        do {

            category = readInt("Choose category: ");

            if (category < 1 || category > 3) {
                System.out.println("Invalid category!");
            }

        } while (category < 1 || category > 3);


        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        double price = readDouble("Enter price:$  ");

        int stockQuantity = readInt("Enter stock quantity: ");


        // Replaced if-else chain with a clean switch rule block
        switch (category) {
            case 1 -> {
                String id = generateId("E");
                int storage = readInt("Enter storage in GB: ");
                int warranty = readInt("Enter warranty in months: ");
                ElectronicDevice device = new ElectronicDevice(
                        id,
                        name,
                        price,
                        stockQuantity,
                        storage,
                        warranty
                );
                products.add(device);
                System.out.println();
                System.out.println("Electronic device added successfully!");
                System.out.println("Generated ID: " + id);
            }
            case 2 -> {
                String id = generateId("C");
                System.out.print("Enter size (M/L/XL): ");
                String size = scanner.nextLine();
                System.out.print("Enter color: ");
                String color = scanner.nextLine();
                Clothes clothes = new Clothes(
                        id,
                        name,
                        price,
                        stockQuantity,
                        size,
                        color
                );
                products.add(clothes);
                System.out.println();
                System.out.println("Clothes added successfully!");
                System.out.println("Generated ID: " + id);
            }
            default -> {
                String id = generateId("CS");
                System.out.print("Enter skin type (dry/oily): ");
                String skinType = scanner.nextLine();
                System.out.print("Enter expiration date (YYYY-MM-DD): ");
                String expirationDate = scanner.nextLine();
                Cosmetics cosmetics = new Cosmetics(
                        id,
                        name,
                        price,
                        stockQuantity,
                        skinType,
                        expirationDate
                );
                products.add(cosmetics);
                System.out.println();
                System.out.println("Cosmetics added successfully!");
                System.out.println("Generated ID: " + id);
            }
        }
    }


    public static String generateId(String prefix) {

        int maxNumber = 0;

        for (Product product : products) {

            String id = product.getId();

            if (id.startsWith(prefix)) {

                try {

                    String numberPart = id.substring(prefix.length());

                    int number = Integer.parseInt(numberPart);

                    if (number > maxNumber) {
                        maxNumber = number;
                    }

                } catch (NumberFormatException e) {
                    // Ignore invalid ID
                }
            }
        }

        return prefix + String.format("%03d", maxNumber + 1);
    }


    public static void viewProducts() {

        System.out.println();
        System.out.println("========== VIEW PRODUCTS ==========");

        if (products.isEmpty()) {

            System.out.println("No products found.");

            return;
        }

        System.out.print("Enter the product's name (press enter for search): ");
        String searchText = scanner.nextLine().trim();
        int displayedProducts = 0;

        for (Product product : products) {

            if (!matchesSearch(product, searchText)) {
                continue;
            }

            System.out.println("----------------------------------");

            // Polymorphism
            System.out.println("Category: " + product.getCategory());

            product.displayInfo();
            displayedProducts++;
        }

        if (displayedProducts == 0) {
            System.out.println("No matching products found.");
        }

        System.out.println("----------------------------------");
    }


    static boolean matchesSearch(Product product, String searchText) {

        if (searchText.isEmpty()) {
            return true;
        }

        String query = searchText.toLowerCase();
        String name = product.getName().toLowerCase();

        return name.contains(query)
                || product.getId().toLowerCase().contains(query)
                || product.getCategory().toLowerCase().contains(query)
                || hasSimilarWord(name, query);
    }


    static boolean hasSimilarWord(String name, String query) {

        for (String word : name.split("\\s+")) {
            int allowedDifference = Math.max(1, query.length() / 4);

            if (Math.abs(word.length() - query.length()) <= allowedDifference
                    && levenshteinDistance(word, query) <= allowedDifference) {
                return true;
            }
        }

        return false;
    }


    static int levenshteinDistance(String first, String second) {

        int[] previousRow = new int[second.length() + 1];

        for (int index = 0; index <= second.length(); index++) {
            previousRow[index] = index;
        }

        for (int firstIndex = 1; firstIndex <= first.length(); firstIndex++) {
            int[] currentRow = new int[second.length() + 1];
            currentRow[0] = firstIndex;

            for (int secondIndex = 1; secondIndex <= second.length(); secondIndex++) {
                int replacementCost = first.charAt(firstIndex - 1)
                        == second.charAt(secondIndex - 1) ? 0 : 1;

                currentRow[secondIndex] = Math.min(
                        Math.min(currentRow[secondIndex - 1] + 1, previousRow[secondIndex] + 1),
                        previousRow[secondIndex - 1] + replacementCost
                );
            }

            previousRow = currentRow;
        }

        return previousRow[second.length()];
    }


    static Product findProductById(String id) {

        for (Product product : products) {

            if (product.getId().equalsIgnoreCase(id)) {

                return product;
            }
        }

        return null;
    }


    public static void updateProduct() {

        System.out.println();
        System.out.println("========== UPDATE PRODUCT ==========");


        System.out.print("Enter product ID: ");

        String id = scanner.nextLine();

        Product product = findProductById(id);

        if (product == null) {

            System.out.println("Product not found!");

            return;
        }


        System.out.println();
        System.out.println("Product found.");

        product.displayInfo();

        System.out.println();
        System.out.println("Press Enter to keep the current value.");


        System.out.print("New name [" + product.getName() + "]: ");

        String name = scanner.nextLine();

        if (!name.isEmpty()) {

            product.setName(name);
        }


        System.out.print("New price [" + product.getPrice() + "]: ");

        String priceInput = scanner.nextLine();

        if (!priceInput.isEmpty()) {

            try {

                double price = Double.parseDouble(priceInput);

                if (price >= 0) {

                    product.setPrice(price);

                } else {

                    System.out.println("Price cannot be negative.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Invalid price.");
            }
        }


        System.out.print(
                "New stock quantity [" +
                        product.getStockQuantity() +
                        "]: "
        );

        String stockInput = scanner.nextLine();

        if (!stockInput.isEmpty()) {

            try {

                int stock = Integer.parseInt(stockInput);

                if (stock >= 0) {

                    product.setStockQuantity(stock);

                } else {

                    System.out.println("Stock cannot be negative.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Invalid stock.");
            }
        }


        // Used pattern matching for instanceof (Java 16+) to clear IDE hints
        switch (product) {
            case ElectronicDevice device -> {
                
                System.out.print(
                        "New storage [" +
                                device.getStorage() +
                                " GB]: "
                );
                
                String storageInput = scanner.nextLine();
                
                if (!storageInput.isEmpty()) {
                    
                    try {
                        
                        int storage = Integer.parseInt(storageInput);
                        
                        if (storage > 0) {
                            
                            device.setStorage(storage);
                            
                        } else {
                            
                            System.out.println(
                                    "Storage must be greater than 0."
                            );
                        }
                        
                    } catch (NumberFormatException e) {
                        
                        System.out.println("Invalid storage.");
                    }
                }
                
                
                System.out.print(
                        "New warranty [" +
                                device.getWarranty() +
                                " months]: "
                );
                
                String warrantyInput = scanner.nextLine();
                
                if (!warrantyInput.isEmpty()) {
                    
                    try {
                        
                        int warranty = Integer.parseInt(warrantyInput);
                        
                        if (warranty >= 0) {
                            
                            device.setWarranty(warranty);
                            
                        } else {
                            
                            System.out.println(
                                    "Warranty cannot be negative."
                            );
                        }
                        
                    } catch (NumberFormatException e) {
                        
                        System.out.println("Invalid warranty.");
                    }
                }
            }
            case Clothes clothes -> {
                
                System.out.print(
                        "New size [" +
                                clothes.getSize() +
                                "]: "
                );
                
                String size = scanner.nextLine();
                
                if (!size.isEmpty()) {
                    
                    clothes.setSize(size);
                }
                
                
                System.out.print(
                        "New color [" +
                                clothes.getColor() +
                                "]: "
                );
                
                String color = scanner.nextLine();
                
                if (!color.isEmpty()) {
                    
                    clothes.setColor(color);
                }
            }
            case Cosmetics cosmetics -> {
                
                System.out.print(
                        "New skin type [" +
                                cosmetics.getSkinType() +
                                "]: "
                );
                
                String skinType = scanner.nextLine();
                
                if (!skinType.isEmpty()) {
                    
                    cosmetics.setSkinType(skinType);
                }
                
                
                System.out.print(
                        "New expiration date [" +
                                cosmetics.getExpirationDate() +
                                "]: "
                );
                
                String expirationDate = scanner.nextLine();
                
                if (!expirationDate.isEmpty()) {
                    
                    cosmetics.setExpirationDate(expirationDate);
                }
            }
            default -> {
            }
        }


        System.out.println();
        System.out.println("Product updated successfully!");
    }


    public static void deleteProduct() {

        System.out.println();
        System.out.println("========== DELETE PRODUCT ==========");

        System.out.print("Enter product ID: ");

        String id = scanner.nextLine();

        Product product = findProductById(id);

        if (product == null) {

            System.out.println("Product not found!");

            return;
        }

        products.remove(product);

        System.out.println(
                "Product " +
                        id +
                        " deleted successfully!"
        );
    }


    public static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid integer."
                );
            }
        }
    }


    public static double readDouble(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                double value = Double.parseDouble(input);

                if (value >= 0) {

                    return value;
                }

                System.out.println(
                        "Value cannot be negative."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}
