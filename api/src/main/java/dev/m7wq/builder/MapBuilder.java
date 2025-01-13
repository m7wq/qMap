package dev.m7wq.builder;


import dev.m7wq.MapAPI;
import dev.m7wq.cuboid.Cuboid;
import dev.m7wq.entity.Map;
import dev.m7wq.files.schematics.SchematicFile;
import dev.m7wq.main.Buildable;
import dev.m7wq.scoreboard.scoreboard.DefaultScoreboard;
import dev.mqzen.boards.base.BoardAdapter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Collection;
import java.util.List;


public class MapBuilder implements Buildable<Map> {

    String name;
    Location positionOne;
    Location positionTwo;
    BoardAdapter scoreboard = new DefaultScoreboard();
    Collection<Player> playersOnTab = (Collection<Player>) MapAPI.getInstance().getPlugin().getServer().getOnlinePlayers();

    public MapBuilder setName(String name) {
        return this;
    }

    public MapBuilder setPositionOne(Location positionOne) {
        return this;
    }

    public MapBuilder setPositionTwo(Location positionTwo) {
        return this;
    }

    @Override
    public Map build() {

        if (positionOne == null || positionTwo == null)
            throw new IllegalArgumentException("There is a position that is not defined in MapBuilder");
        else if (name == null)
            throw new IllegalArgumentException("Map name isn't defined in MapBuilder");

        Cuboid cuboid = new Cuboid(positionOne,positionTwo);



        SchematicFileBuilder builder = new SchematicFileBuilder()
                .setPath(MapAPI.getInstance().getPath()).setName(name);

        SchematicFile file = builder.build();

        file.setBlocks(cuboid.getBlocks(),positionOne);

        return new Map(scoreboard,playersOnTab,name,file,cuboid);

    }
}
