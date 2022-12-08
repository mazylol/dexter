package com.mazylol.dexter;

import com.mazylol.dexter.commands.PokemonCommand;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class Bot {
    public static void main(String[] args) throws Exception {
        Dotenv dotenv = Dotenv.load();

        JDA jda = JDABuilder.createDefault(dotenv.get("DEVTOKEN"))
                .setActivity(Activity.competing("to become the very best"))
                .addEventListeners(new PokemonCommand())
                .build().awaitReady();

        Guild guild = jda.getGuildById(dotenv.get("GUILD"));

        assert guild != null;
        guild.updateCommands().addCommands(
                Commands.slash("pokemon", "general info on a pokemon")
                        .addOptions(
                                new OptionData(OptionType.STRING, "name", "name of the pokemon").setRequired(true)
                        )
        ).queue();
    }
}