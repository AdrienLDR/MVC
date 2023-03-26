package Model;

public class PetModel {
    private static String name;
    private static String species;

    public PetModel() {
        this.name = name;
        this.species = species;
    }


    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }


    public PetModel getPet() {
        return this;
    }
    public void setPet(PetModel pet) {
        this.name = name;
        this.species = species;
    }
}