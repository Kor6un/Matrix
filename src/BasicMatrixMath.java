/*https://russianblogs.com/article/945599118/*/

import java.io.*;

public class BasicMatrixMath {
    public static void main(String[] args) {

        BasicMatrixMath bmm = new BasicMatrixMath();

        int[][] a = bmm.readFile("src\\matrixa.txt");
        int[][] b = bmm.readFile("src\\matrixb.txt");

     /*   System.out.println("Original matrix a:");

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print("\t" + a[i][j]);
            }
            System.out.println();
        }

        System.out.println("Original matrix b:");

        for(int i = 0; i < b.length; i++) {
            for(int j = 0; j < b[0].length; j++) {
                System.out.print("\t" + b[i][j]);
            }
            System.out.println();
        }*/

        boolean flag = false;
        int[][] result;

        if (flag) {
            System.out.println("addition two matrix");

            result = bmm.add(a, b);

            for(int i = 0; i < result.length; i++) {
                for(int j = 0; j < result[0].length; j++) {
                    System.out.print("\t" + result[i][j]);
                }
                System.out.println();
            }

            bmm.writeFile("src\\result.txt", result);
        } else {
            System.out.println("substract two matrix");

            result = bmm.substract(a, b);

            for(int i = 0; i < result.length; i++) {
                for(int j = 0; j < result[0].length; j++) {
                    System.out.print("\t" + result[i][j]);
                }
                System.out.println();
            }
            bmm.writeFile("src\\result.txt", result);
        }
    }

    public int[][] readFile(String path) {

        int[][] result = null;

        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            int i = 0;

            String[]  strings = line.split(" ");

            result = new int[strings.length][strings.length];

            while (line != null) {
                strings = line.split(" ");
                for (int j = 0; j < strings.length; j++) {
                    result[i][j] = Integer.parseInt(strings[j]);
                }
                i++;
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void writeFile (String path, int[][] matrix) {

        try(FileWriter writer = new FileWriter(path, false))
        {
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    writer.append("\t" + matrix[i][j]);
                }
                writer.append("\n");
            }
            writer.flush();
            System.out.println("File is writing");
        }
        catch(IOException ex){
            System.out.println("Error! File is NOT writing!" + ex.getMessage());
        }
    }

    public int[][] add(int[][] a, int[][] b) {

        int[][] result = new int[a.length][a[0].length];

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public int[][] substract(int[][] a, int[][] b) {

        int[][] result = new int[a.length][a[0].length];

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }
}
