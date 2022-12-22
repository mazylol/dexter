package com.mazylol.dexter.commands.PokemonCommand;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.utils.Client;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

import static com.mazylol.dexter.commands.PokemonCommand.PokemonStats.statsEmbed;

public class PokemonBase extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("pokemon")) {
            try {
                Pokemon pokemon = Client.getPokemonByName(Objects.requireNonNull(event.getOption("name")).getAsString());

                String option = Objects.requireNonNull(event.getOption("categories")).getAsString();

                switch (option) {
                    case "stats" -> event.replyEmbeds(statsEmbed(pokemon)).queue();
                    case "evolution" -> System.out.println("Evolution");
                }

            } catch (Exception e) {
                EmbedBuilder eb = new EmbedBuilder();

                eb.setTitle(":warning: Error! :warning:");
                eb.setDescription("That Pokemon does not exist!");
                eb.setColor(Color.RED);

                event.replyEmbeds(eb.build()).queue();
            }
        }
    }
}
