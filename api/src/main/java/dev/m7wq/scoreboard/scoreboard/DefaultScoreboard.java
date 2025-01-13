package dev.m7wq.scoreboard.scoreboard;

import dev.mqzen.boards.base.BoardAdapter;
import dev.mqzen.boards.base.Title;
import dev.mqzen.boards.body.Body;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

public class DefaultScoreboard implements BoardAdapter {


    @Override
    public @NonNull Title title(Player player) {
        return Title.builder().withText("&eqMap Map Area").build();

    }

    @Override
    public @NonNull Body getBody(Player player) {



        return Body.of(
                "&l&m------------------------",
                "&eAuthor: &cm7wq",
                "&eScoreboard: &cDefault",
                "&l&m------------------------",
                "You can edit this by:",
                "Setting a scoreboard in MapBuilder!",
                "&l&m------------------------"
        );
    }
}
