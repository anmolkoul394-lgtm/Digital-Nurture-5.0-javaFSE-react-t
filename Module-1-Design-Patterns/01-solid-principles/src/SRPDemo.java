// SRPDemo.java
// Demonstrates the Single Responsibility Principle (SRP).
// A class should have ONLY ONE reason to change.
// Here, invoice calculation, printing, and saving are split into 3 separate classes
// instead of cramming all of them into one "Invoice" class.

// Responsibility 1: Holds invoice data and calculates the total.
class Invoice {
    private String customerName;
    private double price;
    private int quantity;

    public Invoice(String customerName, double price, int quantity) {
        this.customerName = customerName;
        this.price = price;
        this.quantity = quantity;
    }

    // Only responsibility: calculate total amount
    public double calculateTotal() {
        return price * quantity;
    }

    public String getCustomerName() {
        return customerName;
    }
}

// Responsibility 2: Knows HOW to print an invoice. Nothing else.
class InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("Printing invoice for: Customer - " + invoice.getCustomerName()
                + ", Total - " + invoice.calculateTotal());
    }
}

// Responsibility 3: Knows HOW to persist an invoice. Nothing else.
class InvoiceRepository {
    public void save(Invoice invoice) {
        System.out.println("Saving invoice to database for customer: " + invoice.getCustomerName());
    }
}

public class SRPDemo {
    public static void main(String[] args) {
        // Create an invoice (responsibility: data + calculation)
        Invoice invoice = new Invoice("Raj", 250.0, 2);
        System.out.println("Invoice calculated: Total = " + invoice.calculateTotal());

        // Printing is delegated to a separate class
        InvoicePrinter printer = new InvoicePrinter();
        printer.print(invoice);

        // Saving is delegated to another separate class
        InvoiceRepository repository = new InvoiceRepository();
        repository.save(invoice);
    }
}
