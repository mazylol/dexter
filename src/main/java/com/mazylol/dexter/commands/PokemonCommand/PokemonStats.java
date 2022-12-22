package com.mazylol.dexter.commands.PokemonCommand;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.mazylol.dexter.Tools.Stats;
import com.mazylol.dexter.Tools.Text;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;
import java.time.Instant;

public class PokemonStats {
    public static MessageEmbed statsEmbed(Pokemon pokemon) {
        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle(Text.capitalize(pokemon.getName()) + " (#" + pokemon.getId() + ")");
        eb.addField("Height", pokemon.getHeight() + " (dm)", true);
        eb.addField("Weight", pokemon.getWeight() + " (hg)", true);
        eb.addField("HP", Stats.getHp(pokemon), true);
        eb.addField("Attack", Stats.getAttack(pokemon), true);
        eb.addField("Defense", Stats.getDefense(pokemon), true);
        eb.addField("Special Attack", Stats.getSpecialAttack(pokemon), true);
        eb.addField("Special Defense", Stats.getSpecialDefense(pokemon), true);
        eb.addField("Speed", Stats.getSpeed(pokemon), true);
        eb.setThumbnail(pokemon.getSprites().getFrontDefault());
        eb.setColor(new Color(240, 62, 51));
        eb.setTimestamp(Instant.now());

        return eb.build();
    }
}
