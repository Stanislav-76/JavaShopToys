public class Toy {
    private int id;
    private String name;
    private int count;
    private int weight;
    
    public Toy(int id, String name, int count, int weight) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return String.join(",", String.valueOf(this.id), this.name, String.valueOf(this.count),
                String.valueOf(this.weight));
    }
}