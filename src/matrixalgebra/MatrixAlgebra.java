
package matrixalgebra;

import java.util.Scanner;

public class MatrixAlgebra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Matrix Algebra Program!");
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> MatrixOperations.performMatrixAddition(scanner);
                case 2 -> MatrixOperations.performMatrixSubtraction(scanner);
                case 3 -> MatrixOperations.performMatrixMultiplication(scanner);
                case 4 -> MatrixOperations.performScalarMultiplication(scanner);
                case 5 -> MatrixOperations.performTransposition(scanner);
                case 6 -> MatrixOperations.performDeterminantCalculation(scanner);
                case 7 -> MatrixOperations.performInverseMatrix(scanner);
                case 8 -> MatrixOperations.solveLinearSystem(scanner);
                case 9 -> MatrixOperations.findEigenValuesAndVectors(scanner);
                case 0 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nPlease choose an operation:");
        System.out.println("1. Matrix Addition");
        System.out.println("2. Matrix Subtraction");
        System.out.println("3. Matrix Multiplication");
        System.out.println("4. Scalar Multiplication");
        System.out.println("5. Transposition");
        System.out.println("6. Determinant Calculation");
        System.out.println("7. Inverse Matrix");
        System.out.println("8. Solve Linear System");
        System.out.println("9. Find Eigenvalues and Eigenvectors");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    
}

class MatrixOperations {

    public static void performMatrixAddition(Scanner scanner) {
        System.out.println("Matrix Addition");
        double[][] matrixA = MatrixUtils.inputMatrix(scanner, "Matrix A");
        double[][] matrixB = MatrixUtils.inputMatrix(scanner, "Matrix B");

        if (MatrixUtils.areDimensionsEqual(matrixA, matrixB)) {
            double[][] result = MatrixUtils.addMatrices(matrixA, matrixB);
            MatrixUtils.printMatrix(result, "Resultant Matrix");
        } else {
            System.out.println("Matrix dimensions do not match for addition.");
        }
    }

    public static void performMatrixSubtraction(Scanner scanner) {
        System.out.println("Matrix Subtraction");
        double[][] matrixA = MatrixUtils.inputMatrix(scanner, "Matrix A");
        double[][] matrixB = MatrixUtils.inputMatrix(scanner, "Matrix B");

        if (MatrixUtils.areDimensionsEqual(matrixA, matrixB)) {
            double[][] result = MatrixUtils.subtractMatrices(matrixA, matrixB);
            MatrixUtils.printMatrix(result, "Resultant Matrix");
        } else {
            System.out.println("Matrix dimensions do not match for subtraction.");
        }
    }

    public static void performMatrixMultiplication(Scanner scanner) {
        System.out.println("Matrix Multiplication");
        double[][] matrixA = MatrixUtils.inputMatrix(scanner, "Matrix A");
        double[][] matrixB = MatrixUtils.inputMatrix(scanner, "Matrix B");

        if (MatrixUtils.canMultiply(matrixA, matrixB)) {
            double[][] result = MatrixUtils.multiplyMatrices(matrixA, matrixB);
            MatrixUtils.printMatrix(result, "Resultant Matrix");
        } else {
            System.out.println("Matrix dimensions do not allow multiplication.");
        }
    }

    public static void performScalarMultiplication(Scanner scanner) {
        System.out.println("Scalar Multiplication");
        double[][] matrix = MatrixUtils.inputMatrix(scanner, "Matrix");
        System.out.print("Enter scalar value: ");
        double scalar = scanner.nextDouble();

        double[][] result = MatrixUtils.scalarMultiply(matrix, scalar);
        MatrixUtils.printMatrix(result, "Resultant Matrix");
    }

    public static void performTransposition(Scanner scanner) {
        System.out.println("Matrix Transposition");
        double[][] matrix = MatrixUtils.inputMatrix(scanner, "Matrix");
        double[][] result = MatrixUtils.transpose(matrix);
        MatrixUtils.printMatrix(result, "Transposed Matrix");
    }

    public static void performDeterminantCalculation(Scanner scanner) {
        System.out.println("Determinant Calculation");
        double[][] matrix = MatrixUtils.inputMatrix(scanner, "Matrix");

        if (MatrixUtils.isSquare(matrix)) {
            double determinant = MatrixUtils.calculateDeterminant(matrix);
            System.out.println("Determinant: " + determinant);
        } else {
            System.out.println("Matrix must be square to calculate determinant.");
        }
    }

    public static void performInverseMatrix(Scanner scanner) {
        System.out.println("Inverse Matrix Calculation");
        double[][] matrix = MatrixUtils.inputMatrix(scanner, "Matrix");

        if (MatrixUtils.isSquare(matrix)) {
            double[][] inverse = MatrixUtils.calculateInverse(matrix);
            if (inverse != null) {
                MatrixUtils.printMatrix(inverse, "Inverse Matrix");
            } else {
                System.out.println("Matrix is singular and cannot be inverted.");
            }
        } else {
            System.out.println("Matrix must be square to calculate inverse.");
        }
    }

