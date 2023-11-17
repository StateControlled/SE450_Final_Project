package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import main.java.edu.depaul.item.AbstractItem;
import main.java.edu.depaul.item.factory.SuperFactory;
import main.java.edu.depaul.item.instrument.*;
import main.java.edu.depaul.logwriter.Level;
import main.java.edu.depaul.logwriter.LogWriter;
import main.resources.constants.StorageFiles;
import main.java.edu.depaul.item.electronics.*;

class JUnitTest {
	
	@Test
	void nullExceptions() {
		assertThrows(IllegalArgumentException.class, () -> SuperFactory.createProduct(null, "Television", "30 inch TV", "Sony", 500.0));
		assertThrows(IllegalArgumentException.class, () -> SuperFactory.createProduct("ELECTRONICS", null, "30 inch TV", "Sony", 500.0));
		assertThrows(IllegalArgumentException.class, () -> SuperFactory.createProduct("ELECTRONICS", "Television", null, "Sony", 500.0));
		assertThrows(IllegalArgumentException.class, () -> SuperFactory.createProduct("ELECTRONICS", "Television", "30 inch TV", null, 500.0));
	}
	
	@Test
	void itemGeneration() {
	    AbstractItem item1 = SuperFactory.createProduct("INSTRUMENT", "violin", "Trash Violin", "Amazon", 99.95);
	    assertNotNull(item1);
	    assertEquals(item1.getClass(), Violin.class);
	    
	    assertEquals(item1, item1);
	    assertNotEquals(item1, null);

	    AbstractItem item2 = SuperFactory.createProduct("INSTRUMENT", "viola", "Professional Viola", "Benjamin Ruth", 19500.0);
	    assertNotNull(item2);
	    assertEquals(item2.getClass(), Viola.class);
	    
	    assertNotEquals(item1, item2);

	    AbstractItem item3 = SuperFactory.createProduct("INSTRUMENT", "cello", "Beginner Cello", "Shar", 900.0);
	    assertNotNull(item3);
	    assertEquals(item3.getClass(), Cello.class);

	    AbstractItem item4 = SuperFactory.createProduct("INSTRUMENT", "bass", "Intermediate Bass", "Shar", 1250.0);
	    assertNotNull(item4);
	    assertEquals(item4.getClass(), Bass.class);
	
	    AbstractItem item5 = SuperFactory.createProduct("INSTRUMENT", "piano", "Concert Grand Piano", "Yamaha", 150000.0);
	    assertNotNull(item5);
	    assertEquals(item5.getClass(), Piano.class);
	
	    AbstractItem item6 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Flip Phone", "Nokia", 249.99);
	    assertNotNull(item6);
	    assertEquals(item6.getClass(), CellPhone.class);

	    AbstractItem item7 = SuperFactory.createProduct("ELECTRONICS", "computer", "Aurora R15", "Alienware", 2999.99);
	    assertNotNull(item7);
	    assertEquals(item7.getClass(), Computer.class);
	
	    AbstractItem item8 = SuperFactory.createProduct("ELECTRONICS", "Speaker", "SurroundSound Mk V", "Dell", 499.95);
	    assertNotNull(item8);
	    assertEquals(item8.getClass(), Speaker.class);
	
	    AbstractItem item9 = SuperFactory.createProduct("ELECTRONICS", "television", "SuperCool Widescreen", "Sony", 2499.95);
	    assertNotNull(item9);
	    assertEquals(item9.getClass(), Television.class);
	}
	
