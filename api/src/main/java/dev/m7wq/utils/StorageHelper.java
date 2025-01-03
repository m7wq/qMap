package dev.m7wq.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import redis.clients.jedis.Jedis;

import java.io.File;


public class StorageHelper {
    @Setter
    private static File path;

    public static File getPath(){
        if (path == null)
            throw new IllegalArgumentException("You didn't load the MapAPI please use MapAPI#load" +
                    "\n"+"EXAMPLE: new MapAPI().load(plugin.getDataFolder())");

        return path;
    }

}
