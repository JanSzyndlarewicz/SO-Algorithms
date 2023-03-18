import java.io.Serializable;
import java.util.ArrayList;

public class ProcessQueue implements Serializable {
    private ArrayList<ArrayList<Process>> processArrayList = new ArrayList<>();

    public ProcessQueue(){
    }

    public ProcessQueue(ArrayList<ArrayList<Process>> processArrayList){
        this.processArrayList = processArrayList;
    }

    public void addArrayList(ArrayList<Process> processArrayList){
        this.processArrayList.add(processArrayList);
    }

    public ArrayList<ArrayList<Process>> getProcessArrayList() {
        return processArrayList;
    }

    public void generateSimulation (int numberOfQueues){
        for(int i=0; i<numberOfQueues; i++){
            processArrayList.add(QueueLibrary.generateQueue(10, i));
        }
    }



}
