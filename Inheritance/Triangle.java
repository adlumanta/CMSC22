
public class Triangle extends Shape {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	public Triangle() {
		
	}
	
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public Triangle(double side1, double side2, double side3, String color, boolean filled) {
		super(color, filled);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public boolean isTriangle() {
		if ((side1 + side2 > side3) && ((side2 + side3) > side1) && ((side3 + side1) > side2)) {
			return true;
		}
		return false;
	}
	
	public double getSide1() {
		if(isTriangle() == true) {
		 return side1;
		}
		return 0;
	}
	
	public double getSide2() {
		if(isTriangle() == true) {
		 return side2;
		}
		return 0;
	}
	
	public double getSide3() {
		if(isTriangle() == true) {
		 return side3;
		}
		return 0;
	}
	
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	
	public void setSide3(double side3) {
		this.side3 = side3;
	}
	
	@Override
	public String getColor() {
		if (isTriangle() == true) {
			return color;
		}
		return "N/A";
	}
	
	@Override
	public void setColor(String color) {
		if (isTriangle() == true) {
			this.color = color;
		}
		this.color = "N/A";
	}
	
	@Override
	public boolean isFilled() {
		if (isTriangle() == true) {
			return super.isFilled();
		}
		return false;
	}
	
	@Override
	public void setFilled(boolean filled) {
		if (isTriangle() == true) {
			this.filled = filled;
		}
		this.filled = false;
	}
	
	@Override
	public double getArea() {
		if(isTriangle() == true) {
			// Heron's formula
			double p = (side1 + side2 + side3)/2;
			return Math.sqrt(p * ((p - side1) * (p - side2) * (p - side3)));
		}
		return 0;
	}

	@Override
	public double getPerimeter() {
		if(isTriangle() == true) {
			return side1 + side2 + side3;
		}
		return 0;
	}

	@Override
	public String toString() {
		if(isTriangle() == true) {
			return "A triangle with sides "+ side1 + ", " + side2 + " and " + side3 + ", which is a subclass of " + super.toString();
		}
		return "IMPOSSIBLE TRIANGLE! The dimensions given is not possible to form a triangle.";
	}
}
