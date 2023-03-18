import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();
        SRTF srtf = new SRTF();

        //ArrayList<Process> queue = QueueLibrary.generateQueue(5, 1);
        ProcessQueue processQueue = new ProcessQueue();
        QueueLibrary.generateSimulation(processQueue,2);
        //processQueue.addArrayList(queue);
        Serialization.serialize(processQueue);

        QueueLibrary.doFromFile(fcfs);
        QueueLibrary.doFromFile(sjf);
        QueueLibrary.doFromFile(srtf);

        //QueueLibrary.printQueue(queue);
        //SRTF.doSRTF(queue);
        //QueueLibrary.printQueue(queue);
        //System.out.println(Serialization.deserialize().getProcessArrayList().get(0));
        //SJF.doSJF(queue);
        //QueueLibrary.printQueue(queue);


    }
}