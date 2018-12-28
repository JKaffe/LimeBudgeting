import com.converters.CsvItemParser;
import com.pojo.Category;
import com.pojo.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;


public class CSVItemConverterTest {

	private CsvItemParser converter;

	@BeforeEach
	void setup(){
		System.out.println("Test: CSVItemConverter");
		this.converter = new CsvItemParser();
	}

	@Test
	void parseTest(){
		// Problems with ambiguity between is it a string or char.
		final Item itemObjRequired = new Item("AA", 2.50, Category.OTHER);
		final String csvInp = "AA,2.50,OTHER";
		try {
			Assertions.assertTrue(this.converter.parse(csvInp).equals(itemObjRequired), "Testing parsing method with valid csv string.");
		} catch (ParseException e) {
			e.printStackTrace();
			Assertions.fail("Parse Exception Thrown for valid Csv line: " + csvInp);
		}
	}
}
