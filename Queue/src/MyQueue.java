import java.util.ArrayList;

public class MyQueue {
    private ArrayList <ClassA> arr = new ArrayList<>();


    public void enqueue(ClassA item){
        arr.add(arr.size(), item);
    }

    public ClassA dequeue(){
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

    public void displayQueue(){
        System.out.println("");
        for (int i=0; i<arr.size();i++)
        System.out.println(arr.get(i));
        System.out.println("");

    }
    
}
