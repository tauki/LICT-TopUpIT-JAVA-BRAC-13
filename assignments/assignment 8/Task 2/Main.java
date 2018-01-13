import java.io.*;

class Main {
    public static void main(String[] args){
        File f = new File("UniServer");

        File[] files = f.listFiles();

        int fCount = 0;
        int dCount = 0;
        for(File file: files){
            if(file.isFile()) fCount++;
            if(file.isDirectory()) dCount++;
        }

        System.out.printf("%-11s :\t %d\n", "Files", fCount);
        System.out.printf("%-11s :\t %d\n", "Directories", dCount);
    }
}