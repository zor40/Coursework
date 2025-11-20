import java.util.Objects;

public class Employee {
    private final String fullName;
    private int department;
    private int salary;
    private static int idCounter = 1;
    private final int id;

    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = idCounter++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5");
        }
        this.department = department;
    }

    public void setSalary(int salary) {
        if (salary >= 50 && salary <= 450) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Зарплата должна быть в диапазоне 50–450");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return (department == employee.department) && (salary == employee.salary) && (id == employee.id) && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(salary);
    }

    @Override
    public String toString() {
        return id + " " + "Ф.И.О.-" + " " + this.fullName + " " + "Отдел №" + " " + this.department + " " + "Зарплата" + " " + this.salary;
    }

    public void printShortInfo() {
        System.out.println("Имя: " + fullName + ", Зарплата: " + salary);
    }
}











