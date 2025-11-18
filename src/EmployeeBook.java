public class EmployeeBook {
    private Employee[] employees = new Employee[10];

    public void printAllEmployees() {
        for (Employee e : employees) {
            if (e != null) System.out.println(e);
        }
    }

    public double averageSalary() {
        int sum = 0, count = 0;
        for (Employee e : employees) {
            if (e == null) break;
            sum += e.getSalary();
            count++;
        }
        return count == 0 ? 0 : (double) sum / count;
    }

    public void printTaxes(String scheme) {
        for (Employee e : employees) {
            if (e == null) continue;
            int salary = e.getSalary();
            double tax = 0;
            switch (scheme) {
                case "PROPORTIONAL":
                    tax = salary * 0.13;
                    break;
                case "PROGRESSIVE":
                    if (salary <= 150) tax = salary * 0.13;
                    else if (salary <= 350) tax = salary * 0.17;
                    else tax = salary * 0.21;
                    break;
                default:
                    System.out.println("Неизвестная схема налогов");
                    continue;
            }
            System.out.println("Сотрудник " + e.getFullName() + " (зарплата " + salary + "), налог: " + tax);
        }
    }

    public void indexSalaryByDepartment(int department, double percent) {
        for (Employee e : employees) {
            if (e == null) continue;
            if (e.getDepartment() != department) continue;
            int oldSalary = e.getSalary();
            int newSalary = (int) Math.round(oldSalary * (1 + percent / 100));
            if (oldSalary == newSalary) continue;
            e.setSalary(newSalary);
        }
    }

    public void printFirstEmployeeByDeptAndSalary(int department, int minSalary) {
        for (int i = 0; i < employees.length; i++) {
            Employee e = employees[i];
            if (e == null) break;
            if (e.getDepartment() == department && e.getSalary() > minSalary) {
                System.out.println("Порядковый номер: " + (i + 1));
                e.printShortInfo();
                break;
            }
        }
    }

    public void printEmployeesBelowWage(int wage, int employeeNumber) {
        int count = 0, i = 0;
        while (i < employees.length && count < employeeNumber) {
            Employee e = employees[i];
            if (e == null) break;
            if (e.getSalary() < wage) {
                e.printShortInfo();
                count++;
            }
            i++;
        }
    }

    public boolean contains(Employee employee) {
        for (Employee e : employees) {
            if (e == null) continue;
            if (e.equals(employee)) return true;
        }
        return false;
    }

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (Employee e : employees) {
            if (e == null) continue;
            if (e.getId() == id) return e;
        }
        return null;
    }
}

