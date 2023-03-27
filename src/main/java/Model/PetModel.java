package Model;

public class PetModel {
    private static String name;
    private static String species;

    public PetModel() {
        name = name;
        species = species;
    }


    public static String getName() {
        return name;
    }

    public void setName(String name) {
        PetModel.name = name;
    }

    public static String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        PetModel.species = species;
    }


    public PetModel getPet() {
        return this;
    }
    public void setPet(PetModel pet) {
        name = name;
        species = species;
    }
}