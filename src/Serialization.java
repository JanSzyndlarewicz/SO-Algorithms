
import java.io.*;
import java.util.HashMap;

public abstract class Serialization {

    public static void serialize(ProcessQueue processQueue){
        try (ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("Serialization.ser"))) {
            so.writeObject(processQueue);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ProcessQueue deserialize(){
        ProcessQueue deserialized = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Serialization.ser"))) {
            deserialized = (ProcessQueue) is.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return deserialized;
    }

}