package org.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static final int WINNING_POINT = 21;
    static final double[][] PROBABILITIES = {   {0.2, 0.16, 0.16, 0.16, 0.16, 0.16},
                                                {0.16, 0.2, 0.16, 0.16, 0.16, 0.16},
                                                {0.16, 0.16, 0.2, 0.16, 0.16, 0.16},
                                                {0.16, 0.16, 0.16, 0.2, 0.16, 0.16}
                                            };

    static final Emotion emotion = null;

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng người chơi: ");
        int numPlayers = scanner.nextInt();

        // Yêu cầu người chơi nhập tên của họ
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Nhập tên của người chơi " + (i + 1) + ": ");
            String name = scanner.next();
            players.add(new HumanPlayer(name, 0));
        }
        // Thêm người chơi ảo nếu số lượng người chơi < 4
        int id = 1;
        while (players.size() < 4) {
            players.add(new Bot(id, "Người chơi ảo " + id,0,  emotion));
            id++;
        }
        Referee referee = new Referee(players);
        System.out.println("Chơi trò chơi tung xúc xắc. Nhấn Enter để bắt đầu.");
        scanner.nextLine();
        while (!referee.isGameOver()) {
            referee.nextTurn();
            scanner.nextLine();
        }

        referee.showScoreboard();
        Player winner = null;
        for (Player player : players) {
            if (player.getCurrentPoint() == WINNING_POINT) winner = player;
        }
        // Kết thúc trò chơi
        referee.declareWinner(winner);
        scanner.close();
    }
}