package edu.depaul.item;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import edu.depaul.item.factory.SuperFactory;

public class ItemAdapter extends TypeAdapter<AbstractItem> {

    @Override
    public AbstractItem read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        in.beginObject();
        //@SuppressWarnings("unused") // for fieldname
        String fieldName;
        String[] temp = new String[5];
        int i = 0;

        while (in.hasNext()) {
            JsonToken token = in.peek();
            if (token.equals(JsonToken.NAME)) {
                fieldName = in.nextName();
            }
            temp[i++] = in.nextString();
            
        }
        in.endObject();
        return SuperFactory.createProduct(temp[0], temp[1], temp[2], temp[3], Double.parseDouble(temp[4]));
        //AbstractItem i = new AbstractItem(Category.INSTRUMENT, "test", "test", "test", 1.0);
        //return new Violin(Category.INSTRUMENT, "test", "test", "test", 1.0);

    }

    @Override
    public void write(JsonWriter out, AbstractItem value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
    }

    
}
