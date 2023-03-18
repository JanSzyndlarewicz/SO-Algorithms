import java.util.ArrayList;

public class FCFS implements Algorithm{
    public FCFS() {
    }

    @Override
    public void doAlgorithm(ArrayList<Process> queueList){
        int realTime = 0;

        for (Process currentProcess : queueList) {
            if (realTime < currentProcess.getFILLING_TIME())
                realTime = currentProcess.getFILLING_TIME();

            currentProcess.setWaitingTime(realTime - currentProcess.getFILLING_TIME());
            currentProcess.setLengthLeft(0);
            realTime += currentProcess.getLENGTH();
            currentProcess.setFinishTime(realTime);
        }
    }

}
