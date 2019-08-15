import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long totalBudget;
        Simulation sim = new Simulation();
        List<Item> phase1Items = sim.loadItems("./resources/phase-1.txt");
        List<Item> phase2Items = sim.loadItems("./resources/phase-2.txt");

        U1 u1 = new U1(100000000, 10000, 18000, 0);
        U2 u2 = new U2(120000000, 18000, 29000, 0);

        List<U1> u1Rockets = sim.loadU1(phase1Items, u1);
        List<U2> u2Rockets = sim.loadU2(phase2Items, u2);

        totalBudget = sim.runSimulation(u1Rockets);
        System.out.println(totalBudget);
        totalBudget = sim.runSimulation(u2Rockets);
        System.out.println(totalBudget);
    }
}