	@Test
	void focusViolin() {
		AbstractItem itemV1 = SuperFactory.createProduct("INSTRUMENT", "violin", "Beginner Violin", "Shar", 400.0);
		AbstractItem itemV2 = SuperFactory.createProduct("INSTRUMENT", "violin", "Beginner Violin", "Shar", 400.0);
		assertEquals(itemV1, itemV2);
		assertEquals(itemV1.getClass(), Violin.class);
		System.out.println(itemV1.hashCode());
		
		AbstractItem itemV3 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Not a Violin", "Samsung", 1400.0);
		assertNotEquals(itemV1, itemV3);
		
		AbstractItem itemV4 = SuperFactory.createProduct("INSTRUMENT", "viola", "Beginner Violin", "Shar", 400.0);
		assertNotEquals(itemV1, itemV4);
		
		AbstractItem itemV5 = SuperFactory.createProduct("INSTRUMENT", "violin", "Student Violin", "Shar", 400.0);
		assertNotEquals(itemV1, itemV5);
		
		AbstractItem itemV6 = SuperFactory.createProduct("INSTRUMENT", "violin", "Beginner Violin", "Benjamin Ruth", 400.0);
		assertNotEquals(itemV1, itemV6);
		
		AbstractItem itemV7 = SuperFactory.createProduct("INSTRUMENT", "violin", "Beginner Violin", "Shar", 500.0);
		assertNotEquals(itemV1, itemV7);
		
		AbstractItem itemV8 = SuperFactory.createProduct("INSTRUMENT", "violin", "Trash Violin", "Amazon", 500.0);
		assertNotEquals(itemV1, itemV8);
		
		AbstractItem itemV9 = SuperFactory.createProduct("INSTRUMENT", "violin", "Beginner Violin", "Amazon", 100.0);
		assertNotEquals(itemV1, itemV9);		
		
		AbstractItem itemVa = SuperFactory.createProduct("INSTRUMENT", "violin", "Trash Violin", "Shar", 99.0);
		assertNotEquals(itemV1, itemVa);		
	}
	
	@Test
	void focusViola() {
		AbstractItem itemV1 = SuperFactory.createProduct("INSTRUMENT", "viola", "Beginner Viola", "Shar", 400.0);
		AbstractItem itemV2 = SuperFactory.createProduct("INSTRUMENT", "viola", "Beginner Viola", "Shar", 400.0);
		assertEquals(itemV1, itemV1);
		assertEquals(itemV1, itemV2);
		assertEquals(itemV1.getClass(), Viola.class);
		assertNotEquals(itemV1, null);
		System.out.println(itemV1.hashCode());
		
		AbstractItem itemV3 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Not a Viola", "Samsung", 1400.0);
		assertNotEquals(itemV1, itemV3);
		
		AbstractItem itemV4 = SuperFactory.createProduct("INSTRUMENT", "cello", "Beginner Viola", "Shar", 400.0);
		assertNotEquals(itemV1, itemV4);
		assertNotEquals(itemV1.getClass(), itemV4.getClass());
		
		AbstractItem itemV5 = SuperFactory.createProduct("INSTRUMENT", "viola", "Student Viola", "Shar", 400.0);
		assertNotEquals(itemV1, itemV5);
		
		AbstractItem itemV6 = SuperFactory.createProduct("INSTRUMENT", "viola", "Beginner Viola", "Benjamin Ruth", 400.0);
		assertNotEquals(itemV1, itemV6);
		
		AbstractItem itemV7 = SuperFactory.createProduct("INSTRUMENT", "viola", "Beginner Viola", "Shar", 500.0);
		assertNotEquals(itemV1, itemV7);
		
		AbstractItem itemV8 = SuperFactory.createProduct("INSTRUMENT", "viola", "Trash Viola", "Amazon", 500.0);
		assertNotEquals(itemV1, itemV8);
		
		AbstractItem itemV9 = SuperFactory.createProduct("INSTRUMENT", "viola", "Beginner Viola", "Amazon", 100.0);
		assertNotEquals(itemV1, itemV9);		
		
		AbstractItem itemVa = SuperFactory.createProduct("INSTRUMENT", "viola", "Trash Viola", "Shar", 99.0);
		assertNotEquals(itemV1, itemVa);		
	}	
	
