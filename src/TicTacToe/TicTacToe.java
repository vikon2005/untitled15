package TicTacToe;
//Напишите класс TicTacToe (крестики-нолики).
//
//В этом классе должны быть следующие методы:
//
//newGame() — ничего не возвращающий метод, должен создать новую игру;
//getField() — метод должен вернуть двумерный массив — поле игры;
//checkGame() — метод должен определить есть ли победитель в игре, если да, то вернуть X/0 в зависимости от того, кто победил, если победителя нет, то метод должен вернуть D (ничья), если игра ещё продолжается, то вернуть строку null;
//makeMove(int x, int y), принимающий два параметра — ряд и столбик, куда игрок хочет сделать ход. Если ход невозможен (клетка уже занята), то метод должен вернуть строку вида {Cell x, y is already occupied}. Если же ход возможен, то в поле следует поставить X или 0 (зависит от того, кто сейчас ходил), и вернуть строку Move completed, если после этого хода игра не заканчивается. Если же этим ходом победил один из игроков, то метод должен вернуть строку вида {Player X/0 won}. Если же после этого хода свободных клеток не осталось, а победителя нет, то метод должен вернуть Draw. Если игра уже завершена (выявлен победитель или ничья), но кто-то хочет походить дальше, то метод должен вернуть Game was ended.
//Примечание:
//Первым всегда ходит игрок X, потом 0.
//
//Поле представляет собой двумерный список строк вида:
//Поле представляет собой двумерный список строк вида:
        [
        [-, -, -],
        [-, -, -],
        [-, -, -]
        ]
        Также пустые поля стоит отмечать -.

        Пример:

        TicTacToe board = new TicTacToe();
        *Выводим поле в консоль, используя метод getField();
        System.out.println(board.makeMove(1, 1));
        *Выводим поле в консоль, используя метод getField();
        System.out.println(board.makeMove(1, 1));
        System.out.println(board.makeMove(1, 2));
        *Выводим поле в консоль, используя метод getField();
        System.out.println(board.makeMove(2, 1));
        System.out.println(board.makeMove(2, 2));
        System.out.println(board.makeMove(3, 1));
        System.out.println(board.makeMove(2, 2));
        *Выводим поле в консоль, используя метод getField();
        Вывод:

        ['-', '-', '-']
        ['-', '-', '-']
        ['-', '-', '-']
        Move completed
        ['X', '-', '-']
        ['-', '-', '-']
        ['-', '-', '-']
        Cell x, y is already occupied
        Move completed
        ['X', '0', '-']
        ['-', '-', '-']
        ['-', '-', '-']
        Move completed
        Move completed
        Player X won
        Game was ended
        ['X', '0', '-']
        ['X', '0', '-']
        ['X', '-', '-']//

public class TicTacToe {
    String[][] field;
    String nowPlayer;

    public TicTacToe() {
        // создаем новую игру
        newGame();
    }

    void newGame() {
        // пересоздаем игру
        field = new String[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        nowPlayer = "X";
    }

    String[][] getField() {
        return field;
    }

    String makeMove(int x, int y) {
        x -= 1;
        y -= 1;
        // проверяем ситуацию на поле
        String check = this.checkGame();

        // если не вернулось null, значит игра уже завершена (см checkField())
        if (check != null) return "Game was ended";

        // если клетка занята
        if (!field[x][y].equals("-")) return "Cell " + (x + 1) + ", " + (y + 1) + " is already occupied";

        // если же нет, то ставим X/0 и проверяем, что стало с полем после этого хода
        field[x][y] = nowPlayer;
        check = checkGame();

        // если не вернулось null, значит этот ход завершил игру
        if (check != null) {
            if (check.equals("X")) return "Player X won";
            else if (check.equals("0")) return "Player 0 won";
            else return "Draw";
        }

        // иначе переключаем игрока на следующего
        nowPlayer = nowPlayer.equals("X") ? "0" : "X";
        return "Move completed";
    }

    String checkGame() {
        // проверяем, есть ли 3 выставленных в ряд крестика или нолика
        for (int i = 0; i < 3; i++) {
            boolean check = true;
            for (int j = 0; j < 3; j++) {
                if (field[i][j].equals("0") || field[i][j].equals("-")) check = false;
            }
            if (check) return "X"; // если нашли 3 Х в ряд, то победа за Х
        }
        // тоже самое для 0
        for (int i = 0; i < 3; i++) {
            boolean check = true;
            for (int j = 0; j < 3; j++) {
                if (field[i][j].equals("X") || field[i][j].equals("-")) check = false;
            }
            if (check) return "0"; // если нашли 3 0 в ряд, то победа за 0
        }

        // проверяем, есть ли 3 выставленных в столбик крестика или нолика
        for (int i = 0; i < 3; i++) {
            boolean check = true;
            for (int j = 0; j < 3; j++) {
                if (field[j][i].equals("0") || field[j][i].equals("-")) check = false;
            }
            if (check) return "X"; // если нашли 3 Х в столбик, то победа за Х
        }
        // тоже самое для 0
        for (int i = 0; i < 3; i++) {
            boolean check = true;
            for (int j = 0; j < 3; j++) {
                if (field[j][i].equals("X") || field[j][i].equals("-")) check = false;
            }
            if (check) return "0"; // если нашли 3 0 в столбик, то победа за 0
        }


        // проверяем диагонали
        String[] diagonal = {field[0][0], field[1][1], field[2][2]};
        String[] diagonal2 = {field[0][2], field[1][1], field[2][0]};

        boolean check = true;
        for (int i = 0; i < 3; i++) {
            if (diagonal[i].equals("0") || diagonal[i].equals("-")) check = false;
        }
        if (check) return "X"; // если не нашли 0 в диагонали то победа за Х
        else {                 // иначе все тоже самое для 0
            check = true;
            for (int i = 0; i < 3; i++) {
                if (diagonal[i].equals("X") || diagonal[i].equals("-")) check = false;
            }
            if (check) return "0"; // если в диагонали только 0, то за ними победа
        }

        // аналогично для 2 ой диагонали
        check = true;
        for (int i = 0; i < 3; i++) {
            if (diagonal2[i].equals("0") || diagonal2[i].equals("-")) check = false;
        }
        if (check) return "X"; // если не нашли 0 в диагонали то победа за Х
        else {                 // иначе все тоже самое для 0
            check = true;
            for (int i = 0; i < 3; i++) {
                if (diagonal2[i].equals("X") || diagonal2[i].equals("-")) check = false;
            }
            if (check) return "0"; // если в диагонали только 0, то за ними победа
        }

        // если никто не победил
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j].equals("-")) return null; // если еще есть пустые поля, то игра продолжается
            }
        }
        return "D"; // иначе возвращаем ничью
    }
}