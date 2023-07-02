package org.exercise;

import java.util.List;
import java.util.Random;

import static org.exercise.Main.PROBABILITIES;
import static org.exercise.Main.WINNING_POINT;

public class Referee {
    private List<Player> players;
    private Dice dice;
    private int currentPlayerIndex;

    public Referee(List<Player> players) {
        this.players = players;
        this.dice = new Dice(PROBABILITIES[new Random().nextInt(PROBABILITIES.length)]);
        this.currentPlayerIndex = 0;
    }

    public boolean isGameOver(){
        for (Player player : players) {
            if (player.getCurrentPoint() == WINNING_POINT) {
                return true;
            }
        }
        return false;
    }

    public void nextTurn(){
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println("Lượt của " + currentPlayer.getName() );
        currentPlayer.takeTurn(dice, this);
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void declareWinner(Player winnerPlayer) {
        System.out.println(winnerPlayer.getName() + " là người thắng cuộc");
        for (Player player : players) {
                if (player instanceof Bot && !player.getName().equals(winnerPlayer.getName())) {
                    Bot botPlayer = (Bot) player;
                    botPlayer.expressEmotion();
            }
        }
    }

    public void showScoreboard() {
        System.out.println("Bảng điểm:");
        System.out.println("Tên người chơi\tĐiểm số");
        System.out.println("------------------------");
        for (Player player : players) {
            System.out.printf("%-15s\t%d\n", player.getName(), player.getCurrentPoint());
        }
        System.out.println();
    }
}

