package uk.co.informaticslab.domain;

public class Vector2D {

    private final Integer x;
    private final Integer y;

    public Vector2D(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Double getDistanceFromVector2D(Vector2D other) {
        return Math.sqrt(Math.pow(getX() - other.getX(),2) + Math.pow(getY() - other.getY(),2));
    }

}
