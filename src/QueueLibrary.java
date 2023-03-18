import java.util.ArrayList;
import java.util.Random;

public class QueueLibrary {
    public static ArrayList<Process> generateQueue(int lengthQueue, int queueId){
        Random random = new Random();
        ArrayList<Process> queue = new ArrayList<>();

        for(int i=0; i<lengthQueue; i++){
            int length;
            int entryTime;

            length = random.nextInt(1, 40);

            entryTime = (i<lengthQueue/4) ? 0 : random.nextInt(queue.get(queue.size()-1).getFILLING_TIME(), queue.get(queue.size()-1).getFILLING_TIME() + 30);

            Process newProcess = new Process(length, entryTime);
            queue.add(newProcess);
        }
        return queue;
    }

    public static void printQueue(ArrayList<Process> queue){
        for (Process process : queue) {
            System.out.println(process);
        }
    }

    public static void doFromFile(Algorithm algorithm){
        ProcessQueue processQueue = new ProcessQueue(Serialization.deserialize().getProcessArrayList());

        for(int i=0; i<processQueue.getProcessArrayList().size(); i++){
            algorithm.doAlgorithm(processQueue.getProcessArrayList().get(i));
            System.out.println("\n\n\nKolejka nr: " + i );
            printQueue(processQueue.getProcessArrayList().get(i));
        }
    }

    public static void generateSimulation (ProcessQueue processQueue, int numberOfQueues){
        for(int i=0; i<numberOfQueues; i++){
            processQueue.addArrayList(QueueLibrary.generateQueue(10, i));
        }
    }
}

