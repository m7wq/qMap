package dev.m7wq.files.yaml;

import dev.m7wq.file.MapDataSource;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

@Getter@Setter
public class MapYML  {

    File file;
    YamlConfiguration configuration;
    MapDataSource dataSource;

    public MapYML(File path ,String name){


        if (!name.endsWith(".yml"))
            name = name+".yml";

        file = new File(path,name);
        configuration = YamlConfiguration.loadConfiguration(file);

        this.dataSource = new MapDataSource(configuration);

        if (!file.exists())
            file.getParentFile().mkdirs();





    }

    public Location getLocation(ConfigurationSection section, String key){
        return (Location) section.get(key);
    }

    public Location getLocation(String key){
        return (Location) configuration.get(key);
    }
}
