package java;
//Напишите класс LimitingRectangle (ограничивающий точки прямоугольник), класс принимает точки на плоскости и строит прямоугольник. Если точка лежит на границе прямоугольника, то считаем, что она в него входит.
//
//В нем должны быть:
//
//поле points (двумерный массив целых чисел);
//конструктор, принимающий двумерный массив целых чисел (массив точек на плоскости вида [[1, 0], [2, 3], ...], 0 элемент — координата по оси X, 1 элемент — по оси Y);
//метод getWidth(), возвращающий целое число (ширину прямоугольника);
//метод getHeight(), возвращает целое число (высоту прямоугольника);
//метод getBorders, возвращает строку вида {нижняя точка по Y, верхняя точка по Y, левая точка по Х, правая точка по Х}.
//Пример:
//
//LimitingRectangle r = new LimitingRectangle(new int[][] {{-1, -2}, {3, 4}});
//System.out.println(r.getWidth() +   + r.getHeight());
//System.out.println(r.getBorders());
//Вывод:
//
//4 6
//-2, 4, -1, 3
//Примечания
//
//На вход может приходить не только 2 пары точек, но и больше.
//В приходящем массиве точек [[1, 0], [2, 3], ...] в скобках лежат просто отдельные координаты для X и для Y, а не координаты одной точки (по X и Y).
//Прямоугольник можно построить по двум точкам (min и max).
//Задача 7 (Внешний источник)
//(Максимум баллов: 1.0)

public class LimitingRectangle {
    int[][] points;

    public LimitingRectangle(int[][] points) {
        this.points = points;
    }

    // searching min point
    int min(int ind) {
        int min = 10000;
        for (int i = 0; i < points.length; i++) {
            if (points[i][ind] <= min) min = points[i][ind];
        }
        return min;
    }
    // searching max point
    int max(int ind) {
        int max = -10000;
        for (int i = 0; i < points.length; i++) {
            if (points[i][ind] >= max) max = points[i][ind];
        }
        return max;
    }

    int getWidth() {
        return this.max(0) - this.min(0);
    }

    int getHeight() {
        return this.max(1) - this.min(1);
    }

    String getBorders() {
        return this.min(1) + ", " + this.max(1) + ", " + this.min(0) + ", " + this.max(0);
    }
}
}
