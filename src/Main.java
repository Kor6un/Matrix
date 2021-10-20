import services.Reader;

public class Main {

    public static void main(String[] args) {

        Reader reader = new Reader();

        int[][] a = reader.readMatrix("src\\resources\\matrixa.txt");
        int[][] b = reader.readMatrix("src\\resources\\matrixb.txt");

        System.out.println("Matrix a:");
        display(a);

        System.out.println("Matrix b:");
        display(b);

        BasicMatrixMath basicMatrixMath = new BasicMatrixMath();

        System.out.println("Add two matrix:");
        display(basicMatrixMath.add(a, b));

        System.out.println("Subtract two matrix:");
        display(basicMatrixMath.substract(a, b));
    }

    public static void display(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println();
        }
    }
}
