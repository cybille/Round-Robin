public class MainTester2 {
    public static void main(String[] args) {
        CPU cpu= new CPU();
        Process testProcess1=  new Process("test 2", 12);
        Process testProcess2=  new Process("test 2", 4);
        System.out.println("process 1");
        cpu.setTimeQuantum(4);
        cpu.getProcess(testProcess1);
//        cpu.executeProcess();
        System.out.println("\n process 2");
        cpu.setTimeQuantum(5);
        cpu.getProcess(testProcess2);
//        cpu.executeProcess();

        cpu.executeAll();
    }
}
