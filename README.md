		 ========================
		 |Matrix Algebra Program|
		 ========================

		**************************
		*Project: Linear Algebra *
		*Group member:		       *
		*Awder Mohammed		       *
		*Akar Omer	          	 *
		*Akar Walid	          	 *
		*Mohammed Jihan	      	 *
		**************************


This program allows users to perform various matrix algebra operations using a command-line interface. It is implemented in Java with an object-oriented design.

            ---Features---

Matrix Addition
Matrix Subtraction
Matrix Multiplication
Scalar Multiplication
Matrix Transposition
Determinant Calculation
Inverse Matrix Calculation
Solving Linear Systems
Placeholder for Eigenvalues and Eigenvectors (Future Work)


        ---How to Use---

Choose an Operation:

After starting the program, you will be prompted to select an operation from the menu.
Enter the corresponding number for the desired operation and follow the on-screen instructions.
Input Matrices and Values:

For matrix-related operations, you will be asked to enter the dimensions and elements of the matrices.
For scalar multiplication or solving systems, provide the required scalar or constants.
View Results:

The program will display the computed results (e.g., resultant matrix, determinant, or solution vector) directly on the screen.
Exit the Program:

Enter 0 to exit the program.
Notes
Ensure input matrices have compatible dimensions for the chosen operation.
Square matrices are required for determinant, inverse, and eigenvalue calculations.
The eigenvalue/eigenvector feature is a placeholder and not yet implemented.


           ---Example Input and Output---

Example 1: Matrix Addition
Input:


Enter the number of rows for Matrix A: 2
Enter the number of columns for Matrix A: 2
Enter the elements of Matrix A row by row:
1 2
3 4
Enter the number of rows for Matrix B: 2
Enter the number of columns for Matrix B: 2
Enter the elements of Matrix B row by row:
5 6
7 8
Output:


Resultant Matrix:
6.00 8.00 
10.00 12.00
Example 2: Determinant Calculation
Input:


Enter the number of rows for Matrix: 3
Enter the number of columns for Matrix: 3
Enter the elements of the Matrix row by row:
1 2 3
0 4 5
1 0 6
Output:


Determinant: 22.00
Example 3: Solve Linear System
Input:


Enter the number of rows for Coefficient Matrix: 2
Enter the number of columns for Coefficient Matrix: 2
Enter the elements of Coefficient Matrix row by row:
2 3
1 -1
Enter the size of the vector Constants Vector: 2
Enter the elements of the Constants Vector:
8
3
Output:


Solution:
x1 = 3.00
x2 = 2.00
Example 4: Matrix Multiplication
Input:


Enter the number of rows for Matrix A: 2
Enter the number of columns for Matrix A: 3
Enter the elements of Matrix A row by row:
1 2 3
4 5 6
Enter the number of rows for Matrix B: 3
Enter the number of columns for Matrix B: 2
Enter the elements of Matrix B row by row:
7 8
9 10
11 12
Output:

Resultant Matrix:
58.00 64.00
139.00 154.00
