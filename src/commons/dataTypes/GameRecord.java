package commons.dataTypes;

import commons.game.Player;

import java.io.Serializable;

public class GameRecord implements Serializable {
    final Player player1, player2;
    final Player winner;
    final int totalMove;

    public GameRecord(Player player1, Player player2, Player winner, int totalMove) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
        this.totalMove = totalMove;
    }
}
