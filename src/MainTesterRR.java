public class MainTesterRR {
    public static void main(String[] args) {
        RRAlgorithm rr= new RRAlgorithm();

        ProcessCreator processes = new ProcessCreator("p1", 4, 2);
        processes.newProcess("p2", 12);
        processes.newProcess("p3", 10);
//        System.out.println("waiting time in ready queue " + processes.nextWaitingTime());
        processes.newProcess("p4", 4);
        processes.newProcess("p5", 12);
//        System.out.println("\n waiting time in ready queue " + processes.nextWaitingTime());


        ProcessCreator processes2 = new ProcessCreator("p6", 12, 4);
        processes2.newProcess("p7", 12);

        processes.printClock();
        System.out.println("\n New processes, new time quantum  \n");
        processes2.printClock();


        System.out.println("\n Run  ");

        rr.rR(processes);
        processes.printClock();

        System.out.println("\n Run  ");

        rr.rR(processes2);
        processes2.printClock();




    }
}
