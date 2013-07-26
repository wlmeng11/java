/* Useful matrix manipulations */
public class Matrix {
	private int mat[][];
	private int rows;
	private int cols;

	/* Default constructor: 3x3 square */
	Matrix() {
		rows = 3;
		cols = 3;
	}
	/* Square matrix */
	Matrix(int side) {
		rows = side;
		cols = side;
	}
	/* Non-square matrix */
	Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}

	public int getRows() { return rows; }
	public int getCols() { return cols; }

	public void populate(int rows, int cols) {
		mat = new int[rows][cols];
		int num = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mat[i][j] = num++;
			}
		}
	}

	public void print() {
		System.out.println();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/* Non-conjugate transpose */
	public void transpose() {
		if (rows == cols) {
			/* Bitwise XOR swap, assumes square matrix */
			for (int i = 0; i < rows; i++) {
				for (int j = i + 1; j < cols; j++) {
					int swap = mat[i][j] ^ mat[j][i];
					mat[i][j] ^= swap;
					mat[j][i] ^= swap;
				}
			}
		}
		else {
			System.out.println("Oops, can't transpose a non-square matrix yet!");
			// Do a direct copy of rows of original to cols of transposed matrix
		}
	}

	public void scalarMult(int scaleFactor) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				mat[i][j] *= scaleFactor;
		}
	}

	public static void main(String[] args) {
		Matrix m = new Matrix(4);
		m.populate(m.getRows(), m.getCols());
		m.print();
		m.transpose();
		m.print();
		m.scalarMult(5);
		m.print();
	}
}