	@Test
	void focusCello() {
		AbstractItem itemV1 = SuperFactory.createProduct("INSTRUMENT", "Cello", "Beginner Cello", "Shar", 400.0);
		AbstractItem itemV2 = SuperFactory.createProduct("INSTRUMENT", "Cello", "Beginner Cello", "Shar", 400.0);
		assertEquals(itemV1, itemV1);
		assertEquals(itemV1, itemV2);
		assertEquals(itemV1.getClass(), Cello.class);
		assertNotEquals(itemV1, null);
		System.out.println(itemV1.hashCode());
		
		AbstractItem itemV3 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Not a Cello", "Samsung", 1400.0);
		assertNotEquals(itemV1, itemV3);
		
		AbstractItem itemV4 = SuperFactory.createProduct("INSTRUMENT", "bass", "Beginner Cello", "Shar", 400.0);
		assertNotEquals(itemV1, itemV4);
		assertNotEquals(itemV1.getClass(), itemV4.getClass());
		
		AbstractItem itemV5 = SuperFactory.createProduct("INSTRUMENT", "Cello", "Student Cello", "Shar", 400.0);
		assertNotEquals(itemV1, itemV5);
		
		AbstractItem itemV6 = SuperFactory.createProduct("INSTRUMENT", "Cello", "Beginner Cello", "Benjamin Ruth", 400.0);
		assertNotEquals(itemV1, itemV6);
		
		AbstractItem itemV7 = SuperFactory.createProduct("INSTRUMENT", "Cello", "Beginner Cello", "Shar", 500.0);
		assertNotEquals(itemV1, itemV7);
		
		AbstractItem itemV8 = SuperFactory.createProduct("INSTRUMENT", "Cello", "Trash Cello", "Amazon", 500.0);
		assertNotEquals(itemV1, itemV8);
		
		AbstractItem itemV9 = SuperFactory.createProduct("INSTRUMENT", "Cello", "Beginner Cello", "Amazon", 100.0);
		assertNotEquals(itemV1, itemV9);		
		
		AbstractItem itemVa = SuperFactory.createProduct("INSTRUMENT", "Cello", "Trash Cello", "Shar", 99.0);
		assertNotEquals(itemV1, itemVa);		
	}	
	
	@Test
	void focusBass() {
		AbstractItem itemV1 = SuperFactory.createProduct("INSTRUMENT", "Bass", "Beginner Bass", "Shar", 400.0);
		AbstractItem itemV2 = SuperFactory.createProduct("INSTRUMENT", "Bass", "Beginner Bass", "Shar", 400.0);
		assertEquals(itemV1, itemV1);
		assertEquals(itemV1, itemV2);
		assertEquals(itemV1.getClass(), Bass.class);
		assertNotEquals(itemV1, null);
		System.out.println(itemV1.hashCode());
		
		AbstractItem itemV3 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Not a Bass", "Samsung", 1400.0);
		assertNotEquals(itemV1, itemV3);
		
		AbstractItem itemV4 = SuperFactory.createProduct("INSTRUMENT", "piano", "Beginner Bass", "Shar", 400.0);
		assertNotEquals(itemV1, itemV4);
		assertNotEquals(itemV1.getClass(), itemV4.getClass());
		
		AbstractItem itemV5 = SuperFactory.createProduct("INSTRUMENT", "Bass", "Student Bass", "Shar", 400.0);
		assertNotEquals(itemV1, itemV5);
		
		AbstractItem itemV6 = SuperFactory.createProduct("INSTRUMENT", "Bass", "Beginner Bass", "Benjamin Ruth", 400.0);
		assertNotEquals(itemV1, itemV6);
		
		AbstractItem itemV7 = SuperFactory.createProduct("INSTRUMENT", "Bass", "Beginner Bass", "Shar", 500.0);
		assertNotEquals(itemV1, itemV7);
		
		AbstractItem itemV8 = SuperFactory.createProduct("INSTRUMENT", "Bass", "Trash Bass", "Amazon", 500.0);
		assertNotEquals(itemV1, itemV8);
		
		AbstractItem itemV9 = SuperFactory.createProduct("INSTRUMENT", "Bass", "Beginner Bass", "Amazon", 100.0);
		assertNotEquals(itemV1, itemV9);		
		
		AbstractItem itemVa = SuperFactory.createProduct("INSTRUMENT", "Bass", "Trash Bass", "Shar", 99.0);
		assertNotEquals(itemV1, itemVa);		
	}	
	
