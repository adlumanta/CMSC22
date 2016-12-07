package Rule30;
import java.util.Scanner;

public class Rule30 {

	public static int[][] generateMatrix(int[][] array, int dimension) {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (i == 0) {
					if (j == dimension / 2) {
						array[i][j] = 1;
					} else {
						array[i][j] = 0;
					}
				} else {
					if (j == 0) {
						if (array[i - 1][0] == 0 && array[i - 1][1] == 0) {
							array[i][j] = 0;
						} else {
							array[i][j] = 1;
						}
					} else if (j == dimension - 1) {
						if (array[i - 1][j - 1] == 0 && array[i - 1][j] == 0) {
							array[i][j] = 0;
						} else if (array[i - 1][j - 1] == 1 && array[i - 1][j] == 1) {
							array[i][j] = 0;
						} else {
							array[i][j] = 1;
						}
					} else {
						int left = array[i - 1][j - 1];
						int middle = array[i - 1][j];
						int right = array[i - 1][j + 1];
						if (left == 1 && middle == 0 && right == 0)
							array[i][j] = 1;
						else if (left == 0 && middle == 0 && right == 1)
							array[i][j] = 1;
						else if (left == 0 && middle == 1 && right == 0)
							array[i][j] = 1;
						else if (left == 0 && middle == 1 && right == 1)
							array[i][j] = 1;
						else
							array[i][j] = 0;
					}
				}
			}
		}
		return array;
	}

	public static void printMatrix(int[][] array, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int dimension = 0;
		do {
			dimension = read.nextInt(); 
		} while (dimension < 1 && dimension > 30);
		int[][] generationArray = new int[dimension][dimension];
		generationArray = generateMatrix(generationArray, dimension);
		printMatrix(generationArray, dimension);
	}
}