package dev.m7wq.map;

public enum Rotation {
    DEGREE_90(90),
    DEGREE_180(180),
    DEGREE_270(270);

    private final int angle;

    Rotation(int angle) {
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }
}