public class U1 extends Rocket {
    private final double LAUNCH_PERC = 5;
    private final double LAND_PERC = 1;

    public U1(int cost, int rocketWeight, int rocketMaxWeight, int cargoWeight) {
        super(cost, rocketWeight, rocketMaxWeight);
        this.setCargoWeight(cargoWeight);
    }

    @Override
    public boolean launch() {
        return willCrash(LAUNCH_PERC);
    }

    @Override
    public boolean land() {
        return willCrash(LAND_PERC);
    }

    private boolean willCrash(double crashPercent) {
        double probOfCrash = crashPercent * ((double)this.getCargoWeight() / (double)this.getCargoLimit());
        return Math.random() >= (1 - probOfCrash);
    }
}
