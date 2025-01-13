package dev.m7wq.entity;

import dev.m7wq.cuboid.Cuboid;
import dev.m7wq.files.schematics.SchematicFile;
import dev.m7wq.map.Distance;
import dev.mqzen.boards.base.BoardAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Getter@Setter
public class Map {


    public BoardAdapter scoreboard;
    public Collection<Player> playersOnTab;
    public String name;
    protected SchematicFile file;
    protected Cuboid cuboid;



    public void paste(Location positionOne) {

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

    public void rotate(Location position){}


    public void duplicateWithDistance(Distance distance) {

    }


}
