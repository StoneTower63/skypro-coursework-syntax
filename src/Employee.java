public class Employee {
    private final String fullName;
    private int department;
    private double salary;
    private int id;
    private static int counter = 1;

    public Employee(String fullName, int department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0;
    }

    @Override
    public String toString() {
        return "ID: " + id + "; ФИО: " + fullName + "; Отдел: " + department + "; Зарплата: " + salary;
    }

    public void printShortInfo(){
        System.out.println("ФИО: " + fullName + "; Зарплата: " + salary);
    }
}
