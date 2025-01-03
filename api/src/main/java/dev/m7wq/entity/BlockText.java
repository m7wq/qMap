package dev.m7wq.entity;

import lombok.Getter;

@Getter

public class BlockText {

    public BlockText(String code){
        String[] arr = code.split(":");

        diffX = arr[0];
        diffY = arr[1];
        diffZ = arr[2];
        id = arr[3];
        data = arr[4];
    }



    String diffX;
    String diffY;
    String diffZ;
    String id;
    String data;


    @Override
    public String toString() {
        return new StringBuilder()
                .append(diffX)
                .append(":")
                .append(diffY)
                .append(":")
                .append(diffZ)
                .append(":")
                .append(id)
                .append(":")
                .append(data).toString();
    }
}
