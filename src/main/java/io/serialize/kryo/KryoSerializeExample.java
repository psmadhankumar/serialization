package io.serialize.kryo;

import java.io.IOException;

import io.bean.Person;

public class KryoSerializeExample {

	private static final String FILENAME = "kryoserialize.ser";
	
    public static void main(String[] args)   {
    	Person toSerialize = Person.getSamplePerson();
        System.out.println("To serialization:     " + toSerialize);
        
        try {
            KryoSerializeUtil.serialize(toSerialize, FILENAME);
            Person fromDeserialize = (Person) KryoSerializeUtil.deserialize(FILENAME);
            System.out.println("From deserialization: " + fromDeserialize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
