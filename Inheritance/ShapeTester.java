
public class ShapeTester {
	public static void main(String[] args) {
		Shape s1 = new Circle(5.5, "RED", false);  // Upcast Circle to Shape
		System.out.println(s1);                    // which version?
		System.out.println(s1.getArea());          // which version?
		System.out.println(s1.getPerimeter());     // which version?
		System.out.println(s1.getColor());
		System.out.println(s1.isFilled());
		//System.out.println(s1.getRadius());		   		// Error 1
		System.out.println(((Circle) s1).getRadius()); 		// Error 1 Solution: Downcast
		System.out.println("***********************************************");
		
		Circle c1 = (Circle)s1;                   // Downcast back to Circle
		System.out.println(c1);
		System.out.println(c1.getArea());
		System.out.println(c1.getPerimeter());
		System.out.println(c1.getColor());
		System.out.println(c1.isFilled());
		System.out.println(c1.getRadius());
		System.out.println("***********************************************");
		
		//Shape s2 = new Shape(); 				// Cannot be instantiated. Why?

		Shape s3 = new Rectangle(1.0, 2.0, "RED", false);   // Upcast
		System.out.println(s3);
		System.out.println(s3.getArea());
		System.out.println(s3.getPerimeter());
		System.out.println(s3.getColor());
		//System.out.println(s3.getLength());				// Error 2
		System.out.println(((Rectangle) s3).getLength());	// Error 2 Solution: Downcast
		System.out.println("***********************************************");

		Rectangle r1 = (Rectangle)s3;   // downcast
		System.out.println(r1);
		System.out.println(r1.getArea());
		System.out.println(r1.getColor());
		System.out.println(r1.getLength());
		System.out.println("***********************************************");

		Shape s4 = new Square(6.6);     // Upcast
		System.out.println(s4);
		System.out.println(s4.getArea());
		System.out.println(s4.getColor());
		//System.out.println(s4.getSide());							// Error 3
		System.out.println(((Square) s4).getSide());				// Error 3 Solution: Downcast
		System.out.println("***********************************************");
		
		// Take note that we downcast Shape s4 to Rectangle, 
		//  which is a superclass of Square, instead of Square
		Rectangle r2 = (Rectangle)s4;
		System.out.println(r2);
		System.out.println(r2.getArea());
		System.out.println(r2.getColor());
		//System.out.println(r2.getSide());							// Error 4
		System.out.println(((Square) r2).getSide());				// Error 4 Solution: Downcast
		System.out.println(r2.getLength());
		System.out.println("***********************************************");
		
		// Downcast Rectangle r2 to Square
		Square sq1 = (Square)r2;
		System.out.println(sq1);
		System.out.println(sq1.getArea());
		System.out.println(sq1.getColor());
		System.out.println(sq1.getSide());
		System.out.println(sq1.getLength());
		System.out.println("***********************************************");
		
		// Triangle (Bonus)
		Shape t1 = new Triangle(7.0, 4.0, 9.0, "blue", true);
		System.out.println(t1);
		System.out.println(t1.getArea());
		System.out.println(t1.getPerimeter());
		System.out.println(t1.getColor());
		System.out.println(t1.isFilled());
		System.out.println(((Triangle) t1).getSide1());
		System.out.println(((Triangle) t1).getSide2());
		System.out.println(((Triangle) t1).getSide3());
		System.out.println("***********************************************");
		
		Triangle tr1 = (Triangle)t1;
		System.out.println(tr1);
		System.out.println(tr1.getArea());
		System.out.println(tr1.getPerimeter());
		System.out.println(tr1.getColor());
		System.out.println(tr1.getSide1());
		System.out.println(tr1.getSide2());
		System.out.println(tr1.getSide3());
		System.out.println("***********************************************");
		
		Shape t2 = new Triangle(3.0, 4.0, 9.0, "blue", false);
		System.out.println(t2);
		System.out.println(t2.getArea());
		System.out.println(t2.getPerimeter());
		System.out.println(t2.getColor());
		System.out.println(t2.isFilled());
		System.out.println(((Triangle) t2).getSide1());
		System.out.println(((Triangle) t2).getSide2());
		System.out.println(((Triangle) t2).getSide3());
		
		
	}
}
