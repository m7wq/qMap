package dev.m7wq.files.yaml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

import java.util.List;


@AllArgsConstructor
@Getter@Setter
public class MapSection {

    Location pos1;
    Location pos2;
    List<Location> locations;

}
