package org.exercise;

import static org.exercise.Main.WINNING_POINT;

public abstract class Player {
    private String name;
    private int currentPoint;

    public Player(String name, int currentPoint) {
        this.name = name;
        this.currentPoint = currentPoint;
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentPoint() {
        return this.currentPoint;
    }

    public void addPoint(int point) {
        this.currentPoint += point;
        if (this.currentPoint > WINNING_POINT) {
            this.currentPoint = 0;
        }
    }

    public void takeTurn(Dice dice, Referee referee) {
        int rollResult = dice.roll();
        System.out.println(this.getName() + " tung được " + rollResult);
        addPoint(rollResult);
        System.out.println(this.getName() + " có " + this.getCurrentPoint() + " điểm.");
    }
    public abstract boolean isHuman();
}
