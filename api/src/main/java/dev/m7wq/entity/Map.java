package dev.m7wq.entity;

import dev.m7wq.cuboid.Cuboid;
import dev.m7wq.files.schematics.SchematicFile;
import dev.m7wq.map.Distance;
import dev.m7wq.map.IMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.io.File;
import java.util.List;

@AllArgsConstructor
public class Map implements IMap {

    protected SchematicFile file;
    protected Cuboid cuboid;

    @Override
    public void pasteMap(Location positionOne) {

        List<BlockText> blocks = file.getBlocks();

        for (BlockText block : blocks){
            int x = Integer.parseInt(block.getDiffX()),
            y = Integer.parseInt(block.getDiffY()),
            z = Integer.parseInt(block.getDiffZ()),
            id = Integer.parseInt(block.getId());

            byte data = Byte.parseByte(block.getData());

            positionOne.clone()
                    .add(x,y,z).getBlock().setTypeIdAndData(id,data,true);
        }

    }

    @Override
    public void duplicateWithDistance(Distance distance) {

    }

    @Override
    public void setScoreboard(Scoreboard scoreboard) {

    }

    @Override
    public void setPlayersOnTab(List<Player> players) {

    }
}
