package com.mazylol.dexter.commands;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.utils.Client;
import com.mazylol.dexter.Tools;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.Instant;
import java.util.Objects;

public class PokemonCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("pokemon")) {
            EmbedBuilder eb = new EmbedBuilder();
            try {
                Pokemon pokemon = Client.getPokemonByName(Objects.requireNonNull(event.getOption("name")).getAsString());

                eb.setColor(Color.darkGray);
                eb.setTitle(Tools.capitalize(pokemon.getName()));
                eb.setImage(pokemon.getSprites().getFrontDefault());
                eb.setTimestamp(Instant.now());

                event.replyEmbeds(eb.build()).queue();
            } catch(Exception e) {
                eb.setColor(Color.RED);
                eb.setTitle("Error!");
                eb.setDescription("That Pokemon does not exist!");

                event.replyEmbeds(eb.build()).queue();
            }
        }
    }
}
