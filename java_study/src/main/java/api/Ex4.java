package api;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Ex4 {

    private static final Logger logger = Logger.getLogger(Ex4.class.getName());

    public static void main(String[] args) throws IOException {
        int lim = 100;
        String str="TEST\n".repeat(100);
        try(BufferedWriter bw= new BufferedWriter(new FileWriter("output.txt"))){
            bw.write(str);
            System.out.println("Output written to file");
        }catch(IOException e){
            FileHandler fh = new FileHandler("error.log", true);
            logger.addHandler(fh);
            fh.setFormatter(new SimpleFormatter());
            logger.log(Level.WARNING, "Write error");
            System.out.println("Error writing to file");
        }
    }
}
