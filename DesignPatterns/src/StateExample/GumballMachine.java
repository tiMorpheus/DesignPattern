package StateExample;

public class GumballMachine {


    // Каждое состояние представлено целым числом
    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;


    // а эта переменная для хранения текущего состояния
    int state = SOLD_OUT;
    int countOfGum = 0;

    public GumballMachine(int countOfGum) {
        this.countOfGum = countOfGum;
        if(countOfGum > 0){
            state = NO_QUARTER;
        }
    }

    // когда в автомат кидают монетку
    public void insertQuarter(){
        if(state == HAS_QUARTER){

            System.out.println("You can't insert another quarter");

        } else if(state == NO_QUARTER){

            state = HAS_QUARTER;
            System.out.println("You inserted a quarter");

        } else if(state == SOLD_OUT){

            System.out.println("You can't insert a quarter, the machine is sold out");

        } else if(state == SOLD){

            System.out.println("Please wait, we're already giving you a gumball");
        }
    }

    // когда покупатель хочет вернуть четвертак
    public void ejectQuarter(){
        if(state == HAS_QUARTER){
            System.out.println("Quarter returned");
            state = NO_QUARTER;
        } else if(state == NO_QUARTER){
            System.out.println("You haven't inserted a quarter");
        } else if(state == SOLD){
            System.out.println("Sorry, you already turned the crank");
        } else if(state == SOLD_OUT){
            System.out.println("You can't eject, you haven't inserted a quarter yet");
        }
    }


    public void turnCrank(){
        if (state == SOLD){
            System.out.println("Turning twice doesn't get you another gumball");
        } else  if(state == NO_QUARTER){
            System.out.println("You turned but there's no quarter");
        } else  if(state == SOLD_OUT){
            System.out.println("You turned but there are no gumballs");
        } else  if(state == HAS_QUARTER){
            System.out.println("You turned...");
            state = SOLD;
            dispense();
        }
    }

    // вызывается для выдачи шарика
    public void dispense(){
        if (state == SOLD){

            System.out.println("A gumball comes rolling out of slot");
            countOfGum--;
            if(countOfGum == 0 ){
                System.out.println("Oops, out of gumballs!");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else  if(state == NO_QUARTER){
            System.out.println("You need to pay first");
        } else  if(state == SOLD_OUT){
            System.out.println("No gumball dispensed");
        } else  if(state == HAS_QUARTER){
            System.out.println("No gumball dispensed");
        }
    }

    public void refill(int numGumBalls) {
        this.countOfGum = numGumBalls;
        state = NO_QUARTER;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004\n");
        result.append("Inventory: " + countOfGum + " gumball");
        if (countOfGum != 1) {
            result.append("s");
        }
        result.append("\nMachine is ");
        if (state == SOLD_OUT) {
            result.append("sold out");
        } else if (state == NO_QUARTER) {
            result.append("waiting for quarter");
        } else if (state == HAS_QUARTER) {
            result.append("waiting for turn of crank");
        } else if (state == SOLD) {
            result.append("delivering a gumball");
        }
        result.append("\n");
        return result.toString();
    }


}