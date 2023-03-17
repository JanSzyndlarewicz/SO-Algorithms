import java.io.Serializable;

public class Process implements Serializable {

    private static int countProcesses = 0;
    private final int ID;
    private final int LENGTH;
    private int lengthLeft;
    private int waitingTime;
    private int finishTime;
    private final int FILLING_TIME;


    public Process(int LENGTH, int FILLING_TIME){
        this.ID = countProcesses;
        this.LENGTH = LENGTH;
        this.lengthLeft = LENGTH;
        this.waitingTime = 0;
        this.finishTime = 0;
        this.FILLING_TIME = FILLING_TIME;
        countProcesses++;
    }


    public static int getCountProcesses() {
        return countProcesses;
    }

    public static void setCountProcesses(int countProcesses) {
        Process.countProcesses = countProcesses;
    }

    public int getID() {
        return ID;
    }

    public int getLENGTH() {
        return LENGTH;
    }

    public int getLengthLeft() {
        return lengthLeft;
    }

    public void setLengthLeft(int lengthLeft) {
        this.lengthLeft = lengthLeft;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public int getFILLING_TIME() {
        return FILLING_TIME;
    }

    @Override
    public String toString() {
        return "Process{" +
                "ID=" + ID +
                ", LENGTH=" + LENGTH +
                ", lengthLeft=" + lengthLeft +
                ", waitingTime=" + waitingTime +
                ", finishTime=" + finishTime +
                ", FILLING_TIME=" + FILLING_TIME +
                '}';
    }
}
