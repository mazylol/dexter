package com.mazylol.dexter.commands.PokemonCommand;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.utils.Client;
import com.mazylol.dexter.Tools.Stats;
import com.mazylol.dexter.Tools.Text;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.Instant;
import java.util.Objects;

/*
    * This is a command that will return a Pokemon's stats
    * There will be a drop-down menu below to select specific categories
    * The default will be the general stats
 */

public class PokemonBase extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("pokemon")) {
            EmbedBuilder eb = new EmbedBuilder();

            try {
                Pokemon pokemon = Client.getPokemonByName(Objects.requireNonNull(event.getOption("name")).getAsString());

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

                event.replyEmbeds(eb.build()).queue();
            } catch (Exception e) {
                eb.setTitle("Error!");
                eb.setDescription("That Pokemon does not exist!");
                eb.setColor(Color.RED);

                event.replyEmbeds(eb.build()).queue();
            }
        }
    }
}
