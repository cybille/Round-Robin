import java.util.Scanner;
public class MainTesterRR {
    public static void main(String[] args) {
        RRAlgorithm rr= new RRAlgorithm();
        Scanner scanner= new Scanner(System.in);
        System.out.println("set time quantum ");
        int time = scanner.nextInt();

        ProcessCreator processes = new ProcessCreator("p1", 4, time);
        processes.newProcess("p2", 12);
        processes.newProcess("p3", 10);
        processes.newProcess("p4", 4);
        processes.newProcess("p5", 12);

        ProcessCreator processes2 = new ProcessCreator("p6", 2, 4);
        processes2.newProcess("p7", 10);

        processes.printClock();
        System.out.println("\n New processes, new time quantum  \n");
        processes2.printClock();


        System.out.println("\n Run  ");

        rr.rR(processes);
        processes.printClock();

        System.out.println("\n Run  ");

        rr.rR(processes2);
        processes2.printClock();

        processes.getInfo();
        processes2.getInfo();






    }
}
