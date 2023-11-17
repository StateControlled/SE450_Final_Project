package main.java.edu.depaul.item;

import java.util.ArrayList;

import main.java.edu.depaul.catalogue.IPopulatorInterface;
import main.java.edu.depaul.item.factory.SuperFactory;

public class ItemPopulator implements IPopulatorInterface<AbstractItem> {
	
    public ArrayList<AbstractItem> generate() {
        ArrayList<AbstractItem> result = new ArrayList<>();
        AbstractItem item1a = SuperFactory.createProduct("INSTRUMENT", "violin", "Trash Violin", "Amazon", 99.95);
        result.add(item1a);
        AbstractItem item1b = SuperFactory.createProduct("INSTRUMENT", "violin", "Professional Violin", "Joseph Curtin", 21000.0);
        result.add(item1b);

        AbstractItem item2a = SuperFactory.createProduct("INSTRUMENT", "viola", "Professional Viola", "Benjamin Ruth", 19500.0);
        result.add(item2a);
        AbstractItem item2b = SuperFactory.createProduct("INSTRUMENT", "viola", "Student Viola", "Shar", 800.0);
        result.add(item2b);
        
        AbstractItem item3a = SuperFactory.createProduct("INSTRUMENT", "cello", "Beginner Cello", "Shar", 900.0);
        result.add(item3a);
        AbstractItem item3b = SuperFactory.createProduct("INSTRUMENT", "CELLO", "Davidov Stradivarius", "Antonio Stradivari", 3500000.0);
        result.add(item3b);

        AbstractItem item4a = SuperFactory.createProduct("INSTRUMENT", "bass", "Intermediate Bass", "Shar", 1250.0);
        result.add(item4a);
        AbstractItem item4b = SuperFactory.createProduct("INSTRUMENT", "BASS", "Professional Bass", "Abraham Prescott", 50000.0);
        result.add(item4b);

        AbstractItem item5a = SuperFactory.createProduct("INSTRUMENT", "piano", "Concert Grand Piano", "Yamaha", 150000.0);
        result.add(item5a);
        AbstractItem item5b = SuperFactory.createProduct("INSTRUMENT", "pIANO", "Electric Keyboard", "Suzuki", 1500.0);
        result.add(item5b);

        AbstractItem item6a = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Flip Phone", "Nokia", 249.99);
        result.add(item6a);
        AbstractItem item6b = SuperFactory.createProduct("ELECTRONICS", "cellPhone", "Pixel 6", "Google", 700.0);
        result.add(item6b);

        AbstractItem item7a = SuperFactory.createProduct("ELECTRONICS", "computer", "Aurora R15", "Alienware", 2999.99);
        result.add(item7a);
        AbstractItem item7b = SuperFactory.createProduct("ELECTRONICS", "cOMputer", "Swift 5", "Acer", 1399.95);
        result.add(item7b);

        AbstractItem item8a = SuperFactory.createProduct("ELECTRONICS", "Speaker", "SurroundSound Mk V", "Dell", 499.95);
        result.add(item8a);
        AbstractItem item8b = SuperFactory.createProduct("ELECTRONICS", "SPEAKER", "SoundBar", "Sony", 249.99);
        result.add(item8b);

        AbstractItem item9a = SuperFactory.createProduct("ELECTRONICS", "television", "SuperCool Widescreen", "Sony", 2499.95);
        result.add(item9a);

        AbstractItem item9b = SuperFactory.createProduct("ELECTRONICS", "teleVISION", "Small Flatscreen 30 in", "Samsung", 1200.0);
        result.add(item9b);

        return result;
    }
}
