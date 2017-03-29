

// Z, Anna (Z) Nguyen
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
 * 		Check if word is in dictionary.
 * 		If word is in dictionary, then inflate to next number.
 * 
 * */


/*
 *  Sources used: 
 *  http://www.homophone.com/search?type=include&q=two
 *  	Used website to find all homophones of numbers
 *  
 *  https://lingojam.com/InflationaryEnglish
 *  	Used website for examples and check output
 */


public class ConvertEngToInflationaryEng {
	
	public static String convert( String myString )
	{
		// assume that capitalization is not important
		// makes comparison much easier later on
		myString = myString.toLowerCase();
		
		
		// dictionary of all numbers and homophones
		//   also checked all other possible numbers:
		//		eleven-nineteen, all multiples of ten (20, 30, etc),
		//		hundred, thousand
		String[] myDictionary = 
				new String[]{"zero", "xero",
							 "one", "won", 
							 "two", "to", "too",
							 "three", 
							 "four", "for", "fore",
							 "five",
							 "six", "sics",
							 "seven", 
							 "eight", "ait", "ate",
							 "nine", 
							 "ten", "tin"};
		
		//length of array needs to be precise
		//		(remember this is not an ArrayList)
		//size of array needs to be (all numbers with homophones) + 1
		String[] myNumber = new String[12];
		
		myNumber[0] = "zero";
		myNumber[1] = "one";
		myNumber[2] = "two";
		myNumber[3] = "three";
		myNumber[4] = "four";
		myNumber[5] = "five";
		myNumber[6] = "six";
		myNumber[7] = "seven";
		myNumber[8] = "eight";
		myNumber[9] = "nine";
		myNumber[10] = "ten";
		myNumber[11] = "eleven";
		
		
		//this for loop will return true every iteration if 
		//	we start from the first number (ex: 1 -> 2 -> 3 )
		//  therefore, we have to start from the last number and decrement
		
		for( int i = myDictionary.length - 1; i >= 0; i-- )
		{
			//if a number or homophone exists
			if( myString.contains(myDictionary[i]) )
			{
				//find what number the word corresponds to
				int intToUse = mapToInteger(myDictionary[i]);
				
				//replace the current word with the next number-word
				myString = myString.replaceAll(myDictionary[i], 
											   myNumber[intToUse+1]);
			}
		}
		
		//keeping this println for testing purposes
		//System.out.println(myString);
		return myString; 
	}
	
	//this method maps the word/homophone to the corresponding number
	public static int mapToInteger( String myString )
	{
		int myInt = -1;
		
		if( myString.contains("zero") || myString.contains("xero") )
		{
			myInt = 0;
		}
		if( myString.contains("one") || myString.contains("won") )
		{
			myInt = 1;
		}
		if( myString.contains("two") || myString.contains("to") || myString.contains("too") )
		{
			myInt = 2;
		}
		if( myString.contains("three") )
		{
			myInt = 3;
		}
		if( myString.contains("four") || myString.contains("for") || myString.contains("fore") )
		{
			myInt = 4;
		}
		if( myString.contains("five") )
		{
			myInt = 5;
		}
		if( myString.contains("six") || myString.contains("sics") )
		{
			myInt = 6;
		}
		if( myString.contains("seven") )
		{
			myInt = 7;
		}
		if( myString.contains("eight") || myString.contains("ait") || myString.contains("ate") )
		{
			myInt = 8;
		}
		if( myString.contains("nine") )
		{
			myInt = 9;
		}
		if( myString.contains("ten") || myString.contains("tin") )
		{
			myInt = 10;
		}
		
		return myInt;	
	}
	
	public static void main( String[] args )
	{
		String[] examples = new String[] {
			"I went to the olympics and won a gold medal",
			"Today I won an award for being awesome",
			"The man wore a feather in his felt hat. Dispense with a vest on a day like this.",
			"She saw a cat in the neighbor's house. Look in the corner to find the tan shirt."
		};
		
		for( int i = 0; i < examples.length; i++ )
		{
			System.out.println("Input: " + examples[i] );
			System.out.println("Output: " + convert(examples[i]) );
			System.out.println();	
		}
	}
	
	
}