	@Test
	void focusPiano() {
		AbstractItem itemV1 = SuperFactory.createProduct("INSTRUMENT", "Piano", "Beginner Piano", "Shar", 400.0);
		AbstractItem itemV2 = SuperFactory.createProduct("INSTRUMENT", "Piano", "Beginner Piano", "Shar", 400.0);
		assertEquals(itemV1, itemV1);
		assertEquals(itemV1, itemV2);
		assertEquals(itemV1.getClass(), Piano.class);
		assertNotEquals(itemV1, null);
		System.out.println(itemV1.hashCode());
		
		AbstractItem itemV3 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Not a Piano", "Samsung", 1400.0);
		assertNotEquals(itemV1, itemV3);
		
		AbstractItem itemV4 = SuperFactory.createProduct("INSTRUMENT", "violin", "Beginner Piano", "Shar", 400.0);
		assertNotEquals(itemV1, itemV4);
		assertNotEquals(itemV1.getClass(), itemV4.getClass());
		
		AbstractItem itemV5 = SuperFactory.createProduct("INSTRUMENT", "Piano", "Student Piano", "Shar", 400.0);
		assertNotEquals(itemV1, itemV5);
		
		AbstractItem itemV6 = SuperFactory.createProduct("INSTRUMENT", "Piano", "Beginner Piano", "Benjamin Ruth", 400.0);
		assertNotEquals(itemV1, itemV6);
		
		AbstractItem itemV7 = SuperFactory.createProduct("INSTRUMENT", "Piano", "Beginner Piano", "Shar", 500.0);
		assertNotEquals(itemV1, itemV7);
		
		AbstractItem itemV8 = SuperFactory.createProduct("INSTRUMENT", "Piano", "Trash Piano", "Amazon", 500.0);
		assertNotEquals(itemV1, itemV8);
		
		AbstractItem itemV9 = SuperFactory.createProduct("INSTRUMENT", "Piano", "Beginner Piano", "Amazon", 100.0);
		assertNotEquals(itemV1, itemV9);		
		
		AbstractItem itemVa = SuperFactory.createProduct("INSTRUMENT", "Piano", "Trash Piano", "Shar", 99.0);
		assertNotEquals(itemV1, itemVa);		
	}
	
	@Test
	void focusTelevision() {
		AbstractItem itemV1 = SuperFactory.createProduct("ELECTRONICS", "Television", "Small Television", "Samsung", 400.0);
		AbstractItem itemV2 = SuperFactory.createProduct("ELECTRONICS", "Television", "Small Television", "Samsung", 400.0);
		assertEquals(itemV1, itemV1);
		assertEquals(itemV1, itemV2);
		assertEquals(itemV1.getClass(), Television.class);
		assertNotEquals(itemV1, null);
		System.out.println(itemV1.hashCode());
		
		AbstractItem itemV3 = SuperFactory.createProduct("INSTRUMENT", "Cello", "Not a Television", "Shar", 1400.0);
		assertNotEquals(itemV1, itemV3);
		
		AbstractItem itemV4 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Small Television", "Samsung", 400.0);
		assertNotEquals(itemV1, itemV4);
		assertNotEquals(itemV1.getClass(), itemV4.getClass());
		
		AbstractItem itemV5 = SuperFactory.createProduct("ELECTRONICS", "Television", "Cheap Television", "Samsung", 400.0);
		assertNotEquals(itemV1, itemV5);
		
		AbstractItem itemV6 = SuperFactory.createProduct("ELECTRONICS", "Television", "Small Television", "Google", 400.0);
		assertNotEquals(itemV1, itemV6);
		
		AbstractItem itemV7 = SuperFactory.createProduct("ELECTRONICS", "Television", "Small Television", "Samsung", 500.0);
		assertNotEquals(itemV1, itemV7);
		
		AbstractItem itemV8 = SuperFactory.createProduct("ELECTRONICS", "Television", "Trash Television", "Amazon", 500.0);
		assertNotEquals(itemV1, itemV8);
		
		AbstractItem itemV9 = SuperFactory.createProduct("ELECTRONICS", "Television", "Small Television", "Amazon", 100.0);
		assertNotEquals(itemV1, itemV9);		
		
		AbstractItem itemVa = SuperFactory.createProduct("ELECTRONICS", "Television", "Trash Television", "Samsung", 99.0);
		assertNotEquals(itemV1, itemVa);		
	}		
	
