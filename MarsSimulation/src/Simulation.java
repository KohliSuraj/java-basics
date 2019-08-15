import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Simulation {
    private final int INITIAL_CARGO_WEIGHT = 0;

    /**
     * Loads all items from a text file and stores it in an array
     *
     * @return list of Items
     *
     * @throws FileNotFoundException
     */
    public List<Item> loadItems(String pathName) throws FileNotFoundException {
        List<Item> items = new ArrayList<>();
        Scanner sc = new Scanner(new File(pathName));
        while (sc.hasNextLine()) {
            String[] itemPair = sc.nextLine().split("=");
            Item item = new Item(itemPair[0], parseInt(itemPair[1]));
            items.add(item);
        }
        return items;
    }

    /**
     * Creates multiple U1 rockets and fills them till full capacity
     *
     * @param items
     * @param u1 rocket object
     *
     * @return list of U1 Rockets which are fully filled
     */
    public List<U1> loadU1(List<Item> items, U1 u1) {
        List<U1> u1Rockets = new ArrayList();
        for (Item item : items) {
            if (u1.canCarry(item)) {
                u1.carry(item);
            } else {
                u1Rockets.add(u1);
                u1 = new U1(u1.getCost(), u1.getRocketWeight(), u1.getMaxRocketWeight(), INITIAL_CARGO_WEIGHT);
            }
        }
        return u1Rockets;
    }

    /**
     * Creates multiple U2 rockets and fills them till full capacity
     *
     * @param items
     * @param u2 rocket object
     *
     * @return list of U2 Rockets which are fully filled
     */
    public List<U2> loadU2(List<Item> items, U2 u2) {
        List<U2> u2Rockets = new ArrayList();
        for (Item item : items) {
            if (u2.canCarry(item)) {
                u2.carry(item);
            } else {
                u2Rockets.add(u2);
                u2 = new U2(u2.getCost(), u2.getRocketWeight(), u2.getMaxRocketWeight(), INITIAL_CARGO_WEIGHT);
            }
        }
        return u2Rockets;
    }

//    /**
//     * Creates multiple U2 rockets and fills them till full capacity
//     *
//     * @param items
//     * @param <T> can be U1 or U2 type of rocket
//     *
//     * @return list of U2 Rockets which are fully filled
//     */
//    public <T extends Rocket> List<T> loadU2(List<Item> items, T uRocket) {
//        List<T> uRockets = new ArrayList();
//        for (Item item : items) {
//            if (uRocket.canCarry(item)) {
//                uRocket.carry(item);
//            } else {
//                uRockets.add(uRocket);
//                new T();
////                uRocket = new T(uRocket.getCost(), uRocket.getRocketWeight(), uRocket.getMaxRocketWeight(),
// INITIAL_CARGO_WEIGHT);
//            }
//        }
//        return uRockets;
//    }

    /**
     * Runs a simulation to launch and land all the rockets
     *
     * @param rockets
     *
     * @return cost of sending rockts to space
     */
    public <T extends Rocket> long runSimulation(List<T> rockets) {
        long totalCost = 0;
        int tries = 0;
        int successFullTries = 0;
        Boolean launchSuccessfull = false;
        Boolean landSuccessfull = false;

        for (T rocket : rockets) {
            ++tries;
            while (!launchSuccessfull || !landSuccessfull) {
                ++successFullTries;
                launchSuccessfull = rocket.launch();
                landSuccessfull = rocket.land();
                totalCost += rocket.getCost();
            }
        }
        System.out.println("Number of tries to send all items: " + tries);
        System.out.println("Number of successful tries to send all items: " + successFullTries);
        return totalCost;
    }

}
