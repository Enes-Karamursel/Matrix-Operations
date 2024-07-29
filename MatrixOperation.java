import java.util.Scanner;

public class MatrixOperation {

    public static void main(String[] args) {
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.printf(
                "Group Members:%nDogasel Günel%nKasim Enes Karamürsel%nAhmed Fatih Akpolat%nGülce Ergen%nAyberk Dinçkol%n--------------%n");
        int selection;

        do {
            System.out.println(" ********************************************");
            System.out.println("|             Choose operation               |");
            System.out.println("|1. Addition                                 |");
            System.out.println("|2. Subtraction                              |");
            System.out.println("|3. Multiplication                           |");
            System.out.println("|4. Division                                 |");
            System.out.println("|5. Scalar multiplication of the matrix      |");
            System.out.println("|6. Transpose of a matrix                    |");
            System.out.println("|7. The inverse of a matrix                  |");
            System.out.println("|8. Trace of a matrix                        |");
            System.out.println("|9. Adjoint of a matrix                      |");
            System.out.println("|10. Check the matrix for orthogonality      |");
            System.out.println("|0. Exit                                     |");
            System.out.println(" ********************************************");
            System.out.print("Choose: ");

            selection = input.nextInt();
            switch (selection) {
                case 1:
                    clearScreen();
                    MatrixAddition();
                    break;
                case 2:
                    clearScreen();
                    MatrixSubtraction();
                    break;
                case 3:
                    clearScreen();
                    MatrixMultiplication();
                    break;
                case 4:
                    clearScreen();
                    MatrixDivision();
                    break;
                case 5:
                    clearScreen();
                    MatrixScalar();
                    break;
                case 6:
                    clearScreen();
                    MatrixTranspose();
                    break;
                case 7:
                    clearScreen();
                    InverseMatrix();
                    break;
                case 8:
                    clearScreen();
                    TraceMatrix();
                    break;
                case 9:
                    clearScreen();
                    AdjointMatrix();
                    break;
                case 10:
                    clearScreen();
                    OrthogonalityMatrix();
                    break;
                default:
                    System.out.println("Invalid selection. Please choose a valid option.");
                    break;
            }
        } while (selection != 0);
        clearScreen();

        input.close();

    }

    public static void MatrixAddition() {
        Scanner input = new Scanner(System.in);

        int rowcount;
        int colcount;

        rowcount = inputTaker("row", "first ");

        colcount = inputTaker("column", "first ");

        double[][] matrix = new double[rowcount][colcount];

        matrix = matrixPopulator(matrix, rowcount, colcount);

        int rowcount2;
        rowcount2 = inputTaker2("row", rowcount);

        int colcount2;
        colcount2 = inputTaker2("column", colcount);

        double[][] matrix2 = new double[rowcount2][colcount2];

        matrix2 = matrixPopulator(matrix2, rowcount2, colcount2);

        double[][] matrixTotal = new double[rowcount][colcount];

        for (int i = 0; i < rowcount; i++) {
            for (int j = 0; j < colcount; j++) {
                matrixTotal[i][j] = matrix[i][j] + matrix2[i][j];
            }
        }

        display(matrixTotal, rowcount, colcount);

    }

    public static void MatrixSubtraction() {
        Scanner input = new Scanner(System.in);

        int rowcount;
        int colcount;

        rowcount = inputTaker("row", "first ");

        colcount = inputTaker("column", "first ");

        double[][] matrix = new double[rowcount][colcount];

        matrix = matrixPopulator(matrix, rowcount, colcount);

        int rowcount2;
        rowcount2 = inputTaker2("row", rowcount);

        int colcount2;
        colcount2 = inputTaker2("column", colcount);

        double[][] matrix2 = new double[rowcount2][colcount2];

        matrix2 = matrixPopulator(matrix2, rowcount2, colcount2);

        double[][] matrixTotal = new double[rowcount][colcount];

        for (int i = 0; i < rowcount; i++) {
            for (int j = 0; j < colcount; j++) {
                matrixTotal[i][j] = matrix[i][j] - matrix2[i][j];
            }
        }

        display(matrixTotal, rowcount, colcount);

    }

    public static void MatrixMultiplication() {
        Scanner input = new Scanner(System.in);

        int rowcount;
        int colcount;

        rowcount = inputTaker("row", "first ");

        colcount = inputTaker("column", "first ");

        double[][] matrix = new double[rowcount][colcount];

        matrix = matrixPopulator(matrix, rowcount, colcount);

        int rowcount2;
        rowcount2 = inputTaker2("row", colcount);

        int colcount2;
        colcount2 = inputTaker("column", "second ");

        double[][] matrix2 = new double[rowcount2][colcount2];

        matrix2 = matrixPopulator(matrix2, rowcount2, colcount2);

        double[][] productMatrix = new double[rowcount][colcount];

        for (int i = 0; i < rowcount; i++) {
            for (int j = 0; j < colcount2; j++) {
                for (int k = 0; k < rowcount2; k++) {
                    productMatrix[i][j] += matrix[i][k] * matrix2[k][j];
                }
            }
        }

        display(productMatrix, rowcount, colcount2);

    }

