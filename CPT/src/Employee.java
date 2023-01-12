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
