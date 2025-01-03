package dev.m7wq.map;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.List;

public interface IMap {

    void pasteMap(Location positionOne);
    void duplicateWithDistance(Distance distance);
    void setScoreboard(Scoreboard scoreboard);
    void setPlayersOnTab(List<Player> players);
}
