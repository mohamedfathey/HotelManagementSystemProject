package HotelManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
    public static void addNewEmployee(ArrayList<Employee>employees, Scanner scanner){
        System.out.println("Enter Your Name !");
        String name = scanner.next();
        System.out.println("Enter Salary (Double) !");
        double salary = scanner.nextDouble();
        System.out.println("Enter Job !");
        String job = scanner.next();
        int id = employees.size();
        Employee employee= employees.get(id);
        employee.setName(name);
        employee.setJob(job);
        employee.setSalary(salary);
        employees.add(employee);
        // or
        Employee employee1 = new Employee(id,name,salary,job);
        employees.add(employee1);
    }

    public static  void  showAllEmployee(ArrayList<Employee>employees){
        for (Employee employee: employees){
            employee.print();
        }
    }
    public static void editEmployeeData (ArrayList<Employee>employees, Scanner scanner){
        System.out.println("Enter id \n -1 to show all employee");
        int id = scanner.nextInt();
        if (id == -1 ){
            showAllEmployee(employees);
            System.out.println("Entre id (int)");
        }
        Employee employee = employees.get(id);

        System.out.println("Enter name \n -1 to keep it");
        String name = scanner.next();
        if (name.equals(-1)){
            name = employee.getName();
        }

        System.out.println("Enter salary \n -1 to keep it");
        double salary = scanner.nextDouble();
        if (salary==-1){
            salary = employee.getSalary();
        }

        System.out.println("Enter job \n -1 to keep it");
        String job = scanner.next();
        if (job.equals(-1)){
            job = employee.getJob();
        }
        employee.setName(name);
        employee.setSalary(salary);
        employee.setJob(job);
        employees.set(id,employee);
    }
}
