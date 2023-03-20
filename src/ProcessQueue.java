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

}
