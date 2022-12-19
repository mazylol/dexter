package com.mazylol.dexter.Tools;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jetbrains.annotations.NotNull;

public class Stats {
    public static String getHp(@NotNull Pokemon pokemon) {
        JsonObject stats = JsonParser.parseString(String.valueOf(pokemon.getStats().get(0))).getAsJsonObject();
        return stats.get("base_stat").getAsString();
    }

    public static String getAttack(@NotNull Pokemon pokemon) {
        JsonObject stats = JsonParser.parseString(String.valueOf(pokemon.getStats().get(1))).getAsJsonObject();
        return stats.get("base_stat").getAsString();
    }

    public static String getDefense(@NotNull Pokemon pokemon) {
        JsonObject stats = JsonParser.parseString(String.valueOf(pokemon.getStats().get(2))).getAsJsonObject();
        return stats.get("base_stat").getAsString();
    }

    public static String getSpecialAttack(@NotNull Pokemon pokemon) {
        JsonObject stats = JsonParser.parseString(String.valueOf(pokemon.getStats().get(3))).getAsJsonObject();
        return stats.get("base_stat").getAsString();
    }

    public static String getSpecialDefense(@NotNull Pokemon pokemon) {
        JsonObject stats = JsonParser.parseString(String.valueOf(pokemon.getStats().get(4))).getAsJsonObject();
        return stats.get("base_stat").getAsString();
    }

    public static String getSpeed(@NotNull Pokemon pokemon) {
        JsonObject stats = JsonParser.parseString(String.valueOf(pokemon.getStats().get(5))).getAsJsonObject();
        return stats.get("base_stat").getAsString();
    }
}
