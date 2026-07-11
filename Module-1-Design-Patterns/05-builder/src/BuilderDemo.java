// BuilderDemo.java
// Demonstrates the Builder Design Pattern.
// Builds a complex "Computer" object step by step, with optional fields,
// instead of one giant constructor with many parameters.

class Computer {
    // Required fields
    private final String cpu;
    private final int ramGb;

    // Optional fields
    private final int storageGb;
    private final boolean hasGraphicsCard;
    private final boolean hasBluetooth;

    // Private constructor - can ONLY be called by the Builder.
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ramGb = builder.ramGb;
        this.storageGb = builder.storageGb;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
    }

    @Override
    public String toString() {
        return "Computer Configuration: CPU=" + cpu
                + ", RAM=" + ramGb + "GB"
                + ", Storage=" + storageGb + "GB SSD"
                + ", GraphicsCard=" + hasGraphicsCard
                + ", Bluetooth=" + hasBluetooth;
    }

    // Static nested Builder class - handles step-by-step construction.
    public static class Builder {
        // Required fields, passed in the Builder's constructor.
        private final String cpu;
        private final int ramGb;

        // Optional fields, with sensible defaults.
        private int storageGb = 256;
        private boolean hasGraphicsCard = false;
        private boolean hasBluetooth = false;

        public Builder(String cpu, int ramGb) {
            this.cpu = cpu;
            this.ramGb = ramGb;
        }

        // Each setter returns "this" so calls can be chained (fluent API).
        public Builder setStorage(int storageGb) {
            this.storageGb = storageGb;
            return this;
        }

        public Builder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Builder setBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        // Final step: builds the immutable Computer object.
        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        // Build a high-end gaming computer
        Computer gamingPc = new Computer.Builder("Intel i7", 16)
                .setStorage(512)
                .setGraphicsCard(true)
                .setBluetooth(false)
                .build();
        System.out.println(gamingPc);

        // Build a simpler budget computer, using default storage
        Computer budgetPc = new Computer.Builder("AMD Ryzen 5", 8)
                .setStorage(256)
                .setGraphicsCard(false)
                .setBluetooth(true)
                .build();
        System.out.println(budgetPc);
    }
}
