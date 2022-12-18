package com.mazylol.dexter.commands;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.utils.Client;
import com.mazylol.dexter.Tools.Stats;
import com.mazylol.dexter.Tools.Text;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.Color;
import java.time.Instant;
import java.util.Objects;

public class PokemonCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("pokemon")) {
            EmbedBuilder eb = new EmbedBuilder();
            try {
                Pokemon pokemon = Client.getPokemonByName(Objects.requireNonNull(event.getOption("name")).getAsString());

                eb.setColor(new Color(240, 62, 51));
                eb.setTitle(Text.capitalize(pokemon.getName()) + " (#" + pokemon.getId() + ")");
                eb.addField("Height", pokemon.getHeight() + " (dm)", true);
                eb.addField("Weight", pokemon.getWeight() + " (hg)", true);
                eb.addField("HP",  Stats.getStat(pokemon, "hp"), true);
                eb.addField("Attack", Stats.getStat(pokemon, "attack"), true);
                eb.addField("Defense", Stats.getStat(pokemon, "defense"), true);
                eb.addField("Special Attack", Stats.getStat(pokemon, "special-attack"), true);
                eb.addField("Speed", Stats.getStat(pokemon, "special-defense"), true);
                eb.setThumbnail(pokemon.getSprites().getFrontDefault());
                eb.setTimestamp(Instant.now());

                event.replyEmbeds(eb.build()).queue();
            } catch (Exception e) {
                eb.setColor(Color.RED);
                eb.setTitle("Error!");
                eb.setDescription("That Pokemon does not exist!");

                event.replyEmbeds(eb.build()).queue();
            }
        }
    }
}
