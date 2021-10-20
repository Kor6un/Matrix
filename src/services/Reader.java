package services;

import interfaces.Readable;

import java.io.*;

public class Reader implements Readable {


    @Override
    public int[][] readMatrix(String path) {

        int[][] result = null;

        try {

            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fr);
            String line = bufferedReader.readLine();

            int i = 0;

            String[]  strings = line.split(" ");

            result = new int[strings.length][strings.length];

            while (line != null) {

                strings = line.split(" ");

                for (int j = 0; j < strings.length; j++) {
                    result[i][j] = Integer.parseInt(strings[j]);
                }
                i++;
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert result != null;
        if (isSquareMatrix(result)){
            return result;
        } else {
            return null;
        }
    }

    public boolean isSquareMatrix(int[][] matrix) {

        return matrix.length == matrix[0].length;
    }

   /* public void display(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println();
        }
    }*/
}
