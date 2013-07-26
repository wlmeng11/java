/* Useful matrix manipulations */
/* TODO use generics */

public class Matrix {
	private int mat[][];
	private int rows;
	private int cols;

	/* Default constructor: 3x3 square */
	Matrix() {
		initialize(3, 3);
	}
	/* Square matrix */
	Matrix(int side) {
		initialize(side, side);
	}
	/* Non-square matrix */
	Matrix(int rows, int cols) {
		initialize(rows, cols);
	}
	/* Zero-initializes a matrix with given dimensions */
	private void initialize(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		mat = new int[rows][cols];
	}

	public int getRows() { return rows; }
	public int getCols() { return cols; }
	public int getMatElem(int i, int j) {
		if (i < rows && j < cols)
			return mat[i][j];
		else // out of range, TODO exception handling
			return 0;
	}

	/* Fills the matrix with zeros by reinitializing the array */
	public void populateZeros() {
		mat = new int[rows][cols];
	}

	/* Fills the matrix with ones */
	public void populateOnes() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				mat[i][j] = 1;
		}
	}

	/* Fills the matrix with a constant value */
	public void populateConst(int num) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				mat[i][j] = num;
		}
	}

	/* Fills the matrix with ascending values */
	public void populateAscending() {
		int num = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				mat[i][j] = num++;
		}
	}

	/* Fills the matrix with descending values */
	public void populateDescending() {
		int num = 1;
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = rows - 1; j >= 0; j--)
				mat[i][j] = num++;
		}
	}

	/* Prints the matrix with appropriate spacing */
	public void print() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	/* Non-conjugate transposal */
	public void transpose() {
		if (rows == cols) {
			/* Bitwise XOR swap; assumes square matrix */
			for (int i = 0; i < rows; i++) {
				for (int j = i + 1; j < cols; j++) { // only reads elements above main diagonal
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

	/* Multiply each element of the matrix by a constant value */
	public void scalarMult(int scaleFactor) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				mat[i][j] *= scaleFactor;
		}
	}

	/* Add a constant value to each element of the matrix */
	public void constAdd(int addend) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				mat[i][j] += addend;
		}
	}

	/* Add another matrix to the current matrix */
	public void matrAdd(Matrix addend) {
		if (rows == addend.getRows() && cols == addend.getCols()) {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++)
					mat[i][j] += addend.getMatElem(i, j);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Matrix M:");
		Matrix m = new Matrix(4); //m.print();
		m.populateAscending(); m.print();

		System.out.println("Row 3, Col 4: " + m.getMatElem(2, 3));
		System.out.println("Row 5, Col 4: " + m.getMatElem(4, 3));
		//m.transpose(); m.print();
		//m.scalarMult(5); m.print();
		//m.constAdd(1); m.print();
		//m.constAdd(-2); m.print();
		System.out.println("Matrix N:");
		Matrix n = new Matrix(4);
		n.populateDescending(); n.print();

		System.out.println("M + N:");
		m.matrAdd(n); m.print();

		m.populateZeros(); m.print();
		m.populateOnes(); m.print();
		m.populateConst(-4); m.print();
	}
}
