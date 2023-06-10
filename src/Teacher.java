import java.util.Random;

public class Teacher {
    int numberOne, numberTwo;
    String operator = "";
    boolean right;

    public int giveNumberOne(int n) {
        Random random = new Random();
        numberOne = random.nextInt(n + 1);
        return numberOne;
    }

    public int giveNumberTwo(int n) {
        Random random = new Random();
        numberTwo = random.nextInt(n + 1);
        return numberTwo;
    }

    public String giveOperator() {
        double d = Math.random();
        if (d > 0.75)
            operator = "+";
        else if (d > 0.5)
            operator = "-";
        else if (d > 0.25)
            operator = "*";
        else
            operator = "/";
        return operator;
    }

    public boolean getRight(int answer) {
        if (operator.equals("+")) {
            if (answer == (numberOne + numberTwo))
                right = true;
            else
                right = false;
        } else if (operator.equals("-")) {
            if (answer == (numberOne - numberTwo))
                right = true;
            else
                right = false;
        } else if (operator.equals("*")) {
            if (answer == (numberOne * numberTwo))
                right = true;
            else
                right = false;
        } else if (operator.equals("/")) {
            if (answer == (numberOne / numberTwo))
                right = true;
            else
                right = false;
        }
        return right;
    }
}
