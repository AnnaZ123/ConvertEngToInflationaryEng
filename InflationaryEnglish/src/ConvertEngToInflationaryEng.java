
// Z
// 2017 March 29

/*
	Coding Exercise:
	Write a program in Java that converts a sentence from English to Inflationary English.
	Inflationary English takes words and word parts that sound the same as a number 
		(e.g. ÒwonÓ v. ÒoneÓ) and then inflates that to the next number (e.g. ÒwonÓ becomes ÒtwoÓ). 
		Provide tests for your program.
    Example of input and output:
       Input: ÒToday I won an award for being awesome.Ó
       Output: ÒThreeday I two an award five being awesome."

*/

/*
 * 	Input: String
 * 	Output: String
 * 
 * 	Algorithm:
 * 		Check every word in string against dictionary.
 * 		If word is in dictionary, then inflate to next number.
 * 
 * */



public class ConvertEngToInflationaryEng {
	
	public static String convert( String myString )
	{
		String s = ""; //comment out later
		
		//first, let's start with obvious.  Straight numbers
		//length of array needs to be precise
		//	(remember this is not an ArrayList)
		//last match has to have next element array to replace the word
		String[] myDictionary = new String[6];
		
		myDictionary[0] = "zero";
		myDictionary[1] = "one";
		myDictionary[2] = "two";
		myDictionary[3] = "three";
		myDictionary[4] = "four";
		myDictionary[5] = "five";
		
		//Check every word in string against dictionary.
		//	If word is in dictionary, then inflate to next number.
		
		//this for loop will return true every iteration if 
		//	we start from the first number (ex: 1 -> 2 -> 3 )
		//  therefore, we have to start from the last number and decrement
		
		for( int i = myDictionary.length - 1; i >= 0; i-- )
		{
			//System.out.println(myDictionary[i]);
			if( myString.contains(myDictionary[i]) )
			{
				System.out.println("true!");
				myString = myString.replaceAll(myDictionary[i], myDictionary[i+1]);
				System.out.println(myString);
			}
			
		}
		
		
		return s; //comment out later
	}
	
	
	
	public static void main( String[] args )
	{
		//convert("my one is only two but if you really want to talk about this...my four is five");
		convert("myone is only two but if you really want to talk");
		//convert("my one is");
	}
	
	
}
