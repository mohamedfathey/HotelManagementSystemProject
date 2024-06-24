package HotelManagementSystem;

public class Employee {
    private int id ;
    private String name;
    private double salary ;
    private String job ;
    // Constructor
    public Employee(int id, String name, double salary, String job) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.job = job;
    }

    // Empty Constructor

    public Employee() {
    }
    // Setter and Getter

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    // Display Employee

    public void print (){
        System.out.println("------------------\n");
        System.out.println("id --> " + id
                +" \n  name --> " +name+
                "\n Salary --> "+ salary
                +"\n Jop --> " + job
        );
        System.out.println("------------------------\n");
    }

}
