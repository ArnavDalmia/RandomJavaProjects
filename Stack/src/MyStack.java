import java.util.ArrayList;

public class MyStack {
    private ArrayList <ClassA> arr = new ArrayList<>();


    public void push(ClassA item){
        arr.add(0,item);
    }
    public ClassA pop(){
        if(arr.isEmpty())
            throw new IllegalArgumentException();
        ClassA temp;
        temp = arr.get(0);
        arr.remove(0);
        return temp;
    }
    
    public boolean isEmpty(){
        if (arr.size()==0)
        return true;
        else
        return false;
    }
    public void displayStack(){
        System.out.println("");
        for (int i=0; i<arr.size();i++)
        System.out.println(arr.get(i));
        System.out.println("");

    }
    
}
