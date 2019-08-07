package string1;
import java.util.*; 
import java.io.*; 
import java.util.Arrays;
import java.util.Scanner;

public class array1{
    
    // contain same elements. 
    public static boolean areEqual(int arr1[], int arr2[]) 
    { 
        int n = arr1.length; 
        int m = arr2.length; 
  
        // If lengths of array are not equal means 
        // array are not equal 
        if (n != m) 
            return false; 
  
        // Sort both arrays 
        Arrays.sort(arr1); 
        Arrays.sort(arr2); 
  
        // Linearly compare elements 
        for (int i = 0; i < n; i++) 
            if (arr1[i] != arr2[i]) 
                return false; 
  
        // If all elements were same. 
        return true; 
    }
    


public static void main(String[] args) throws Exception

{ 
    int arr1[] = {1,4,0,2,5};
    int arr2[] ={2,0,5,1,4}; 
    array1 ar=new array1();
    Scanner in=new Scanner(System.in);
    System.out.println("Enter Number of testcases");
    int c=in.nextInt();
    for(int i=0;i<c;i++){
    	System.out.println("Enter length of array");
    	int a=in.nextInt();
    	/*for(int j=0;j<a-1;j++){
    		if (in.hasNextInt()) {

                arr1[j] = in.nextInt();
    		} else {
                System.out.println("You didn't provide enough numbers");
                break;
            }

             
    	for(int k=0;j<a-1;j++){
        	
                arr2[k] = in.nextInt();
             

    	}*/
    	if (ar.areEqual(arr1, arr2)) 
            System.out.println("Yes"); 
        else
            System.out.println("No");	
    }

    	
    
}
}

