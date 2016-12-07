package Rule30Multithreading;

public class Rule30Thread extends Thread {
	public String prev;
	private int min;
	private int max;
	private String cells;

	public Rule30Thread(int min, int max, String prev) {
		if (min > max || min < 0 || max < 0) {
			throw new IllegalArgumentException("Bad arguments!");
		}
		this.prev = prev;
		this.min = min;
		this.max = max;
		this.cells = "";

	}

	public char generate(int input) {
		// Cell generation per thread ...
		char cell = '0';

		if (input == 0) {
			if (prev.charAt(input + 1) == '1' && prev.charAt(input) == '1') {
				cell = '1';
			}
			if (prev.charAt(input) == '1' && prev.charAt(input + 1) != '1') {
				cell = '1';
			}
			if (prev.charAt(input) != '1' && prev.charAt(input + 1) == '1') {
				cell = '1';
			}
		} else if (input == prev.length() - 1) {
			if (prev.charAt(input - 1) == '1' && prev.charAt(input) != '1') {
				cell = '1';
			}
			if (prev.charAt(input - 1) != '1' && prev.charAt(input) == '1') {
				cell = '1';
			}
		} else {
			if (prev.charAt(input - 1) == '1' && prev.charAt(input) != '1' && prev.charAt(input + 1) != '1') {
				cell = '1';
			}
			if (prev.charAt(input - 1) != '1' && prev.charAt(input) == '1' && prev.charAt(input + 1) == '1') {
				cell = '1';
			}
			if (prev.charAt(input - 1) != '1' && prev.charAt(input) == '1' && prev.charAt(input + 1) != '1') {
				cell = '1';
			}
			if (prev.charAt(input - 1) != '1' && prev.charAt(input) != '1' && prev.charAt(input + 1) == '1') {
				cell = '1';
			}
		}

		return cell;
	}

	public String getCells() {
		return cells;
	}

	@Override
	public void run() {
		for (int i = min; i <= max; i++) {
			cells = cells + generate(i);
		}
	}

}
