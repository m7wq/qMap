package dev.m7wq.files.schematics;


import dev.m7wq.entity.BlockText;
import dev.m7wq.file.SimpleFile;
import dev.m7wq.main.IDataBased;
import dev.m7wq.utils.SchematicUtil;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SchematicFile extends SimpleFile implements IDataBased {


    private List<String> blocks;




    public SchematicFile(File path, String fileName) throws IOException {
        super(path, fileName);
        load();

        // create yml tho.........
    }


    public List<BlockText> getBlocks() {
        List<BlockText> blockTexts = new ArrayList<>();
        blocks.forEach(block ->{
            blockTexts.add(new BlockText(block));
        });

        return blockTexts;
    }

    public void setBlocks(List<Block> blocks, Location pos1){

        List<BlockText> blocksToString = SchematicUtil.fromBlocksToString(blocks,pos1);

        blocks.clear();
        clear();
        blocksToString.forEach(blockText -> {
            this.blocks.add(blockText.toString());
        });
        save();


    }

    @Override
    public void save() {
        this.blocks.forEach(block -> {
            try {
                writer.write(block);
                appendNewLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });

    }

    @Override
    public void load() {

        try {


            List<String> loadedData = new ArrayList<>();

            String line;

            while((line = reader.readLine()) != null){
                loadedData.add(line);
            }

            this.blocks = loadedData;

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        throw new IllegalStateException("Error while loading "+file.getName());
    }

    @Override
    public void clear() {
        this.file.delete();
        this.file.mkdirs();
    }
}
