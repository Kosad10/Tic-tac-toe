import java.util.*;

public class TicTacToe {
    private Field field;
    private Queue<Player> players;


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

    public void doTurn (Player player) {
        String symbol = player.getSymbol();
        int[] cords = player.getCords();
        boolean setCellDoing = field.setCell(symbol, cords);
        while (!setCellDoing) {
            setCellDoing = field.setCell(symbol, cords);
            field.setCell(symbol, cords);
        }
    }
}

