import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;


    public HumanPlayer(String name, String symbol) {
        super(name, symbol);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int[] getCords() throws RuntimeException {
        System.out.println("Введите координаты: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] turn = {x,y};
        return turn;
    }
}
