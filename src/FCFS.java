import java.util.ArrayList;

public class FCFS {


    public static void doFCFS(ArrayList<Process> queueList){
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
