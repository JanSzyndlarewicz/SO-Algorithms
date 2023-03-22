import java.util.ArrayList;
import java.util.Random;

public class QueueLibrary {

    public static ArrayList<Process> generateQueue(int lengthQueue, int queueId){
        Random random = new Random();
        ArrayList<Process> queue = new ArrayList<>();

        for(int i=0; i<lengthQueue; i++){
            int length;
            int entryTime;

            length = (random.nextInt(0, 50) > queueId) ? random.nextInt(1, 40) : random.nextInt(30, 80);

            entryTime = (i<lengthQueue/4) ? 0 : random.nextInt(queue.get(queue.size()-1).getFILLING_TIME(), queue.get(queue.size()-1).getFILLING_TIME() + 500);

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


    public static void doOneFromFile(Algorithm algorithm, int n){
        ProcessQueue processQueue = new ProcessQueue(Serialization.deserialize().getProcessArrayList());

            algorithm.doAlgorithm(processQueue.getProcessArrayList().get(n));
            printStatistics(processQueue.getProcessArrayList().get(n), algorithm);
    }

    public static void doAllFromFile(){
        ProcessQueue processQueue = new ProcessQueue(Serialization.deserialize().getProcessArrayList());
        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();
        SRTF srtf = new SRTF();
        RR rr = new RR();

        for(int i=0; i<processQueue.getProcessArrayList().size(); i++){
            System.out.println("\nKolejka nr: " + (i+1) );

            doOneFromFile(fcfs, i);
            doOneFromFile(sjf, i);
            doOneFromFile(srtf, i);
            doOneFromFile(rr, i);
        }
    }

    public static void generateSimulation (ProcessQueue processQueue, int numberOfQueues, int queueLength){
        for(int i=0; i<numberOfQueues; i++){
            processQueue.addArrayList(QueueLibrary.generateQueue(queueLength, i));
        }
    }

    public static void printStatistics(ArrayList<Process> processQueue, Algorithm algorithm){
        double avgLength = 0;
        double avgTimeToFinish = 0;
        double avgWaitingTime = 0;
        int longestWaiting = 0;
        final int NUMBER_OF_PROCESSES = processQueue.size();

        for(Process process : processQueue){
            avgLength += process.getLENGTH();
            avgTimeToFinish += process.getFinishTime();
            avgWaitingTime += process.getWaitingTime();
            longestWaiting  = Math.max(longestWaiting, process.getWaitingTime());
        }

        avgLength /= NUMBER_OF_PROCESSES;
        avgTimeToFinish /= NUMBER_OF_PROCESSES;
        avgWaitingTime /= NUMBER_OF_PROCESSES;

        System.out.println(algorithm.getAlgorithmName() + " -> " +
                "avg finishing time: " + avgTimeToFinish +
                ", avg length: " + avgLength +
                ", avg waiting time: " + avgWaitingTime +
                ", longest waiting time: " + longestWaiting);
    }
}

