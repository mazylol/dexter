package com.mazylol.dexter.Tools;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jetbrains.annotations.NotNull;

public class Stats {
    public static String getStat(@NotNull Pokemon pokemon, int index) {
        JsonObject stats = JsonParser.parseString(String.valueOf(pokemon.getStats().get(index))).getAsJsonObject();
        return stats.get("base_stat").getAsString();
    }
}
