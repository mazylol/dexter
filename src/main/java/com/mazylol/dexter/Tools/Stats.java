package com.mazylol.dexter.Tools;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jetbrains.annotations.NotNull;

public class Stats {
    public static String getStat(@NotNull Pokemon pokemon, String type) {
        int index = switch (type) {
            case "hp" -> 0;
            case "attack" -> 1;
            case "defense" -> 2;
            case "special-attack" -> 3;
            case "special-defense" -> 4;
            case "speed" -> 5;

            default -> 69;
        };

        if (index == 69) System.out.println("Not a valid stat : Stats.java");

        JsonObject stats = JsonParser.parseString(String.valueOf(pokemon.getStats().get(index))).getAsJsonObject();
        return stats.get("base_stat").getAsString();
    }
}
