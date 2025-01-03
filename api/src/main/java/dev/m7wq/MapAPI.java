package dev.m7wq;


import dev.m7wq.utils.StorageHelper;
import lombok.Getter;

import java.io.File;


public class MapAPI
{




    public static void load(File path){

        StorageHelper.setPath(path);
    }

}
