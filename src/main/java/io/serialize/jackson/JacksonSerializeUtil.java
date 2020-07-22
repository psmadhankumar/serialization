package io.serialize.jackson;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializeUtil {

    public static void serialize(Object object, String filename) throws IOException {
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	File file = new File(filename);
    	
    	// serialize as json
    	objectMapper.writeValue(file, object);
    }


    public static <T> Object deserialize(String filename, Class<T> clazz) throws IOException {
        
    	ObjectMapper objectMapper = new ObjectMapper();
    	File file = new File(filename);
    	
    	Object object = objectMapper.readValue(file, clazz);
        return object;
    }

}
