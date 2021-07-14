package dev.lillian.bonk.test.model;

public record CustomLocation(double x, double y, double z) {
    @Override
    public String toString() {
        return "CustomLocation{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
