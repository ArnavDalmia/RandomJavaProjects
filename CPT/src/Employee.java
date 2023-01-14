public class Employee {
    private String type; // either "Employee" or "Manager"
    private String name;
    private int age;
    private int ID;
    private int salary;

    public Employee(String type, String name,int age,int ID,int salary){
        this.type = type;
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.salary = salary;
    }
    
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getID(){
        return ID;
    }
    public int getSalary(){
        return salary;
    }

    public String getType(){
        return type;
    }
    public void printDetailsSimple(){
        
        System.out.print("Employee Status     :  " + type);
        System.out.print(",  Employee ID   :  " + ID);
        System.out.println(",  Employee Name   :  " + name);
    }

    public void printDetails() {
        System.out.print("Employee Status     :  " + type);
        System.out.print(",  Employee ID   :  " + ID);
        System.out.print(",  Employee Name   :  " + name);
        System.out.print(",  Employee Age    :  " + age);
        System.out.println(",  Employee Salary :  " + salary);
      }

}
