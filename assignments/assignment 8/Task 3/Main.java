import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        File src = new File("source/");
        File dest = new File("target/");
        dest.mkdir();

        File[] files = src.listFiles();

        for(File file: files) {
            if(file.isFile() && file.getName().endsWith(".java")){
                FileInputStream fin = new FileInputStream(file.getAbsolutePath()); //source
                FileOutputStream fout = new FileOutputStream(dest.getAbsolutePath() + "\\" + file.getName()); //target
                int i;
                while((i=fin.read()) != -1) {
                    fout.write(i);
                }
            }
        }
        System.out.println("Successfully copied to: " + dest.getAbsolutePath());
    }
}