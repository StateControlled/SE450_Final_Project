package edu.depaul.test;

import java.util.ArrayList;

import edu.depaul.factory.SuperFactory;
import edu.depaul.item.AbstractItem;

public class ItemTest {
    public static void main(String[] args) {
        ArrayList<AbstractItem> list = generateItems();
        int n = 1;
        for (AbstractItem i : list) {
            System.out.println("Item number " + n++);
            if (i != null) {
                System.out.println(i.toString());
                System.out.println();
                System.out.println(i.view());
                System.out.println();
            } else {
                System.out.println("ITEM IS NULL");
                System.out.println();
            }
        }

        crashTest();
    }

    public static ArrayList<AbstractItem> generateItems() {
        ArrayList<AbstractItem> result = new ArrayList<>();
        AbstractItem item1a = SuperFactory.createProduct("INSTRUMENT", "violin", "Trash Violin", "Amazon", 99.95);
        result.add(item1a);
        AbstractItem item1b = SuperFactory.createProduct("INSTRUMENT", "violin", "Preofessional Violin", "Joseph Curtin", 21000.0);
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

    public static void crashTest() {
        try {
            AbstractItem crash0 = SuperFactory.createProduct(null, "Television", "30 inch TV", "Sony", 500.0);
            System.out.println(crash0.toString());
        } catch (Exception e) {
            System.out.println("TEST Category=null");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            AbstractItem crash1 = SuperFactory.createProduct("ELECTRONICS", null, "30 inch TV", "Sony", 500.0);
            System.out.println(crash1.toString());
        } catch (Exception e) {
            System.out.println("TEST itemType=null");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            AbstractItem crash2 = SuperFactory.createProduct("ELECTRONICS", "Television", null, "Sony", 500.0);
            System.out.println(crash2.toString());
        } catch (Exception e) {
            System.out.println("TEST itemName null");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            AbstractItem crash3 = SuperFactory.createProduct("ELECTRONICS", "Television", "30 inch TV", null, 500.0);
            System.out.println(crash3.toString());
        } catch (Exception e) {
            System.out.println("TEST manufacturer null");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }        

        try {
            AbstractItem crash4 = SuperFactory.createProduct("ELECTRONICS", "Television", "30 inch TV", "Sony", -10.0);
            System.out.println("This should succeed.");
            System.out.println(crash4.toString());
        } catch (Exception e) {
            System.out.println("TEST negative price");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
