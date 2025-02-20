import java.io.*;
import java.util.Scanner;

class Country implements Serializable {
    String name;
    int population;
    double area;

    public Country(String name, int population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    @Override
    public String toString() {
        return "ქვეყანა: " + name + ", მოსახლეობა: " + population + ", ფართობი: " + area;
    }
}
