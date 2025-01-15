public class Burger {

    public String bun; // Brötchen
    private boolean vegan; // Vegan-Option
    private int toppingsCount;// Anzahl der Toppings
    private String sossen;

    public Burger(String bun, boolean vegan, int toppingsCount, String sossen) {
        this.bun = bun;
        this.vegan = vegan;
        this.toppingsCount = toppingsCount;
        this.sossen = sossen;
    }

    public String toString() {

        return "Bun: "+ bun +"\nVegan: " + vegan + "\nToppings: " + toppingsCount + "\nSosse: " + sossen + "\n ----------------------------------------------- \n";
    }
}