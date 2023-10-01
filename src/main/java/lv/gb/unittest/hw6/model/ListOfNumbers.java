package lv.gb.unittest.hw6.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListOfNumbers {
    private List<Integer> numberList;

    public ListOfNumbers(){
        numberList= new ArrayList<>();
    }
    public ListOfNumbers(Integer[] numberLis){
        this.numberList = Arrays.asList(numberLis);
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setNumberList(Integer[] numberList) {
        this.numberList = Arrays.asList(numberList);

    }

    public List<Integer> randomSetList(int size){
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(100);
            numberList.add(num);
        }
        return numberList;
    }

    public int getSize(){
        return numberList.size();
    }
    public String getInfo(){
        StringBuilder st = new StringBuilder();
        st.append("List of numbers: ");
        for (Integer integer : numberList) {
            st.append(integer);
            st.append(", ");
        }
        return st.toString();
    }

}
