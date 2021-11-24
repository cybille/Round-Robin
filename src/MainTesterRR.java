import java.util.Scanner;
public class MainTesterRR {
    public static void main(String[] args) {
        RRAlgorithm rr= new RRAlgorithm();
        Scanner scanner= new Scanner(System.in);
        System.out.println("set time quantum ");
        int time = scanner.nextInt();

        ProcessCreator processes = new ProcessCreator("p1", 4, time);
        processes.newProcess("p2", 12);
        processes.newProcess("p3", 1);
        processes.newProcess("p4", 8);
        processes.newProcess("p5", 5);

        processes.printClock();

        System.out.println("\n Run  ");

        rr.rR(processes);
        processes.printClock();
        processes.setInfo();
        processes.getInfo();


    }
}
