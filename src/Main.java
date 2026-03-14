public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();
        for (int i = 1; i <= 11; i++) {
            Employee emp = new Employee("Сотрудник " + i, (i % 5) + 1, 100 + i * 10);
            boolean result = book.addEmployee(emp);
            System.out.println("Сотрудник " + i + " добавлен:" + result);
        }

        book.printAllEmployees();

        System.out.println("Средняя зарплата: " + book.calculateAverageSalary());

        book.printTaxes("PROGRESSIVE");

        book.indexSalaryInDepartment(1, 10);
        System.out.println("Зарплаты в отделе 1 проиндексированы на 10%");

        System.out.print("Поиск богатого в отделе 2: ");
        book.findFirstHighSalaryInDept(2, 120);

        System.out.println("Сотрудники с ЗП меньше 180 (первые 2):");
        book.printEmployeesWithSalaryLessThan(180, 2);

        Employee empById = book.getEmployeeById(5);
        if (empById != null) {
            System.out.print("Найден по ID 5: ");
            empById.printShortInfo();
        }

        Employee duplicate = new Employee("Дублер", 1, 165);
        System.out.println("Есть ли сотрудник с ЗП 150? " + book.hasEmployeeWithSameSalary(duplicate));

    }
}