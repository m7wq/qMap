package dev.m7wq;


import dev.mqzen.boards.BoardManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public class MapAPI
{

    private JavaPlugin plugin;

    public JavaPlugin getPlugin(){
        if (plugin == null)
            throw new IllegalArgumentException("You didn't load the MapAPI please use MapAPI#load" +
                    "\n"+"EXAMPLE: MapAPI.load(plugin.getDataFolder(), plugin)");

        return plugin;
    }


    private File path;



    public File getPath(){
        if (path == null)
            throw new IllegalArgumentException("You didn't load the MapAPI please use MapAPI#load" +
                    "\n"+"EXAMPLE: MapAPI.load(plugin.getDataFolder(), plugin)");

        return path;
    }

    private static MapAPI instance;

    public static MapAPI getInstance(){
        if (instance == null)
            throw new IllegalArgumentException("You didn't load the MapAPI please use MapAPI#load" +
                    "\n"+"EXAMPLE: MapAPI.load(plugin.getDataFolder(), plugin)");

        return instance;
    }

    public static void load(File path, JavaPlugin plugin){
        instance = new MapAPI();
        BoardManager.load(plugin);
        BoardManager.getInstance().startBoardUpdaters();
        instance.path = path;
    }

}
