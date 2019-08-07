package java123;

import java.util.BitSet;

public class MissingNumberInArrayN{
public static void printMissingNumberIn1To100(int[] Numbers, int count)
	  {
		  int missingNumbers = count - Numbers.length;
		  BitSet bitset = new BitSet(count);
		  
		  for(int number : Numbers)
		  {
			  bitset.set(number - 1);
		  }
		  
		  int missingIndex = 0;
		  for(int i = 0; i < missingNumbers; i++)
		  {
			  missingIndex = bitset.nextClearBit(missingIndex);
			  System.out.printf("%n Missing Number is %d", ++missingIndex);
		  }
	  }
 
public static void main(String[] args)
{
	int[] numbers = {1, 2, 3, 4, 5,6, 7, 10, 11, 13, 50, 55, 60, 75, 100};
 
 	printMissingNumberIn1To100(numbers, 100);
}
}