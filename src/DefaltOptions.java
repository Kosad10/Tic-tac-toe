import java.util.LinkedList;
import java.util.Queue;

public class DefaltOptions implements GameOptions{
    private Queue<Player> players;
    private Player player1;
    private Player player2;

    public DefaltOptions () {
        this.players = new LinkedList<>();
        this.player1 = new HumanPlayer("Player 1", "X");
        this.player2 = new ComputerPlayer("Player 2", "O");
        getPlayers().add(player1);
        getPlayers().add(player2);
    }

    @Override
    public int getSizeLine() {
        return 3;
    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public Queue<Player> getPlayers() {
        return players;
    }
}