    public static void MatrixDivision() {
        Scanner input = new Scanner(System.in);

        int rowcount;
        int colcount;

        rowcount = inputTaker("row", "");

        colcount = inputTaker("column", "");

        double[][] matrix = new double[rowcount][colcount];

        matrix = matrixPopulator(matrix, rowcount, colcount);

        double divisor = 0;

        while (divisor == 0) {
            System.out.print("Enter divisor (cannot be 0): ");
            divisor = input.nextDouble();
            if (divisor == 0) {
                System.out.println("Divisor cannot be 0");
            }
        }

        for (int i = 0; i < rowcount; i++) {
            for (int j = 0; j < colcount; j++) {
                matrix[i][j] = matrix[i][j] / divisor;
            }
        }

        display(matrix, rowcount, colcount);

    }

    public static void MatrixScalar() {
        Scanner input = new Scanner(System.in);

        int rowcount;
        int colcount;

        rowcount = inputTaker("row", "");

        colcount = inputTaker("column", "");

        double[][] matrix = new double[rowcount][colcount];

        matrix = matrixPopulator(matrix, rowcount, colcount);

        System.out.print("Enter scalar: ");
        double scalar = input.nextDouble();
        for (int i = 0; i < rowcount; i++) {
            for (int j = 0; j < colcount; j++) {
                matrix[i][j] *= scalar;
            }
        }

        display(matrix, rowcount, colcount);

    }

    public static void MatrixTranspose() {
        Scanner input = new Scanner(System.in);

        int rowcount;
        int colcount;

        rowcount = inputTaker("row", "");

        colcount = inputTaker("column", "");

        double[][] matrix = new double[rowcount][colcount];

        matrix = matrixPopulator(matrix, rowcount, colcount);

        matrix = transposer(matrix, rowcount, colcount);

        display(matrix, colcount, rowcount);

    }

    public static double[][] transposer(double matrix[][], int rowcount, int colcount) {
        double[][] matrix2 = new double[colcount][rowcount];
        for (int i = 0; i < rowcount; i++) {
            for (int j = 0; j < colcount; j++) {
                matrix2[j][i] = matrix[i][j];
            }
        }
        return matrix2;
    }

    public static void TraceMatrix() {
        Scanner input = new Scanner(System.in);

        int rowcount;
        int colcount;

        rowcount = inputTaker("row", "");

        colcount = inputTaker("column", "");

        double[][] matrix = new double[rowcount][colcount];

        matrix = matrixPopulator(matrix, rowcount, colcount);

        double trace = 0;
        for (int i = 0; i < rowcount; i++) {
            trace = trace + matrix[i][i];
        }

        System.out.println("\n" + "Trace: " + trace + "\n");

    }

    public static void InverseMatrix() {
        Scanner input = new Scanner(System.in);

        int rowcount;
        int colcount;

        rowcount = inputTaker("row", "");

        colcount = inputTaker("column", "");

        double[][] matrix = new double[rowcount][colcount];

        matrix = matrixPopulator(matrix, rowcount, colcount);

        Boolean singular = false;
        singular = inverse(matrix, rowcount, colcount);

        if (singular == true) {
            System.out.println();
            return;
        }

        display(matrix, rowcount, colcount);

    }

    public static void AdjointMatrix() {
        Scanner input = new Scanner(System.in);

        int rowcount;
        int colcount;

        rowcount = inputTaker("row", "");

        colcount = inputTaker("column", "");

        double[][] matrix = new double[rowcount][colcount];

        matrix = matrixPopulator(matrix, rowcount, colcount);

        double[][] answer = new double[rowcount][colcount];

        adjoint(matrix, answer, rowcount);

        display(answer, rowcount, colcount);

    }