	@Test
	void focusCellPhone() {
		AbstractItem itemV1 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Small CellPhone", "Samsung", 400.0);
		AbstractItem itemV2 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Small CellPhone", "Samsung", 400.0);
		assertEquals(itemV1, itemV1);
		assertEquals(itemV1, itemV2);
		assertEquals(itemV1.getClass(), CellPhone.class);
		assertNotEquals(itemV1, null);
		System.out.println(itemV1.hashCode());
		
		AbstractItem itemV3 = SuperFactory.createProduct("INSTRUMENT", "Cello", "Not a CellPhone", "Shar", 1400.0);
		assertNotEquals(itemV1, itemV3);
		
		AbstractItem itemV4 = SuperFactory.createProduct("ELECTRONICS", "Television", "Small CellPhone", "Samsung", 400.0);
		assertNotEquals(itemV1, itemV4);
		assertNotEquals(itemV1.getClass(), itemV4.getClass());
		
		AbstractItem itemV5 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Cheap CellPhone", "Samsung", 400.0);
		assertNotEquals(itemV1, itemV5);
		
		AbstractItem itemV6 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Small CellPhone", "Google", 400.0);
		assertNotEquals(itemV1, itemV6);
		
		AbstractItem itemV7 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Small CellPhone", "Samsung", 500.0);
		assertNotEquals(itemV1, itemV7);
		
		AbstractItem itemV8 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Trash CellPhone", "Amazon", 500.0);
		assertNotEquals(itemV1, itemV8);
		
		AbstractItem itemV9 = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Small CellPhone", "Amazon", 100.0);
		assertNotEquals(itemV1, itemV9);		
		
		AbstractItem itemVa = SuperFactory.createProduct("ELECTRONICS", "CellPhone", "Trash CellPhone", "Samsung", 99.0);
		assertNotEquals(itemV1, itemVa);		
	}		
	
	@Test
	void focusSpeaker() {
		AbstractItem itemV1 = SuperFactory.createProduct("ELECTRONICS", "Speaker", "Small Speaker", "Samsung", 400.0);
		AbstractItem itemV2 = SuperFactory.createProduct("ELECTRONICS", "Speaker", "Small Speaker", "Samsung", 400.0);
		assertEquals(itemV1, itemV1);
		assertEquals(itemV1, itemV2);
		assertEquals(itemV1.getClass(), Speaker.class);
		assertNotEquals(itemV1, null);
		System.out.println(itemV1.hashCode());
		
		AbstractItem itemV3 = SuperFactory.createProduct("INSTRUMENT", "Cello", "Not a Speaker", "Shar", 1400.0);
		assertNotEquals(itemV1, itemV3);
		
		AbstractItem itemV4 = SuperFactory.createProduct("ELECTRONICS", "Television", "Small Speaker", "Samsung", 400.0);
		assertNotEquals(itemV1, itemV4);
		assertNotEquals(itemV1.getClass(), itemV4.getClass());
		
		AbstractItem itemV5 = SuperFactory.createProduct("ELECTRONICS", "Speaker", "Cheap Speaker", "Samsung", 400.0);
		assertNotEquals(itemV1, itemV5);
		
		AbstractItem itemV6 = SuperFactory.createProduct("ELECTRONICS", "Speaker", "Small Speaker", "Google", 400.0);
		assertNotEquals(itemV1, itemV6);
		
		AbstractItem itemV7 = SuperFactory.createProduct("ELECTRONICS", "Speaker", "Small Speaker", "Samsung", 500.0);
		assertNotEquals(itemV1, itemV7);
		
		AbstractItem itemV8 = SuperFactory.createProduct("ELECTRONICS", "Speaker", "Trash Speaker", "Amazon", 500.0);
		assertNotEquals(itemV1, itemV8);
		
		AbstractItem itemV9 = SuperFactory.createProduct("ELECTRONICS", "Speaker", "Small Speaker", "Amazon", 100.0);
		assertNotEquals(itemV1, itemV9);		
		
		AbstractItem itemVa = SuperFactory.createProduct("ELECTRONICS", "Speaker", "Trash Speaker", "Samsung", 99.0);
		assertNotEquals(itemV1, itemVa);		
	}		
	
