import java.util.ArrayList;

public class RR implements Algorithm{
    public RR(){};

    @Override
    public void doAlgorithm(ArrayList<Process> queueList){
        int realTime = 0;
        int QUANTUM_TIME = 5;
        int counterOfFinishedProcesses = 0;
        int iterator = 0;

        while (counterOfFinishedProcesses < queueList.size()){

            Process currentProcess = queueList.get(iterator);
            if(currentProcess.getFILLING_TIME() <= realTime && currentProcess.getLengthLeft() != 0){
                //System.out.println("Test -> " + currentProcess);
                if(currentProcess.getLengthLeft()-QUANTUM_TIME <= 0){
                    realTime += currentProcess.getLengthLeft();
                    currentProcess.setLengthLeft(0);
                    currentProcess.setFinishTime(realTime-currentProcess.getFILLING_TIME());
                    counterOfFinishedProcesses++;
                }
                else {
                    currentProcess.setLengthLeft(currentProcess.getLengthLeft()-QUANTUM_TIME);
                    realTime += QUANTUM_TIME;
                }

            }
            else {
                realTime++;
            }

            iterator++;

            if(iterator >= queueList.size()) iterator = 0;

        }
    }

    @Override
    public String getAlgorithmName(){
        return "RR";
    }
}
