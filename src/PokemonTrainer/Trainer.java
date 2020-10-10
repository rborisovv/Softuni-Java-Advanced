package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private final String name;
    private int numberOfBadges;
    private final List<Pokemon> pokemonList;

    public Trainer(String name, int numberOfBadges, List<Pokemon> pokemonList) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemonList = new ArrayList<>();
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",
                this.name, this.numberOfBadges, this.pokemonList.size());
    }
}