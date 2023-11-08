import java.util.*;

public class SortingApp{

    public static void main(String[] args){
     
        int arr_data[] = {14, 56, 78, 45, 19, 45, 5, 87};

        /*
        System.out.println();
        System.out.println("Original Array: ");
        display(arr_data);
        System.out.println();
        */
       
        /* 
        System.out.println("Bubble Sort: ");
        bubble(arr_data);
        display(arr_data);
        System.out.println();
        */

        /* 
        System.out.println("Selection Sort: ");
        selection(arr_data);
        display(arr_data);
        System.out.println();
        */

        /* 
        System.out.println("Insertion Sort: ");
        insertion(arr_data);
        display(arr_data);
        System.out.println();
        */

        /*
        System.out.println("Array Sort: ");
        Arrays.sort(arr_data);
        display(arr_data);
        System.out.println();
        */

        /* 
        System.out.println("Array Sort with conditions: ");
        Arrays.sort(arr_data, 4, 7);
        display(arr_data);
        System.out.println();
        */

    }

    public static void insertion(int data[]){
        int a, b, temp;

        for (a = 1; a < data.length; a++){
            temp = data[a];

            for(b = a - 1; b >= 0; b--){
                if (data[b] > temp){
                    data[b + 1] = data[b];
                }
                else{
                    break;
                }
            }

            data[b + 1] = temp;
        }
    }

    public static void selection(int data[]){
        int a, b, index_of_smallest, temp;

        for (a = 0; a < data.length - 1; a++){
            index_of_smallest = a;

            for(b = a + 1; b < data.length - 1; b++){
                if (data[b] < data[index_of_smallest]){
                    index_of_smallest = b;
                }
            }

            temp = data[a];
            data[a] = data[index_of_smallest];
            data[index_of_smallest] = temp;
        }
    }

    public static void bubble(int data[]){
        int a, b, temp;

        for (a = 0; a < data.length - 1; a++){
            
            for (b = data.length - 1; b > a; b--){
                if (data[b - 1] > data[b]){   // > ascending ; < descending
                    temp = data[b];
                    data[b] = data[b - 1];
                    data[b - 1] = temp;
                }
            }
        }
    }

    public static void display(int data[]){
        for(int i = 0; i < data.length; i++){
            System.out.printf("%2d ", data[i]);
        }
        System.out.println();
    }
}