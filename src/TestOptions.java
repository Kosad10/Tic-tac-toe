import java.util.LinkedList;
import java.util.Queue;

public class TestOptions implements GameOptions {
    private Queue<Player> players;
    private Player player1;
    private final Player player2;

    public TestOptions() {
        this.players = new LinkedList<>();
        this.player1 = new HumanPlayer("Nastya", "X");
        this.player2 = new HumanPlayer("Comp", "O");
        players.add(player1);
        players.add(player2);
    }
    @Override
    public int getSizeLine() {
        return 3;
    }

    @Override
    public int getSize() {
        return 6;
    }

    @Override
    public Queue<Player> getPlayers() {
        return players;
    }
}
