/**
 * Rocket class implements the interface spaceship
 */
public class Rocket implements SpaceShip {
    private int cost;
    private int rocketWeight;
    // maxRocketWeight is rocketWeight + cargoLimit
    private int maxRocketWeight;
    private int cargoWeight;
    private int cargoLimit;

    public Rocket() {

    }

    public Rocket(int cost, int rocketWeight, int maxRocketWeight) {
        this.cost = cost;
        this.rocketWeight = rocketWeight;
        this.maxRocketWeight = maxRocketWeight;
        this.cargoLimit = maxRocketWeight - rocketWeight;
    }

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    /**
     * @param item
     *
     * @return a boolean indicating if rocket can carry specified item or not
     */
    public final boolean canCarry(Item item) {
        if (item.getWeight() + cargoWeight <= cargoLimit) {
            return true;
        }
        return false;
    }

    /**
     * carries the item by adding it to the cargo weight
     *
     * @param item
     */
    public final void carry(Item item) {
        this.cargoWeight = item.getWeight() + cargoWeight;
    }

    public int getCost() {
        return cost;
    }

    public int getRocketWeight() {
        return rocketWeight;
    }

    public int getMaxRocketWeight() {
        return maxRocketWeight;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public int getCargoLimit() {
        return cargoLimit;
    }
}
