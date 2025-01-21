import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConsoleOptions implements GameOptions{
    private Scanner scanner;
    private int getSizeLine;
    private int getSize;
    private String name;
    private String symbol;
    private Queue<Player> players;

    public ConsoleOptions() {
        this.scanner = new Scanner(System.in);
        this.players = new LinkedList<>();
        System.out.println("Введите количество игроков: ");
        int quantityPlayers = scanner.nextInt();
        int loop = 0;
        while (loop != quantityPlayers){
            loop++;
            System.out.println("Введите код игрока: 1 - Человек; 2 - Компьютер.");
            int playersHumOrComp = scanner.nextInt();
            if (playersHumOrComp == 1) {
                System.out.println("Введите имя: ");
                name = scanner.next();
                System.out.println("Введите символ: ");
                symbol = scanner.next();
                players.add(new HumanPlayer(name, symbol));
            }
            if (playersHumOrComp == 2) {
                System.out.println("Введите имя: ");
                name = scanner.next();
                System.out.println("ВВедите символ: ");
                symbol = scanner.next();
                players.add(new ComputerPlayer(name, symbol));
            }
        }
        System.out.println("Введите размер поля: ");
        this.getSize = scanner.nextInt();
        System.out.println("Введите колличество символов для победы: ");
        this.getSizeLine = scanner.nextInt();
    }

    @Override
    public int getSizeLine() {
        return getSizeLine;
    }

    @Override
    public int getSize() {
        return getSize;
    }

    @Override
    public Queue<Player> getPlayers() {
        return players;
    }
}
