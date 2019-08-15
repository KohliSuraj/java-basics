/**
 * Item class which contains name and weight which will represent an item to be carried by the rockets
 */
public class Item {
    private String name;
    private int weight;

    /**
     *
     * @param name
     * @param weight
     */
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the weight
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
