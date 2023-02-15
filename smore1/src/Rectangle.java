public class Rectangle {
    int [][] rectangle = new int[3][4];

    public boolean isPerfect(int num){
        for(double i=1.0; i<num; i++){
            if ((double)num/i == i)
                return true;
        }
        return false;
    }

    public boolean entriesSum(){
        int total = 0;
        for(int i =0; i<rectangle.length;i++){
            for(int j =0; j<rectangle.length;j++){
                total += rectangle[i][j];
        }
    }
    return isPerfect(total);
    }
    public boolean rowSums(){
        for(int i =0; i<rectangle.length;i++){
            int total = 0;
            for(int j =0; j<rectangle.length;j++){
                total += rectangle[i][j];
        }
        if (total % 2 == 0)
            return false;   
    }
    return true;
    }
    public boolean colSums(){
        for(int i =0; i<rectangle.length;i++){
            int total = 0;
            for(int j =0; j<rectangle.length;j++){
                total += rectangle[j][i];
        }
        if (total % 2 != 0)
            return false;   
    }
    return true;
    }

    public boolean checkRect(){
        boolean entries = entriesSum();
        boolean row = rowSums();
        boolean col = colSums();
        if (entries && row && col)
            return true;
        else 
            return false;
    }

}
