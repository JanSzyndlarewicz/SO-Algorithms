import java.util.ArrayList;

public class SJF implements Algorithm{

    private static int realTime;

    public SJF() {}

    @Override
    public void doAlgorithm(ArrayList<Process> queueList){
        realTime = 0;
        int iterator = 0;
        Process currentProcess;

        do{
            currentProcess = findSmallest(queueList);

            //System.out.println("Test -> " + currentProcess);

            if(currentProcess != null){
                currentProcess.setWaitingTime(realTime - currentProcess.getFILLING_TIME());
                currentProcess.setLengthLeft(0);
                realTime += currentProcess.getLENGTH();
                currentProcess.setFinishTime(realTime);

                iterator++;
            }
            else
                realTime++;

        }while (iterator < queueList.size());
    }

    public static Process findSmallest(ArrayList<Process> list){
        Process smallest = null;
        int realTimeBorder = 0;

        while (realTimeBorder<list.size() && list.get(realTimeBorder).getFILLING_TIME()<= realTime){
            if(list.get(realTimeBorder).getLengthLeft() != 0) {
                if (smallest == null || smallest.getLengthLeft() > list.get(realTimeBorder).getLengthLeft())
                    smallest = list.get(realTimeBorder);
            }
            realTimeBorder++;
        }

        return smallest;
    }
}
