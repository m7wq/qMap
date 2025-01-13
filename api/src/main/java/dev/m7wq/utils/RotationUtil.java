package dev.m7wq.utils;

import dev.m7wq.map.Rotation;

public class RotationUtil {

    public int[] rotateRelative(int x, int z, Rotation rotation) {
        int rotatedX = x,rotatedZ=z;

        switch (rotation) {
            case DEGREE_90:


                rotatedX = -z;
                rotatedZ = x;
                break;
            case DEGREE_180:


                rotatedX = -x;

                rotatedZ = -z;

                break;
            case DEGREE_270:

                rotatedX = z;

                rotatedZ = -x;

                break;

            default:
                break;
        }

        return new int[]{rotatedX, rotatedZ};
    }

}
