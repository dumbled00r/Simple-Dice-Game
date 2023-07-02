package org.exercise;

public class HumanPlayer extends Player{
    public HumanPlayer(String name, int currentPoint) {
        super(name, currentPoint);
    }

    @Override
    public boolean isHuman() {
        return false;
    }
}
