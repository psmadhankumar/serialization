package io.serialize.jdk;

import java.io.*;

public class JDKSerializeUtil {

    public static void serialize(Object object, String filename) throws IOException {

        //Saving of object in a file
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(file);

        // serialize
        out.writeObject(object);

        out.close();
        file.close();
    }


    public static Object deserialize(String filename) throws IOException, ClassNotFoundException {
        // Reading the object from a file
        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(file);

        // deserialize
        Object object = in.readObject();

        in.close();
        file.close();

        return object;
    }

}
