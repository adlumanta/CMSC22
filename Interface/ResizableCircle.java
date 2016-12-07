public class ResizableCircle extends Circle implements Resizable {

	public ResizableCircle(double radius) {
		super(radius);
	}

	@Override
	public void resize(int percent) {
		double decimal = (double)percent / 100.0;
		if (decimal < -1.0) {
			throw new IllegalArgumentException("ERROR!!!");
		}
		super.radius = super.radius + (super.radius * decimal);
	}

}