    public static void solveLinearSystem(Scanner scanner) {
        System.out.println("Solve Linear System");
        System.out.println("Enter the coefficient matrix:");
        double[][] coefficients = MatrixUtils.inputMatrix(scanner, "Coefficient Matrix");
        System.out.println("Enter the constants vector:");
        double[] constants = MatrixUtils.inputVector(scanner, "Constants Vector");

        if (MatrixUtils.isSquare(coefficients) && coefficients.length == constants.length) {
            double[] solution = MatrixUtils.solveLinearSystem(coefficients, constants);
            if (solution != null) {
                System.out.println("Solution:");
                for (int i = 0; i < solution.length; i++) {
                    System.out.printf("x%d = %.2f\n", i + 1, solution[i]);
                }
            } else {
                System.out.println("System has no unique solution.");
            }
        } else {
            System.out.println("Invalid dimensions for solving linear system.");
        }
    }

    public static void findEigenValuesAndVectors(Scanner scanner) {
        System.out.println("Finding Eigenvalues and Eigenvectors (Not yet implemented)");
        // Placeholder for future implementation.
    }
}

class MatrixUtils {

    public static double[][] inputMatrix(Scanner scanner, String name) {
        System.out.print("Enter the number of rows for " + name + ": ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for " + name + ": ");
        int cols = scanner.nextInt();

        double[][] matrix = new double[rows][cols];
        System.out.println("Enter the elements of " + name + " row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    public static double[] inputVector(Scanner scanner, String name) {
        System.out.print("Enter the size of the vector " + name + ": ");
        int size = scanner.nextInt();
        double[] vector = new double[size];

        System.out.println("Enter the elements of the vector:");
        for (int i = 0; i < size; i++) {
            vector[i] = scanner.nextDouble();
        }
        return vector;
    }

    public static boolean areDimensionsEqual(double[][] a, double[][] b) {
        return a.length == b.length && a[0].length == b[0].length;
    }

    public static boolean canMultiply(double[][] a, double[][] b) {
        return a[0].length == b.length;
    }

    public static boolean isSquare(double[][] matrix) {
        return matrix.length == matrix[0].length;
    }

    public static double[][] addMatrices(double[][] a, double[][] b) {
        int rows = a.length, cols = a[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public static double[][] subtractMatrices(double[][] a, double[][] b) {
        int rows = a.length, cols = a[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    public static double[][] multiplyMatrices(double[][] a, double[][] b) {
        int rows = a.length, cols = b[0].length, commonDim = a[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < commonDim; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    public static double[][] scalarMultiply(double[][] matrix, double scalar) {
        int rows = matrix.length, cols = matrix[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }
        return result;
    }

    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        double[][] result = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static double calculateDeterminant(double[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        double determinant = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(minor(matrix, 0, i));
        }
        return determinant;
    }

    public static double[][] calculateInverse(double[][] matrix) {
        double determinant = calculateDeterminant(matrix);
        if (determinant == 0) {
            return null; // Singular matrix
        }
        int size = matrix.length;
        double[][] adjugate = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjugate[j][i] = Math.pow(-1, i + j) * calculateDeterminant(minor(matrix, i, j));
            }
        }
        return scalarMultiply(adjugate, 1 / determinant);
    }

    public static double[][] minor(double[][] matrix, int row, int col) {
        int size = matrix.length;
        double[][] minor = new double[size - 1][size - 1];
        for (int i = 0, mi = 0; i < size; i++) {
            if (i == row) continue;
            for (int j = 0, mj = 0; j < size; j++) {
                if (j == col) continue;
                minor[mi][mj++] = matrix[i][j];
            }
            mi++;
        }
        return minor;
    }

    public static double[] solveLinearSystem(double[][] coefficients, double[] constants) {
        double[][] augmentedMatrix = new double[coefficients.length][coefficients[0].length + 1];
        for (int i = 0; i < coefficients.length; i++) {
            System.arraycopy(coefficients[i], 0, augmentedMatrix[i], 0, coefficients[i].length);
            augmentedMatrix[i][coefficients[0].length] = constants[i];
        }
        return gaussianElimination(augmentedMatrix);
    }

    private static double[] gaussianElimination(double[][] augmentedMatrix) {
        int n = augmentedMatrix.length;
        for (int i = 0; i < n; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(augmentedMatrix[j][i]) > Math.abs(augmentedMatrix[max][i])) {
                    max = j;
                }
            }
            double[] temp = augmentedMatrix[i];
            augmentedMatrix[i] = augmentedMatrix[max];
            augmentedMatrix[max] = temp;

            if (Math.abs(augmentedMatrix[i][i]) <= 1e-10) {
                return null; // No unique solution
            }

            for (int j = i + 1; j < n; j++) {
                double factor = augmentedMatrix[j][i] / augmentedMatrix[i][i];
                for (int k = i; k <= n; k++) {
                    augmentedMatrix[j][k] -= factor * augmentedMatrix[i][k];
                }
            }
        }

        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += augmentedMatrix[i][j] * solution[j];
            }
            solution[i] = (augmentedMatrix[i][n] - sum) / augmentedMatrix[i][i];
        }
        return solution;
    }

    public static void printMatrix(double[][] matrix, String name) {
        System.out.println(name + ":");
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%.2f ", value);
            }
            System.out.println();
        }
    }
}