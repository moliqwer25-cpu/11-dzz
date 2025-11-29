interface Frontend {
    void sendRequest(String request);
}

interface Backend {
    void processRequest(String request);
}

interface Database {
    void saveData(String data);
    String getData(String query);
}

interface RouteOptimizationModule {
    void calculateOptimalRoutes();
}

interface CourierIntegrationModule {
    void getDeliveryStatus();
    void manageCouriers();
}

interface InventoryManagementModule {
    void trackStock();
    void reserveProducts();
    void moveProducts();
}

interface NotificationSystem {
    void sendClientNotifications(String message);
    void sendCourierNotifications(String message);
}

interface AnalyticsModule {
    void generateReports();
    void analyzePerformance();
}

class WebApp implements Frontend {
    private Backend backend;
    public WebApp(Backend backend) {
        this.backend = backend;
    }
    public void sendRequest(String request) {
        System.out.println("WebApp sends request: " + request);
        backend.processRequest(request);
    }
}

class MobileApp implements Frontend {
    private Backend backend;
    public MobileApp(Backend backend) {
        this.backend = backend;
    }
    public void sendRequest(String request) {
        System.out.println("MobileApp sends request: " + request);
        backend.processRequest(request);
    }
}

class BackendServer implements Backend {
    private Database database;
    private RouteOptimizationModule routeModule;
    private CourierIntegrationModule courierModule;
    private InventoryManagementModule inventoryModule;
    private NotificationSystem notificationSystem;
    private AnalyticsModule analyticsModule;

    public BackendServer(Database db, RouteOptimizationModule rm, CourierIntegrationModule cm,
                         InventoryManagementModule im, NotificationSystem ns, AnalyticsModule am) {
        this.database = db;
        this.routeModule = rm;
        this.courierModule = cm;
        this.inventoryModule = im;
        this.notificationSystem = ns;
        this.analyticsModule = am;
    }

    public void processRequest(String request) {
        System.out.println("Backend processing: " + request);
        database.saveData(request);
        routeModule.calculateOptimalRoutes();
        courierModule.getDeliveryStatus();
        inventoryModule.trackStock();
        notificationSystem.sendClientNotifications("Request processed: " + request);
        analyticsModule.analyzePerformance();
    }
}

class SimpleDatabase implements Database {
    public void saveData(String data) {
        System.out.println("Saving data: " + data);
    }
    public String getData(String query) {
        return "Data for: " + query;
    }
}

class SimpleRouteModule implements RouteOptimizationModule {
    public void calculateOptimalRoutes() {
        System.out.println("Calculating optimal routes...");
    }
}

class SimpleCourierIntegration implements CourierIntegrationModule {
    public void getDeliveryStatus() {
        System.out.println("Getting delivery status...");
    }
    public void manageCouriers() {
        System.out.println("Managing couriers...");
    }
}

class SimpleInventory implements InventoryManagementModule {
    public void trackStock() {
        System.out.println("Tracking stock...");
    }
    public void reserveProducts() {
        System.out.println("Reserving products...");
    }
    public void moveProducts() {
        System.out.println("Moving products...");
    }
}

class SimpleNotificationSystem implements NotificationSystem {
    public void sendClientNotifications(String message) {
        System.out.println("Client notification: " + message);
    }
    public void sendCourierNotifications(String message) {
        System.out.println("Courier notification: " + message);
    }
}

class SimpleAnalytics implements AnalyticsModule {
    public void generateReports() {
        System.out.println("Generating reports...");
    }
    public void analyzePerformance() {
        System.out.println("Analyzing performance...");
    }
}

public class DiagramComponent {
    public static void main(String[] args) {
        Database db = new SimpleDatabase();
        RouteOptimizationModule routeModule = new SimpleRouteModule();
        CourierIntegrationModule courierModule = new SimpleCourierIntegration();
        InventoryManagementModule inventory = new SimpleInventory();
        NotificationSystem notifications = new SimpleNotificationSystem();
        AnalyticsModule analytics = new SimpleAnalytics();

        BackendServer backend = new BackendServer(db, routeModule, courierModule, inventory, notifications, analytics);

        Frontend webApp = new WebApp(backend);
        Frontend mobileApp = new MobileApp(backend);

        webApp.sendRequest("New Order #101");
        mobileApp.sendRequest("Update Order #102");
    }
}
