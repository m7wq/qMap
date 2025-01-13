package dev.m7wq.utils;

import dev.m7wq.entity.BlockText;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SchematicUtil {

    public static List<BlockText> fromBlocksToString(List<Block> blocks, Location pos1){

        List<BlockText> stringBlocks = new ArrayList<>();

        blocks.forEach(block -> {
            stringBlocks.add(fromBlockToString(block, pos1));
        });

        return stringBlocks;
    }

    private static BlockText fromBlockToString(Block block, Location pos1){

        StringBuilder builder = new StringBuilder();

        int diffX, diffY, diffZ;
        diffX = block.getX()- pos1.getBlockX();
        diffY = block.getY()- pos1.getBlockY();
        diffZ = block.getZ()- pos1.getBlockZ();

        builder
                .append(diffX)
                .append(":")
                .append(diffY)
                .append(":")
                .append(diffZ)
                .append(":")
                .append(block.getTypeId())
                .append(":")
                .append(block.getData());


        return new BlockText(builder.toString());


    }

}
