package services;

import interfaces.Writable;

import java.io.FileWriter;
import java.io.IOException;

public class Writer implements Writable {

    @Override
    public void write(String path, int[][] matrix) {
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
}
