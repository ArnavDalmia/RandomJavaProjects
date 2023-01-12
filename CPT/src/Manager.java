public class Manager extends Employee {
    private String department;

    public Manager(String name, int age, int ID, int salary, String dept) {
        super(name, age, ID, salary);
        this.department = dept;
    }

    public void printDetailsSimple(){
        super.printDetailsSimple();
    }

    public void printDetails() {
        super.printDetails();
        System.out.println(",  Manager Department :  " + department);
      }
    
}
