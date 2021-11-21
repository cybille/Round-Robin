public class MainTesterRR {
    public static void main(String[] args) {


        ProcessCreator processes = new ProcessCreator("p1", 4, 2);
        processes.newProcess("p2", 12);
        processes.newProcess("p3", 10);
        System.out.println("waiting time in ready queue " + processes.nextWaitingTime());
        processes.newProcess("p4", 4);
        processes.newProcess("p5", 12);
        System.out.println("\n waiting time in ready queue " + processes.nextWaitingTime());


        ProcessCreator processes2 = new ProcessCreator("p6", 12, 4);
        processes2.newProcess("p7", 12);

        processes.printClock();
//        System.out.println("New processes, new time quantum ");
//        processes2.printClock();

        RRAlgorithm rr= new RRAlgorithm();
        rr.rR(processes);

        processes.printClock();

    }
}
