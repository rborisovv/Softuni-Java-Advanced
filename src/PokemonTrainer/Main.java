package PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split("\\s+");
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        while (!inputLine[0].equals("Tournament")) {
            String trainerName = inputLine[0];
            String pokemonName = inputLine[1];
            String pokemonElement = inputLine[2];
            int pokemonHealth = Integer.parseInt(inputLine[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer(trainerName, 0, new ArrayList<>());
            trainer.getPokemonList().add(pokemon);
            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, trainer);
            } else {
                trainers.get(trainerName).getPokemonList().add(pokemon);
            }
            inputLine = scanner.nextLine().split("\\s+");
        }
        String element = scanner.nextLine();
        while (!element.equals("End")) {
            switch (element) {
                case "Fire":
                case "Water":
                case "Electricity":
                    checkExistingPokemons(element, trainers);
                    break;
            }
            element = scanner.nextLine();
        }
        trainers
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    return Integer.compare(p2.getValue().getNumberOfBadges(), p1.getValue().getNumberOfBadges());
                }).forEach(trainer -> System.out.println(trainer.getValue().toString()));
    }

    private static void checkExistingPokemons(String element, LinkedHashMap<String, Trainer> trainers) {
        for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
            List<Pokemon> currentTrainerPokemonsList = entry.getValue().getPokemonList();
            boolean haveParticularElement = false;
            for (Pokemon pokemon : currentTrainerPokemonsList) {
                if (pokemon.getElement().equals(element)) {
                    haveParticularElement = true;
                    break;
                }
            }
            Trainer currentTrainer = trainers.get(entry.getKey());
            if (haveParticularElement) {
                int currentTrainerNumberOfBadges = currentTrainer.getNumberOfBadges();
                currentTrainer.setNumberOfBadges(currentTrainerNumberOfBadges + 1);
            } else {
                List<Pokemon> currentTrainerPokemonList = currentTrainer.getPokemonList();
                for (ListIterator<Pokemon> iterator = currentTrainerPokemonList.listIterator(); iterator.hasNext(); ) {
                    Pokemon pokemon = iterator.next(); //The ListOFPokemons
                    int currentPokemonsHealth = pokemon.getHealth();
                    if (currentPokemonsHealth - 10 <= 0) {
                        iterator.remove();
                    } else {
                        pokemon.setHealth(currentPokemonsHealth - 10);
                    }
                }
            }
        }
    }
}