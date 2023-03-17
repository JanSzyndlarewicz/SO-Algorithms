import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {



        ArrayList<Process> queue = QueueLibrary.generateQueue(5, 1);
        ProcessQueue processQueue = new ProcessQueue();
        processQueue.addArrayList(queue);
        Serialization.serialize(processQueue);

        QueueLibrary.printQueue(queue);
        SRTF.doSRTF(queue);
        QueueLibrary.printQueue(queue);
        //System.out.println(Serialization.deserialize().getProcessArrayList().get(0));
        //SJF.doSJF(queue);
        //QueueLibrary.printQueue(queue);


    }
}