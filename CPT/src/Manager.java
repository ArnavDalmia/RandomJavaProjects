public class Manager extends Employee {
    private String department;

    public Manager(String name, int age, int ID, int salary, String dept) {
        super(name, age, ID, salary);
        this.department = dept;
    }

    public Manager getNewEmployee(){
        String name = Utils.obtainInput("Enter Name: ");
        int ID = Utils.obtainIntegerInput("Enter ID: ");
        int age = Utils.obtainIntegerInput("Enter age: ");
        int salary = Utils.obtainIntegerInput("Enter salary: ");
        String dept = Utils.obtainInput("Enter Department: ");


        Manager temp = new Manager(name, age, ID, salary, dept);
        return temp;

    }

    public void printDetailsSimple(){
        super.printDetailsSimple();
    }

    public void printDetails() {
        super.printDetails();
        System.out.println(",  Manager Department :  " + department);
      }
    
}
