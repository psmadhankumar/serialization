package io.serialize.kryo;

import java.io.*;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class KryoSerializeUtil {

    public static void serialize(Object object, String filename) throws IOException {
    	
        //Saving of object in a file
        FileOutputStream fos = new FileOutputStream(filename);
        Output output = new Output(fos);
        
        Kryo kryo = new Kryo();
        // serialize
        kryo.writeClassAndObject(output, object);
        
        output.close();
        fos.close();
    }


    public static Object deserialize(String filename) throws IOException {
        
    	// Reading the object from a file
        FileInputStream fis = new FileInputStream(filename);
        Input input = new Input(fis);
        
        Kryo kryo = new Kryo();
        
        //deserialize
        Object object = kryo.readClassAndObject(input);
        
        input.close();
        fis.close();
        
        return object;
    }

}
