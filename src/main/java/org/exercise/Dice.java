package org.exercise;

import java.util.Random;

public class Dice {
    private static final Random random = new Random();
    private int[] sides;
    private double[] probs;
    public Dice(double[] probs) {
        this.probs = probs;
    }
    public int roll() {
        int randomNum = random.nextInt(6) + 1;
        return randomNum;
    }
}
