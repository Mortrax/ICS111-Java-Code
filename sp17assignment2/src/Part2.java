
public class Part2 {

	public static void main(String[] args) {
		// 
		int foo;			// foo = 0  , bar = NA , fuz = NA
		
		//
		int bar = 0;		// foo = 0 , bar = 0 , fuz = NA
		
		//
		float fuz = 4.6f;	// foo = 0 , bar = 0 , fuz = 4.6

		//
		foo = bar + 3;		// foo = 3  , bar = 0 , fuz = 4.6
	
		//
		bar = foo / 2;		// foo = 3 , bar = 1 , fuz = 4.6
		
		//
		fuz -= 2;			// foo = 3 , bar = 1 , fuz = 2.6
		
		//
		bar += ++foo;		// foo = 4 , bar = 5 , fuz = 2.6
		
		//
		bar = bar - (int)fuz;	// foo = 4 , bar = 3 , fuz = 2.6
		
		System.out.println(foo);
		System.out.println(bar);
		System.out.println(fuz);
	}

}
