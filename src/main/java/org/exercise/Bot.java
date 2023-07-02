package org.exercise;

import java.util.Random;

public class Bot extends Player implements Emotion{
    private int id;
    private Emotion emotion;
    private String[] emotions = {"Thua rồi, buồn quá!", "Cho tôi đấu lại được không?", "Bạn giỏi quá!"};

    public Bot(int id, String name, int currentPoint, Emotion emotion) {
        super(name, currentPoint);
        this.emotion = emotion;
    }

    @Override
    public boolean isHuman() {
        return false;
    }

    @Override
    public void expressEmotion() {
        System.out.println(this.getName() + ": " + emotions[new Random().nextInt(emotions.length)]);
    }
}
