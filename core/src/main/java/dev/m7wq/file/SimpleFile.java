package dev.m7wq.file;


import lombok.Getter;
import lombok.SneakyThrows;

import java.io.*;

@Getter

public class SimpleFile {


    public File file;
    public BufferedWriter writer;
    public BufferedReader reader;

    public SimpleFile(File path ,String fileName) throws IOException{

        if (fileName.endsWith(".schematic"))
            fileName = fileName+".schematic";

        file = new File(path+"/schematics/",fileName);

        if (file.exists())
            throw new IllegalArgumentException("Schematic File name already exists");
        else
            file.mkdirs();

        writer = new BufferedWriter(new FileWriter(file));
        reader = new BufferedReader(new FileReader(fileName));


    }


    public boolean appendNewLine()  {
        try {
            writer.write(System.lineSeparator());
        }catch (IOException e){
            return false;
        }
        return true;
    }

}
