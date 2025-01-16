import java.util.LinkedList;
import java.util.Queue;

public class TestOptions implements GameOptions {
    private Queue<Player> players;
    private Player player1;

    public TestOptions() {
        this.players = new LinkedList<>();
        this.player1 = new HumanPlayer("Nastya", "X");
        players.add(player1);
    }
    @Override
    public int getSizeLine() {
        return 3;
    }

    @Override
    public int getSize() {
        return 8;
    }

    @Override
    public Queue<Player> getPlayers() {
        return players;
    }
}
