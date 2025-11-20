public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();
        for (int i = 0; i < 11; i++) {
            boolean added = book.addEmployee(new Employee("Имя " + (i + 1), (i % 5) + 1, 50 + (i * 40)));
            System.out.println("Добавление сотрудника " + (i + 1) + ": " + added);
        }
        System.out.println("-- Все сотрудники --");
        book.printAllEmployees();
        System.out.println("-- Средняя зарплата --");
        System.out.println(book.averageSalary());
        System.out.println("-- Схема налогов PROPORTIONAL --");
        book.printTaxes("PROPORTIONAL");
        System.out.println("-- Схема налогов PROGRESSIVE --");
        book.printTaxes("PROGRESSIVE");

        System.out.println("-- Индексация зарплаты отдела 2 на 15% --");
        book.indexSalaryByDepartment(2, 15);

        System.out.println("-- Первый сотрудник отдела 3 с зарплатой > 100 --");
        book.printFirstEmployeeByDeptAndSalary(3, 100);

        System.out.println("-- Первые 3 сотрудника с зарплатой < 200 --");
        book.printEmployeesBelowWage(200, 3);

        System.out.println("-- Есть ли сотрудник с зарплатой 130? --");
        Employee checkEmployee = new Employee("Кто-то", 1, 130);
        System.out.println(book.contains(checkEmployee));

        System.out.println("-- Получить сотрудника по id 2 --");
        Employee emp = book.getEmployeeById(2);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Сотрудник не найден");
        }
    }
}