import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Matcher {
    public static void main(String args[]) {



        try {
            FileReader file = new FileReader(new File("playerlist.txt"));
            BufferedReader r = new BufferedReader(file);




        } catch (IOException e) {
            System.out.println("File IO Exception. Please try again");
        }
    }
}
