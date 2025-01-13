package dev.m7wq.scoreboard.utils;

import dev.mqzen.boards.BoardManager;
import dev.mqzen.boards.base.BoardAdapter;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardUtil {

    public static void setup(Player player, BoardAdapter adapter){
        BoardManager.getInstance().setupNewBoard(player,adapter);
    }

    public static void remove(Player plr){
        BoardManager.getInstance().removeBoard(plr);
    }
}
