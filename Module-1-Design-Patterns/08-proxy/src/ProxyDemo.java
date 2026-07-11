// ProxyDemo.java
// Demonstrates the Proxy Design Pattern.
// DocumentProxy controls access to the real, "expensive" RealDocument object,
// only allowing users with the correct role to view it.

// Common interface implemented by both the real object and its proxy.
interface Document {
    void display();
}

// The "real" object - imagine loading this from disk is expensive/slow.
class RealDocument implements Document {
    private String fileName;

    public RealDocument(String fileName) {
        this.fileName = fileName;
        loadFromDisk(); // simulate expensive initialization
    }

    private void loadFromDisk() {
        System.out.println("Loading document from disk: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying document: " + fileName);
    }
}

// The Proxy - controls access to RealDocument, and only creates it (lazy loading)
// when access is actually granted.
class DocumentProxy implements Document {
    private RealDocument realDocument; // created only when needed
    private String fileName;
    private String userRole;

    public DocumentProxy(String fileName, String userRole) {
        this.fileName = fileName;
        this.userRole = userRole;
    }

    @Override
    public void display() {
        // Access control logic lives HERE, in the proxy, not in RealDocument.
        if (!"admin".equalsIgnoreCase(userRole) && !"manager".equalsIgnoreCase(userRole)) {
            System.out.println("Access denied. \"" + userRole + "\" cannot view confidential documents.");
            return;
        }

        // Lazy initialization: create the real (expensive) object only when access is granted.
        if (realDocument == null) {
            realDocument = new RealDocument(fileName);
        }
        realDocument.display();
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        // Guest user tries to access - should be denied, RealDocument never created.
        Document guestView = new DocumentProxy("Salary_Report.pdf", "guest");
        guestView.display();

        // Manager tries to access - should be allowed, RealDocument is created and displayed.
        Document managerView = new DocumentProxy("Salary_Report.pdf", "manager");
        managerView.display();
    }
}
