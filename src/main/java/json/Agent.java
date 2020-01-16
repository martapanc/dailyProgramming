package json;

public class Agent {

    private String name;
    private double rating;

    public Agent(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "name:'" + name + '\'' +
                ", rating:" + rating +
                '}';
    }
}
