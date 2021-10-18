/*https://russianblogs.com/article/945599118/*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BasicMatrixMath {
    public static void main(String[] args) {
        writeFile("result.txt");
        System.out.println(readFile("src\\matrixa.txt"));

        System.out.println();
        readFile("src\\matrixb.txt");

        int[][] a = new int[][] {{1, 2}, {3, 4}};
        int[][] b = new int[][] {{7, 8}, {6, 15}};
        BasicMatrixMath bmm = new BasicMatrixMath();

        System.out.println("addition two matrix");
        int[][] result = bmm.add(a, b);
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                System.out.print("\t" + result[i][j]);
            }
            System.out.println();
        }

        System.out.println("substract two matrix");
        result = bmm.substract(a, b);
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                System.out.print("\t" + result[i][j]);
            }
            System.out.println();
        }
    }

    public static List<String> readFile(String path) {
        List<String> strings = new ArrayList<>();

        try {
            File file = new File(path);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                strings.add(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static void writeFile (String path) {

        try(FileWriter writer = new FileWriter("src\\result.txt", false))
        {
            // запись всей строки
            String text = "Hello Gold!";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

      /*  try {
            Files.write(Paths.get("src/Resources/output.txt"), data.getBytes());
            System.out.println("File is writing!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File is NOT writing!!!!\n" + e);
        }*/
    }

    public final static int OPERATION_ADD = 1;
    public final static int OPERATION_SUB = 2;

    public int[][] add(int[][] matrixa, int[][] matrixb) {

        int[][] result = new int[matrixa.length][matrixa[0].length];

        if (legalOperation(matrixa, matrixb, OPERATION_ADD)) {
            for(int i = 0; i<matrixa.length; i++) {
                for(int j = 0; j < matrixa[0].length; j++) {
                    result[i][j] = matrixa[i][j] + matrixb[i][j];
                }
            }
        }
        return result;
    }

    public int[][] substract(int[][] matrixa, int[][] matrixb) {
        int[][] result = new int[matrixa.length][matrixa[0].length];
        if(legalOperation(matrixa, matrixb, OPERATION_ADD)) {
            for(int i=0; i<matrixa.length; i++) {
                for(int j=0; j<matrixa[0].length; j++) {
                    result[i][j] = matrixa[i][j] - matrixb[i][j];
                }
            }
        }
        return result;
    }

    private boolean legalOperation(int[][] a, int[][] b, int type) {
        boolean legal = true;
        if(type == OPERATION_ADD || type == OPERATION_SUB)
        {
            if(a.length != b.length || a[0].length != b[0].length) {
                legal = false;
            }
        }
        return legal;
    }
}
