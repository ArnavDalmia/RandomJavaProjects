import java.util.Arrays;

public class Main {
	
	public static void mergeTwoArrays(int[] firstSource, int [] secondSource, int[] destination) {
		int firstCurrentIndex = 0;
		int secondCurrentIndex = 0;
		int thirdCurrentIndex = 0;
		
		while(firstCurrentIndex<firstSource.length&& secondCurrentIndex<secondSource.length) {
			if (firstSource[firstCurrentIndex] < secondSource[secondCurrentIndex]) {
                destination[thirdCurrentIndex] = firstSource[firstCurrentIndex];
                firstCurrentIndex++;
            }
            	
            else {
            	destination[thirdCurrentIndex] = secondSource[secondCurrentIndex];
            	secondCurrentIndex++;
            }
            thirdCurrentIndex++;	
        }
     
        while (firstCurrentIndex < firstSource.length) {
            destination[thirdCurrentIndex] = firstSource[firstCurrentIndex];
            thirdCurrentIndex++;
            firstCurrentIndex++;
        }
            
     
        while (secondCurrentIndex < secondSource.length) {
            destination[thirdCurrentIndex] = secondSource[secondCurrentIndex];
            thirdCurrentIndex++;
            secondCurrentIndex++;
        }
            
    }
	
	public static int insertionSort(int[] array) {
		int j;
		int temp;
		int count = 0;
		for(int i=1; i < array.length; i++) {
			temp = array[i];
			j=i;
			while(j > 0 && array[j-1]>temp) {
				array[j] = array[j-1];
				j--;
				System.out.println(Arrays.toString(array));
			}
			array[j] = temp;
			System.out.println(Arrays.toString(array));
			count++;
		}
		return count;
		
	}
	
	public static void arrayToString(int[] myArray) {
		for (int i=0;i<myArray.length;i++) {
			System.out.print(myArray[i]);
			if (i != myArray.length-1)
				System.out.print(",");
		}
		System.out.println(" ");
	}
	public static void swap(int [] array, int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}
	
	public static int sortSelection(int [] array) {
		int count = 0;
		int minIndex = 0;
		for(int i=0; i<array.length -1; i++) {
			minIndex = i;
			for (int j = i+1; j<array.length; j++) {
				if (array[j]<array[minIndex])
					minIndex = j;
			}
			swap(array,i,minIndex);
			System.out.println(Arrays.toString(array));
			count++;
		}
		return count;
	}
	

	public static int bubbleSort(int[] array) {
		int count = 0;
		for(int i=0; i< array.length; i++) {
			for (int j=1; j<array.length-i; j++) {
				if(array[j-1]>array[j]) {
					swap(array,j,j-1);
					System.out.println(Arrays.toString(array));
					count++;
				}
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
	//int [] B = {15,10,7,5,1};
	int [] B = {10,9,8,7,6};
	System.out.println(Arrays.toString(B));

	int number = bubbleSort(B);
	System.out.println(number);
	}

}
