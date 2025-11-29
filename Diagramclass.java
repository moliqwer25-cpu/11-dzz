import java.util.ArrayList;
import java.util.List;

abstract class User {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String role;

    public User(int id, String name, String email, String address, String phone, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getRole() { return role; }

    public void register() { System.out.println(name + " registered"); }
    public void login() { System.out.println(name + " logged in"); }
    public void updateData() { System.out.println(name + " updated data"); }
}

class Client extends User {
    public Client(int id, String name, String email, String address, String phone) {
        super(id, name, email, address, phone, "Client");
    }
}

class Administrator extends User {
    public Administrator(int id, String name, String email, String address, String phone) {
        super(id, name, email, address, phone, "Administrator");
    }

    public void logAction(String action) {
        System.out.println("Admin action: " + action);
    }
}

class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String category;

    public Product(int id, String name, String description, double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getCategory() { return category; }

    public void create() { System.out.println("Product " + name + " created"); }
    public void update() { System.out.println("Product " + name + " updated"); }
    public void delete() { System.out.println("Product " + name + " deleted"); }
}

class Order {
    private int id;
    private String date;
    private String status;
    private Client client;
    private List<Product> products;
    private double total;

    public Order(int id, String date, Client client) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.products = new ArrayList<>();
        this.total = 0;
        this.status = "created";
    }

    public void addProduct(Product product) {
        products.add(product);
        total += product.getPrice();
    }

    public void place() {
        status = "placed";
        System.out.println("Order placed by " + client.getName() + " total: " + total);
    }

    public void cancel() {
        status = "canceled";
        System.out.println("Order canceled");
    }

    public void pay() {
        status = "paid";
        System.out.println("Order paid");
    }

    public String getStatus() { return status; }
    public double getTotal() { return total; }
}

class Payment {
    private int id;
    private String type;
    private double amount;
    private String status;
    private String date;

    public Payment(int id, String type, double amount, String date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.status = "pending";
    }

    public void process() {
        status = "completed";
        System.out.println("Payment processed: " + amount);
    }

    public void refund() {
        status = "refunded";
        System.out.println("Payment refunded: " + amount);
    }

    public String getStatus() { return status; }
}

class Delivery {
    private int id;
    private String address;
    private String status;
    private String courier;

    public Delivery(int id, String address, String courier) {
        this.id = id;
        this.address = address;
        this.courier = courier;
        this.status = "pending";
    }

    public void send() { status = "sent"; System.out.println("Delivery sent to " + address); }
    public void track() { System.out.println("Tracking delivery for " + address); }
    public void complete() { status = "completed"; System.out.println("Delivery completed"); }
    public String getStatus() { return status; }
}

class Review {
    private Client client;
    private Product product;
    private String text;
    private int rating;

    public Review(Client client, Product product, String text, int rating) {
        this.client = client;
        this.product = product;
        this.text = text;
        this.rating = rating;
    }

    public void leave() { System.out.println(client.getName() + " left review for " + product.getName()); }
}

public class Diagramclass {
    public static void main(String[] args) {
        Client client = new Client(1, "Ereke", "ereke@mail.com", "Almaty", "+77712345678");
        Administrator admin = new Administrator(2, "Admin", "admin@mail.com", "Almaty", "+77798765432");

        Product product1 = new Product(1, "Laptop", "Gaming Laptop", 1500, 5, "Electronics");
        Product product2 = new Product(2, "Mouse", "Wireless Mouse", 50, 10, "Electronics");

        Order order = new Order(1, "2025-11-29", client);
        order.addProduct(product1);
        order.addProduct(product2);
        order.place();

        Payment payment = new Payment(1, "Card", order.getTotal(), "2025-11-29");
        payment.process();

        Delivery delivery = new Delivery(1, "Almaty, Street 1", "Courier 1");
        delivery.send();
        delivery.track();
        delivery.complete();

        Review review = new Review(client, product1, "Great product!", 5);
        review.leave();
    }
}
