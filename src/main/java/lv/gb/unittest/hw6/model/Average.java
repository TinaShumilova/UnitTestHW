package lv.gb.unittest.hw6.model;

public class Average extends ListOfNumbers {
    private double average;

    public double getAverage() {
        return average;
    }

    public double findAverage(ListOfNumbers list) {
        double sum = 0;
        for (int i = 0; i < list.getSize(); i++) {
            sum += list.getNumberList().get(i);
        }
        average = sum / list.getSize();
        return average;
    }

    public String largerAverageOfList(ListOfNumbers list1, ListOfNumbers list2) {
        double av1 = findAverage(list1);
        double av2 = findAverage(list2);
        if (av1 >av2) {
            return "Первый список имеет большее среднее значение";
        } else if (av1 == av2) {
            return "Средние значения равны";
        } else {
            return "Второй список имеет большее среднее значение";
        }
    }


}
