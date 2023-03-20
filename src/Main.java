import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        ProcessQueue processQueue = new ProcessQueue();
        QueueLibrary.generateSimulation(processQueue,50, 100);
        Serialization.serialize(processQueue);
        QueueLibrary.doAllFromFile();



    }
}