
public class FunctionPolynomial {
	
	static double polynomial(double x) {
		double y = Math.pow(x, 3) - (4 * Math.pow(x, 2)) - (17 * x) + 66;
		return y;
	}

	public static void main(String[] args) {
		double x = 0;
		double y = 0;
		String xs = "x = ";
		String ys = "y = ";
		while (x < 10) {
			xs += x + " ";
			y = polynomial(x);
			ys += y + " ";
			x += 0.1;
		}
		
		System.out.println(xs);
		System.out.println(ys);

	}

}
