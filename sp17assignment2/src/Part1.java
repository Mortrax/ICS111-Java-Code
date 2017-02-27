

public class Part1 {

	public static void main(String[] args) {
		// Declare a variable of type float called cost
		float cost;
		
		// Assign 1.75 to cost
		cost = 1.75f;
		// Declare an integer called pack
		int pack;
		
		// Assign 6 to pack
		pack = 6;
		
		// Declare an integer called qty and initialize it to 3
		int qty = 3;
		
		// Create a variable called product initialized to "Biscuits"
		String product = "Biscuits";
		
		// Declare a float variable with a legal name that is one of the following:
		// a) res-ult  b)  *Result  c) _result1  d) 1result
		float _result1;
		// Assign into the result variable the value of cost*pack*qty
		_result1 = cost * pack * qty;
		// Print the string in product, a space, and then the result
		System.out.println(product + " " + _result1);
	}

}
