import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        String intro= "Name your process, give burst time, give time quantum and watch this \n";
        String options= "1 create process \n"+
                "2 get arrival time \n" +
                "3 get execution time \n" +
                "4 get completion time \n" +
                "clock";

        System.out.print(intro);

        String process= scanner.next();
        System.out.print(intro);
        int burst= scanner.nextInt();
        System.out.print(intro);
        int quantum= scanner.nextInt();
        //call on create process and put in input

        //scheduler will organize processes


    }

}
