package edu.depaul.customer;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * This class ensures that GSON can read an arbitrary item from a {@code .json} file and return a valid object.
 * Since Abstract classes cannot be instantiated, the {@code read} method must store field data and call a specific constructor.
 **/
public class UserAdapter extends TypeAdapter<User> {
	
    @Override
    public User read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        in.beginObject();
        String fieldName = null;
        int fieldID = 0;
        String fieldUsername = null;
        String fieldPassword = null;

        while (in.hasNext()) {
            JsonToken token = in.peek();
            if (token.equals(JsonToken.NAME)) {
                fieldName = in.nextName();
            }
            if (fieldName.equals("customerID")) {
            	token = in.peek();
            	fieldID = in.nextInt();
            } else if (fieldName.equals("name")) {
            	token = in.peek();
            	fieldUsername = in.nextString();            	
            } else if (fieldName.equals("password")) {
            	token = in.peek();
            	fieldPassword = in.nextString();            	
            } else if (fieldName.equals("cart")) {
            	token = in.peek();
            	// Do nothing
            }
        }
        in.endObject();
        return new User(fieldID, fieldUsername, fieldPassword);
    }

    @Override
    public void write(JsonWriter out, User value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.beginObject();
        out.name("customerID");
        out.value(value.getCustomerID());
        out.name("name");
        out.value(value.getName());
        out.name("password");
        out.value(value.getPassword());
        out.endObject();
        return;
    }
}
