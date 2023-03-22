import java.util.ArrayList;

public class SRTF implements Algorithm{

    public SRTF() {}

    private static int realTime;

    @Override
    public void doAlgorithm(ArrayList<Process> queueList){
        realTime = 0;
        int iterator = 0;
        Process currentProcess;

        do{
            currentProcess = findSmallest(queueList);

            //System.out.println("Test -> " + currentProcess);

            if(currentProcess != null){

                //if(currentProcess.getWaitingTime() == 0) currentProcess.setWaitingTime(-1*currentProcess.getFILLING_TIME());
                currentProcess.setWaitingTime(realTime  + currentProcess.getWaitingTime() - currentProcess.getFinishTime());
                realTime++;
                currentProcess.setLengthLeft(currentProcess.getLengthLeft()-1);


                if(currentProcess.getLengthLeft() == 0) {
                    currentProcess.setWaitingTime(currentProcess.getWaitingTime()-currentProcess.getFILLING_TIME());
                    currentProcess.setFinishTime(realTime-currentProcess.getFILLING_TIME());
                }else {
                    currentProcess.setFinishTime(realTime);
                }



                if(currentProcess.getLengthLeft()==0)
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


    @Override
    public String getAlgorithmName(){
        return "SRTF";
    }
}
