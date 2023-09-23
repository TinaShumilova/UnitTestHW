package lv.gb.unittest.hw3;

public class Numbers {
    private int number;
    private String answer;

    public Numbers(int number) {
        this.number = number;
    }

    public Numbers() {
        this(0);
    }

//    public void setNumber(int number) {
//        this.number = number;
//    }
//
//    public int getNumber() {
//        return number;
//    }

    /**
     * проверяет, является ли переданное число четным или нечетным.
     * @param n
     * @return true or false
     */
    public boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean numberInInterval(int n) {
        if (n>25 && n<100){
            return true;
        }else {
            return false;
        }
    }


}

