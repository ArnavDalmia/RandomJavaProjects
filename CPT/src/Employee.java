public class Employee {
    private String name;
    private int age;
    private int ID;
    private int salary;
    public Employee(String name,int age,int ID,int salary){
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.salary = salary;
    }
    
    public String getName(){
        return name;
    }

    public Employee getNewEmployee(){
        String name = Utils.obtainInput("Enter Name: ");
        int ID = Utils.obtainIntegerInput("Enter ID: ");
        int age = Utils.obtainIntegerInput("Enter age: ");
        int salary = Utils.obtainIntegerInput("Enter salary: ");

        Employee temp = new Employee(name, age, ID, salary);
        return temp;

    }

    public void printDetailsSimple(){
        System.out.print("Employee ID     :  " + ID);
        System.out.print(",  Employee Name   :  " + name);
    }

    public void printDetails() {
        System.out.print("Employee ID     :  " + ID);
        System.out.print(",  Employee Name   :  " + name);
        System.out.print(",  Employee Age    :  " + age);
        System.out.print(",  Employee Salary :  " + salary);
      }

}
