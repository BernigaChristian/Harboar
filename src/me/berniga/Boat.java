package me.berniga;

public class Boat {
    private String name;
    private String nationality;
    private double length;
    private double weight;
    private String type;

    public Boat(String name, String nationality, double length, double weight, String type) {
        this.name = name;
        this.nationality = nationality;
        this.length = length;
        this.weight = weight;
        this.type = type;
    }

    public Boat(Boat b) {
        this.name = b.name;
        this.nationality = b.nationality;
        this.length = b.length;
        this.weight = b.weight;
        this.type = b.type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Boat{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", length=" + length +
                ", weight=" + weight +
                ", type=" + type +
                '}';
    }
}
