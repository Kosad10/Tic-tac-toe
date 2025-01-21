public class Field {
    private final String[][] field;
    private final int countToWin;


    public Field(int size, int countToWin) {
        this.field = new String[size][size];
        this.countToWin = countToWin;
    }

    public void initField() {
        int number = 1;
        field[0][0] = " ";
        for (int i = 1; i < field.length; i++) {
            String strNumber = String.valueOf(number++);
            field[0][i] = strNumber;
            field[i][0] = strNumber;
        }
        for (int i = 1; i < field.length; i++) {
            for (int j = 1; j < field.length; j++) {
                field[i][j] = "-";
            }
        }
    }

    public void printField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isCellTaken(int x, int y) {
        return (!field[x][y].equals("-"));
    }

    public void setCell(Player player) {
        while (true) {
            String symbol = player.getSymbol();
            int[] turn = player.getCords();
            try {
                isCellTaken(turn[0], turn[1]);
            } catch (RuntimeException outOfBound) {
                System.out.println("Значение выходит из диапазона допустимых");
                continue;
            }
            if (isCellTaken(turn[0], turn[1])) {
                System.out.println("Клетка уже занята");
                continue;
            }
            field[turn[0]][turn[1]] = symbol;
            return;
        }
    }

    public boolean isWinner(String name, String symbol) {
        int vertical = 0;
        int horizontal = 0;
        int forwardSlash = 0;
        for (int i = 1; i < field.length; i++) {
            for (int j = 1; j < field.length; j++) {
                if (field[i][j].equals(symbol)) {
                    vertical++;
                } else {
                    vertical = 0;
                }
                if (vertical == countToWin) {
                    System.out.println("Игрок " + name + " выиграл");
                    return true;
                }
            }
            vertical = 0;
        }


        for (int i = 1; i < field.length; i++) {
            for (int j = 1; j < field.length; j++) {
                if (field[j][i].equals(symbol)) {
                    horizontal++;
                } else {
                    horizontal = 0;
                }
                if (horizontal == countToWin) {
                    System.out.println("Игрок " + name + " выиграл");
                    return true;
                }
            }
            horizontal = 0;
        }
        int maxDiffLeft = field.length - countToWin;
        int xyLeft = 0;
        int yxLeft = 0;
        for (int diff = 0; diff < maxDiffLeft; diff++) {
            for (int i = 1; i < field.length - diff; i++) {
                int x = i + diff;
                int y = i;
                if (field[x][y].equals(symbol)) {
                    xyLeft++;
                } else {
                    xyLeft = 0;
                }
                if (field[y][x].equals(symbol)) {
                    yxLeft++;
                } else {
                    yxLeft = 0;
                }
                if (xyLeft == countToWin || yxLeft == countToWin) {
                    System.out.println("Игрок " + name + " выиграл");
                    return true;
                }
            }
        }

        int maxDiffRight = field.length - countToWin;
        for (int diff = 0; diff < maxDiffRight; diff++) {
            for (int i = 1; i < field.length - diff; i++) {
                int x = (field.length - diff) - i;
                int y = i;
                if (field[x][y].equals(symbol)) {
                    forwardSlash++;
                } else {
                    forwardSlash = 0;
                }
                if (forwardSlash == countToWin) {
                    System.out.println("Игрок " + name + " выиграл");
                    return true;
                }
            }
        }
        return false;
    }

    public int getLength() {
        return field.length;
    }
}
