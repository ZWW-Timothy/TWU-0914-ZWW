package com.twu.refactoring;

public class Direction {
    private final char direction;

    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        return getDirection('E', 'W');
    }

    private Direction getDirection(char east, char west) {
        switch (direction) {
            case 'N':
                return new Direction(east);
            case 'S':
                return new Direction(west);
            case 'E':
                return new Direction('N');
            case 'W':
                return new Direction('S');
            default:
                throw new IllegalArgumentException();
        }
    }

    public Direction turnLeft() {
        return getDirection('W', 'E');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
