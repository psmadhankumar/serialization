package io.serialize.jackson;

import java.io.IOException;

import io.bean.Person;

public class JacksonSerializeExample {

	private static final String FILENAME = "jacksonserialize.ser";
	
    public static void main(String[] args)   {
    	Person toSerialize = Person.getSamplePerson();
        System.out.println("To serialization:     " + toSerialize);
        
        try {
            JacksonSerializeUtil.serialize(toSerialize, FILENAME);
            Person fromDeserialize = (Person) JacksonSerializeUtil.deserialize(FILENAME, Person.class);
            System.out.println("From deserialization: " + fromDeserialize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
