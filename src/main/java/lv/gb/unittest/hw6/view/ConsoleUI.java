package lv.gb.unittest.hw6.view;

import lv.gb.unittest.hw6.model.Average;
import lv.gb.unittest.hw6.model.ListOfNumbers;

public class ConsoleUI implements View{
    Average average;
    ListOfNumbers l1;
    ListOfNumbers l2;

    public ConsoleUI(){
        this.average = new Average();
        this.l1 = new ListOfNumbers();
        this.l2 = new ListOfNumbers();
    }

    @Override
    public void execute() {
        Integer[] array1 = {47, 37, 63, 54, 4};
        Integer[] array2 = {95, 41, 80, 82, 68};
        l1.setNumberList(array1);
        l2.setNumberList(array2);
        average.largerAverageOfList(l1,l2);
    }

    @Override
    public String getAnswer() {
        StringBuilder st = new StringBuilder();
        if (l1.getSize() == 0 || l2.getSize() == 0||average.getAverage()==0.0){
            st.append("No data");
        }else {
            st.append(average.largerAverageOfList(l1, l2));
        }
        return st.toString();
    }
}
