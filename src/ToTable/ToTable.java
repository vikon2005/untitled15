package ToTable;
//Напишите два класса: ToTable и ToLine.
//
//Класс ToTable
//
//Этот класс должен превращать одномерный массив чисел в таблицу (двумерный массив чисел x на y).
//
//В этом классе реализуйте:
//
//поле data (одномерный массив);
//поле x ( число);
//поле y (число);
//конструктор, инициализирующий данные поля (data, x, y);
//метод resize(), возвращающий двумерный список x на y.
//Пример:
//
//ToTable a = new ToTable(new int[] {1, 2, 3, 4, 5, 6}, 3, 2);
//int[][] arr = a.resize();
//В поле arr должен попасть массив вида: [[1, 2], [3, 4], [5, 6]].

public class ToTable {

class ToTable {
    int[] data;
    int x, y;

    public ToTable(int[] data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
    }

    int[][] resize() {
        // склеиваем двумерный массив в один при помощи start
        int[][] res = new int[x][y];
        int start = 0;
        for (int i = 0; i < x; i++) {
            for (int j = start; j < start + y; j++) {
                res[i][j - start] = data[j];
            }
            start += y;
        }
        return res;
    }
}