public class TestResizableCircle {
	public static void main (String[] args) {
		GeometricObject o1 = new ResizableCircle(4.0);
		System.out.println(o1);
		System.out.println("AREA: " + o1.getArea());
		System.out.println("PERIMETER: " + o1.getPerimeter());
		//((ResizableCircle) o1).resize(-101);
		//((ResizableCircle) o1).resize(-100);
		//((ResizableCircle) o1).resize(102);
		((ResizableCircle) o1).resize(50);
		System.out.println(o1);
		System.out.println("AREA: " + o1.getArea());
		System.out.println("PERIMETER: " + o1.getPerimeter());
	}
}