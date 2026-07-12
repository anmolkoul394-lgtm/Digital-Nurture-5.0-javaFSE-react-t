// EmployeeWithoutLombok.java
// Shows the BOILERPLATE code needed WITHOUT Lombok - compare this to Employee.java,
// which does the exact same job in a fraction of the lines using Lombok annotations.

public class EmployeeWithoutLombok {
    private int id;
    private String name;
    private double salary;

    public EmployeeWithoutLombok() {
        // no-args constructor, written by hand
    }

    public EmployeeWithoutLombok(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeWithoutLombok(id=" + id + ", name=" + name + ", salary=" + salary + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EmployeeWithoutLombok)) return false;
        EmployeeWithoutLombok other = (EmployeeWithoutLombok) obj;
        return id == other.id && Double.compare(salary, other.salary) == 0
                && (name == null ? other.name == null : name.equals(other.name));
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        long salaryBits = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (salaryBits ^ (salaryBits >>> 32));
        return result;
    }
}
