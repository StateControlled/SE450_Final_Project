package main.java.edu.depaul.item;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import main.java.edu.depaul.item.factory.SuperFactory;

/**
 * This class ensures that GSON can read an arbitrary item from a {@code .json} file and return a valid object.
 * Since Abstract classes cannot be instantiated, the {@code read} method must store field data and call a factory method.
 **/
public class ItemAdapter extends TypeAdapter<AbstractItem> {

    @Override
    public AbstractItem read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        in.beginObject();
        String fieldName = null;
        String fieldCategory = null;
        String fieldItemType = null;
        String fieldItemName = null;
        String fieldManufacturer = null;
        double fieldPrice = 0.0;

        while (in.hasNext()) {
            JsonToken token = in.peek();
            if (token.equals(JsonToken.NAME)) {
                fieldName = in.nextName();
            }
            if (fieldName.equals("category")) {
            	token = in.peek();
            	fieldCategory = in.nextString();
            } else if (fieldName.equals("itemType")) {
            	token = in.peek();
            	fieldItemType = in.nextString();            	
            } else if (fieldName.equals("itemName")) {
            	token = in.peek();
            	fieldItemName = in.nextString();            	
            } else if (fieldName.equals("manufacturer")) {
            	token = in.peek();
            	fieldManufacturer = in.nextString();            	
            } else if (fieldName.equals("price")) {
            	token = in.peek();
            	fieldPrice = in.nextDouble();           	
            }
        }
        in.endObject();
        return SuperFactory.createProduct(fieldCategory, fieldItemType, fieldItemName, fieldManufacturer, fieldPrice);
    }

    @Override
    public void write(JsonWriter out, AbstractItem value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
    }

    
}
