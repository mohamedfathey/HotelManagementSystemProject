package HotelManagementSystem;

public class Guest {
    private int id;
    private String name;
    private String email;
    private int discount;

    // constructor
    public Guest(int id, String name, String email, int discount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.discount = discount;
    }

    // Empty Constructor
    public Guest() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public  void print ()
    {
        System.out.println("Id <<- "+ id+
                "\n Name <<- " + name+
                "\n Email <<- "+ email+
                "\n Discount <<- " + discount
                );
        System.out.println();
    }

}