    public static void OrthogonalityMatrix() {
        Scanner input = new Scanner(System.in);

        int rowcount;
        int colcount;

        rowcount = inputTaker("row", "");

        colcount = inputTaker("column", "");

        if (rowcount != colcount) {
            System.out.println("Matrix is not Orthogonal");
            return;
        }

        double[][] matrix = new double[rowcount][colcount];

        matrix = matrixPopulator(matrix, rowcount, colcount);

        double[][] transposedMatrix = transposer(matrix, rowcount, colcount);

        Boolean singular = false;
        singular = inverse(matrix, rowcount, colcount);

        if (singular == true) {
            System.out.print("\nSo, matrix is not Orthogonal\n");
            return;
        }

        if (areSame(matrix, transposedMatrix, colcount))
            System.out.println("Matrix is Orthogonal");
        else
            System.out.println("Matrix is not Orthogonal");

    }

    static void getCofactor(double A[][], double temp[][], int p, int q, int size) {
        int i = 0, j = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                if (row != p && col != q) {
                    temp[i][j++] = A[row][col];

                    if (j == size - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    public static double determinant(double A[][], int size) {
        double D = 0.0;
        if (size == 1)
            return A[0][0];

        double[][] temp = new double[size][size];

        int sign = 1;

        for (int f = 0; f < size; f++) {

            getCofactor(A, temp, 0, f, size);
            D += sign * A[0][f] * determinant(temp, size - 1);

            sign = -sign;
        }

        return D;
    }

    public static void adjoint(double A[][], double[][] adj, int size) {
        if (size == 1) {
            adj[0][0] = 1;
            return;
        }

        int sign = 1;
        double[][] temp = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                getCofactor(A, temp, i, j, size);

                sign = ((i + j) % 2 == 0) ? 1 : -1;

                adj[j][i] = (sign) * (determinant(temp, size - 1));
            }
        }
    }

    public static Boolean inverse(double A[][], int rowcount, int colcount) {

        double det = determinant(A, rowcount);
        if (det == 0) {
            System.out.print("Singular matrix, can't find its inverse!");
            return true;
        }

        else {

            double[][] adj = new double[rowcount][colcount];
            adjoint(A, adj, rowcount);

            for (int i = 0; i < rowcount; i++)
                for (int j = 0; j < rowcount; j++)
                    A[i][j] = adj[i][j] / (double) det;

            return false;
        }
    }

    public static void display(double[][] matrix, int rowcount, int colcount) {

        int maxwidth = 0;
        String matrixelement;
        for (int i = 0; i < rowcount; i++) {
            for (int j = 0; j < colcount; j++) {
                matrixelement = matrix[i][j] + "";
                if (matrixelement.length() > maxwidth)
                    maxwidth = matrixelement.length();
            }
        }

        System.out.println();
        for (int i = 0; i < rowcount; i++) {
            for (int j = 0; j < colcount; j++) {
                if (j == 0)
                    System.out.print("|");

                String text = matrix[i][j] + "";
                int width = maxwidth + 2;

                int leftPadding = (width - text.length()) / 2;
                int rightPadding = width - text.length() - leftPadding;

                String format = "%" + leftPadding + "s%s%" + rightPadding + "s";

                System.out.printf(format, "", matrix[i][j], "");

                if (j == colcount - 1)
                    System.out.print("|");

            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean areSame(double A[][], double B[][], int size) {
        int i, j;
        for (i = 0; i < size; i++)
            for (j = 0; j < size; j++)
                if (A[i][j] != B[i][j])
                    return false;
        return true;
    }

    public static int inputTaker(String titlename, String order) {
        System.out.print("Enter " + titlename + " count for the " + order + "matrix (integer between 2 and 5): ");
        Scanner input = new Scanner(System.in);
        int size;
        while (true) {
            try {
                size = Integer.parseInt(input.nextLine());
                if (size >= 2 && size <= 5) {
                    break;
                } else {
                    System.out.print("Please enter an integer between 2 and 5 for " + titlename + " count: ");
                }
            } catch (NumberFormatException e) {
                System.out
                        .print("Please enter a valid integer for " + titlename + " count (integer between 2 and 5): ");
            }
        }
        return size;
    }

    public static int inputTaker2(String titlename, int dependency) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter " + titlename + " count for second matrix (must be " + dependency + "): ");
            while (true) {
                try {
                    size = Integer.parseInt(input.nextLine());
                    if (size != dependency) {
                        System.out.print(titlename + " count must be " + dependency + ": ");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print(
                            "Please enter a valid integer for " + titlename + " count (must be " + dependency + "): ");
                }
            }
        } while (size != dependency);
        return size;
    }

    public static double[][] matrixPopulator(double matrix[][], int rowcount, int colcount) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < rowcount; i++) {
            for (int j = 0; j < colcount; j++) {
                System.out.print("Enter [" + i + "][" + j + "] of matrix: ");
                while (true) {
                    try {
                        matrix[i][j] = Double.parseDouble(input.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("Please enter a valid number for matrix element: ");
                    }
                }
            }
        }
        return matrix;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
