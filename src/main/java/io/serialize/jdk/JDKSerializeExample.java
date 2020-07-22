package io.serialize.jdk;

import java.io.IOException;

import io.bean.Person;

public class JDKSerializeExample {

	private static final String FILENAME = "jdkserialize.ser";
	
    public static void main(String[] args)   {
        Person toSerialize = Person.getSamplePerson();
        System.out.println("To serialization:     " + toSerialize);
        
        try {
            JDKSerializeUtil.serialize(toSerialize, FILENAME);
            Person fromDeserialize = (Person) JDKSerializeUtil.deserialize(FILENAME);
            System.out.println("From deserialization: " + fromDeserialize);
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
