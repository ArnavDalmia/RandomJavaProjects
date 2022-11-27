public class ClassA {
    private String name;
    private int value;

    public ClassA(String name, int val){
        this.name = name;
        this.value = val;
    }

    public String getName(){
        return name;
    }
    public int getValue(){
        return value;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setValue(int value){
        this.value = value;
    }
    public String toString(){ // come back
        String message;
        message = "Name: "+name+ ", Value: "+value;
        return message;
    }
}
