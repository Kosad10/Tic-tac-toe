import java.util.Random;

public class ComputerPlayer extends Player {
    private Random num;
    public ComputerPlayer(String name, String symbol) {
        super(name, symbol);
        this.num = new Random();
    }

    @Override
    public int[] getCords() {
        int x = num.nextInt(1,4);
        int y = num.nextInt(1,4);
        int[] turn = {x,y};
        return turn;
    }
}
