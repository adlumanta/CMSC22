package Rule30Multithreading;

import java.util.Scanner;

public class Rule30MultiThreadTester {
	static int cellsPerServer;
	public static int MAXTHREAD = 10;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		int min;
		int max;

		String prev = "";
		String next = "";

		Scanner s = new Scanner(System.in);
		int input = s.nextInt();

		for (int i = 0; i < input; i++) {
			if (i == input / 2) {
				prev += '1';
			} else {
				prev += '0';
			}
		}
		System.out.println(prev);

		if (input < MAXTHREAD) {
			MAXTHREAD = input;
		}

		Rule30Thread[] servers = new Rule30Thread[MAXTHREAD];
		cellsPerServer = input / MAXTHREAD;
		min = 0;
		max = cellsPerServer - 1;

		for (int i = 0; i < input - 1; i++) {
			for (int j = 0; j < MAXTHREAD; j++) {
				if (j == MAXTHREAD - 1) {
					max = input - 1;
				}
				servers[j] = new Rule30Thread(min, max, prev);
				min = max + 1;
				max = min + cellsPerServer - 1;
			}

			for (int j = 0; j < MAXTHREAD; j++) {
				servers[j].run();
			}

			for (int j = 0; j < MAXTHREAD; j++) {
				while (servers[j].isAlive()) {
					try {
						servers[j].join();
					} catch (InterruptedException e) {
						System.err.println("Thread interrupted: " + e.getMessage());
					}
				}
			}

			for (int j = 0; j < MAXTHREAD; j++) {
				next += servers[j].getCells();
			}

			System.out.println(next);

			prev = next;
			next = "";

			min = 0;
			max = cellsPerServer - 1;

		}
		System.out.println("Runtime: " + (System.currentTimeMillis() - startTime) + "ms");
	}

}
