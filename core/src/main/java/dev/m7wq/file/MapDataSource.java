package dev.m7wq.file;

import com.avaje.ebean.validation.NotNull;
import dev.m7wq.entity.Map;
import dev.m7wq.files.yaml.MapSection;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.val;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
public class MapDataSource {

    public YamlConfiguration configuration;

    public MapSection load(String name){

        @NonNull Location pos1 = (Location) configuration.get(name + ".pos1");
        @NonNull Location pos2 = (Location) configuration.get(name+".pos2");

        List<Location> locationsList = new ArrayList<>();

        @NonNull ConfigurationSection locations = configuration.getConfigurationSection(name+".locations");

        for (String key : locations.getKeys(false)){
            locationsList.add( (Location) locations.get(key));
        }

        return new MapSection(pos1,pos2,locationsList);

    }

    public void save(String name, Location l1, Location l2){

        if (!configuration.contains(name)){
            createNew(name, l1,l2);
            return;
        }





    }

    private void createNew(String name, Location l1, Location l2){

        String[] content = getYamlSetUpContent(name);

        configuration.set(content[0],l1);
        configuration.set(content[1],l2);

        configuration.set(content[2],new ArrayList<>());
    }

    private String[] getYamlSetUpContent(String name){
        return new StringBuilder()
                .append(name).append(".pos1").append(":")
                .append(name).append(".pos2").append(":")
                .append(name).append(".locations").toString().split(":");
    }




}