	@Test
	void focusComputer() {
		AbstractItem itemV1 = SuperFactory.createProduct("ELECTRONICS", "Computer", "Small Computer", "Samsung", 400.0);
		AbstractItem itemV2 = SuperFactory.createProduct("ELECTRONICS", "Computer", "Small Computer", "Samsung", 400.0);
		assertEquals(itemV1, itemV1);
		assertEquals(itemV1, itemV2);
		assertEquals(itemV1.getClass(), Computer.class);
		assertNotEquals(itemV1, null);
		System.out.println(itemV1.hashCode());
		
		AbstractItem itemV3 = SuperFactory.createProduct("INSTRUMENT", "Cello", "Not a Computer", "Shar", 1400.0);
		assertNotEquals(itemV1, itemV3);
		
		AbstractItem itemV4 = SuperFactory.createProduct("ELECTRONICS", "Television", "Small Computer", "Samsung", 400.0);
		assertNotEquals(itemV1, itemV4);
		assertNotEquals(itemV1.getClass(), itemV4.getClass());
		
		AbstractItem itemV5 = SuperFactory.createProduct("ELECTRONICS", "Computer", "Cheap Computer", "Samsung", 400.0);
		assertNotEquals(itemV1, itemV5);
		
		AbstractItem itemV6 = SuperFactory.createProduct("ELECTRONICS", "Computer", "Small Computer", "Google", 400.0);
		assertNotEquals(itemV1, itemV6);
		
		AbstractItem itemV7 = SuperFactory.createProduct("ELECTRONICS", "Computer", "Small Computer", "Samsung", 500.0);
		assertNotEquals(itemV1, itemV7);
		
		AbstractItem itemV8 = SuperFactory.createProduct("ELECTRONICS", "Computer", "Trash Computer", "Amazon", 500.0);
		assertNotEquals(itemV1, itemV8);
		
		AbstractItem itemV9 = SuperFactory.createProduct("ELECTRONICS", "Computer", "Small Computer", "Amazon", 100.0);
		assertNotEquals(itemV1, itemV9);		
		
		AbstractItem itemVa = SuperFactory.createProduct("ELECTRONICS", "Computer", "Trash Computer", "Samsung", 99.0);
		assertNotEquals(itemV1, itemVa);		
	}		
	
	@Test
	void itemGetSet() {
		AbstractItem itemA = SuperFactory.createProduct("INSTRUMENT", "violin", "Beginner Violin", "Shar", 400.0);
		System.out.println(itemA.toString());
		System.out.println(itemA.view());
		System.out.println(itemA.hashCode());
		
		assertEquals(itemA.getCategory(), "INSTRUMENT");
		assertEquals(itemA.getItemType(), "VIOLIN");
		assertEquals(itemA.getItemName(), "Beginner Violin");
		assertEquals(itemA.getManufacturer(), "Shar");
		assertEquals(itemA.getPrice(), 400.0);
		
		itemA.setItemName("Student Violin");
		assertEquals(itemA.getItemName(), "Student Violin");
		
		itemA.setManufacturer("Joseph Curtin");
		assertEquals(itemA.getManufacturer(), "Joseph Curtin");
		
		itemA.setPrice(256.0);
		assertEquals(itemA.getPrice(), 256.0);
		
	}
	
	@Test
	void logWriter() {
		assertThrows(NullPointerException.class, ()-> LogWriter.getLogWriter(null));
		assertNotNull(LogWriter.getLogWriter("jTestLog"));
		
		LogWriter.getLogWriter("jTestLog");
		LogWriter.log(Level.INFO, "Test Message 1", new Exception());
		LogWriter.log(Level.INFO, "Test Message 2", "Test Alternate");
		File logFile = LogWriter.getLog();
		assertNotNull(logFile);
	}
	
	@Test
	void constantNotNull() {
		assertNotNull(StorageFiles.CATALOGUE_SOURCE);
		assertNotNull(StorageFiles.TEST_CATALOGUE);
		assertNotNull(StorageFiles.USER_DATABASE);
	}

}
