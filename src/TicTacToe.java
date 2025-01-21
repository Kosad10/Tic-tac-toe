import java.util.*;

public class TicTacToe {
    private final Field field;
    private final Queue<Player> players;


    public TicTacToe(GameOptions gameOptions) {
        this.field = new Field(gameOptions.getSize(), gameOptions.getSizeLine());
        this.players = gameOptions.getPlayers();
    }

    public void startGame() {
        boolean isFinished = false;
        int motion = 0;
        int quantityMotion = ((field.getLength() - 1) * (field.getLength() - 1));
        field.initField();
        while (!isFinished) {
            motion++;
            field.printField();
            Player currentPlayer = players.poll();
            field.setCell(currentPlayer);
            if (field.isWinner(currentPlayer.getName(), currentPlayer.getSymbol())) {
                isFinished = true;
            }
            players.add(currentPlayer);
            if (motion == quantityMotion) {
                System.out.println("Ничья");
                break;
            }
        }

    }
}

