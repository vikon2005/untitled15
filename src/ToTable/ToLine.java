package ToTable;
//Класс ToLine
//
//Этот класс работает наоборот, то есть из двумерного массива делает одномерный.
//
//В этом классе реализуйте:
//
//поле data (двумерный массив);
//конструктор, инициализирующий данное поле (data);
//метод resize(), возвращающий одномерный список.
//Пример:
//
//ToLine a = new ToLine(new int[][] {{1, 2}, {3, 4}, {5, 6}});
//int[] arr = a.resize();
//В поле arr должен попасть массив вида: [1, 2, 3, 4, 5, 6].

public class ToLine {
    class ToLine {
        int[][] data;

        public ToLine(int[][] data) {

            this.data = data;
        }

        int[] resize() {
            // склеиваем двумерный массив в один при помощи start
            int[] res = new int[data.length * data[0].length];
            int start = 0;
            for (int[] datum : data) {
                for (int j = 0; j < datum.length; j++) {
                    res[start + j] = datum[j];
                }
                start += datum.length;
            }
            return res;
        }
    }
}
