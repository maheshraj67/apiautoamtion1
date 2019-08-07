package java123;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max=-63;
        for (int i = 0; i <4; i++) {
           
            for (int j = 0; j <4; j++) {
               
                int sum;
                int top = arr[i][j]+arr[i][j+1]+arr[i][j+2];
                int middle= arr[i+1][j+1];
                int last=arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                sum=top+middle+last;
                if(sum>max)
                max=sum;

            }
        }
return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];
        /*arr={{1, 1, 1 ,0, 0, 0}
        	,{0 ,1, 0, 0, 0, 0}
        		,{1 ,1, 1, 0, 0 ,0}
        		,{0, 0 ,2, 4, 4, 0}
        		,{0 ,0, 0 ,2 ,0, 0}
        		,{0, 0, 1 ,2, 4 ,0}};*/

        for (int i = 0; i < arr.length; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j <arr[i].length; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                
                int sum;
                
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
