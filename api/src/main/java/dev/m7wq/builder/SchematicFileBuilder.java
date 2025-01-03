package dev.m7wq.builder;

import dev.m7wq.files.schematics.SchematicFile;
import dev.m7wq.main.Buildable;
import lombok.Builder;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.experimental.SuperBuilder;

import java.io.File;



public class SchematicFileBuilder implements Buildable<SchematicFile> {

    File path;
    String name;


    public SchematicFileBuilder setPath(File path) {
        return this;
    }

    public SchematicFileBuilder setName(String name) {
        return this;
    }

    @SneakyThrows
    @Override
    public SchematicFile build() {
        return new SchematicFile(path,name);
    }
}
