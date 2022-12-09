package com.mazylol.dexter;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jetbrains.annotations.NotNull;

public class Tools {
    public static String capitalize(String str) {
        if (str == null || str.length() == 0) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String getStat(@NotNull Pokemon pokemon, int index) {
        JsonObject stats = JsonParser.parseString(String.valueOf(pokemon.getStats().get(index))).getAsJsonObject();
        return stats.get("base_stat").getAsString();
    }
}
