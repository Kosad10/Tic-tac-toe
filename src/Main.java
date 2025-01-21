public class Main {


    public static void main(String[] args) {
        GameOptions gameOptions = new TestOptions();
        TicTacToe ticTacToe = new TicTacToe(gameOptions);
        ticTacToe.startGame();
    }
}