public class EmployeeBook {
    private Employee[] employees = new Employee[10];

    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public double calculateAverageSalary() {
        double sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            } else {
                sum += employee.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    public void printTaxes(String type) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            double salary = employee.getSalary();
            double tax = 0;
            switch (type) {
                case "PROPORTIONAL":
                    tax = salary * 0.13;
                    break;
                case "PROGRESSIVE":
                    if (salary <= 150) {
                        tax = salary * 0.13;
                    } else if (salary > 350) {
                        tax = salary * 0.21;
                    } else {
                        tax = salary * 0.17;
                    }
                    break;
            }
            System.out.println(employee.getFullName() + ": Налог составит " + tax);
        }
    }

    public void indexSalaryInDepartment(int department, double percent) {
        for (Employee employee : employees) {
            if (employee == null || department != employee.getDepartment()) {
                continue;
            } else {
                double oldSalary = employee.getSalary();
                double newSalary = oldSalary * (1 + percent / 100);
                employee.setSalary(newSalary);
            }
        }
    }

    public void findFirstHighSalaryInDept(int department, double salary) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee == null) continue;
            if (salary < employee.getSalary() && department == employee.getDepartment()) {
                System.out.print((i + 1) + ". ");
                employee.printShortInfo();
                break;
            }
        }
    }

    public void printEmployeesWithSalaryLessThan(double wage, int employeeNumber) {
        int i = 0;
        int count = 0;
        while (i < employees.length && count < employeeNumber) {
            if (employees[i] != null && wage > employees[i].getSalary()) {
                employees[i].printShortInfo();
                count++;
            }
            i++;
        }
    }

    public boolean hasEmployeeWithSameSalary(Employee employee) {
        for (Employee employee1 : employees) {
            if (employee1 == null) continue;
            if (employee1.equals(employee)) return true;
        }
        return false;
    }

    public boolean addEmployee(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getId() == id) return employee;
        }
        return null;
    }

}
