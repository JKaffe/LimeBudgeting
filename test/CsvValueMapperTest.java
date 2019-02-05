import com.database.csv.CsvColumn;
import com.database.csv.CsvSchema;
import com.database.csv.CsvValueMapper;
import com.pojo.Category;
import com.pojo.Shop;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CsvValueMapperTest {

	@BeforeAll
	static void setup(){
		System.out.println("TESTING CsvValueMapper\n");
	}

	@TestFactory
	@DisplayName("ShoppingEvent to Csv conversion")
	Stream<DynamicTest> shoppingEventToCsvTests(){
		List<DynamicTest> tests = new ArrayList<>();

		tests.add(validConversionDefaultSchema());


		return tests.stream();
	}

	private DynamicTest validConversionDefaultSchema(){
		return DynamicTest.dynamicTest("Valid Conversion - Default Schema", () -> {
			String[] values = {Shop.LIDL.name(),"Nutella", "3.25", Category.FOOD.name(), "12.45"};

			final StringBuilder csvLine = new StringBuilder();
			for(String value : values){
				csvLine.append(value + ",");
			}
			csvLine.deleteCharAt(csvLine.length() - 1); // Removes the extra comma added at the last value

			CsvValueMapper mapper = new CsvValueMapper(csvLine.toString());

			final CsvColumn[] columns = CsvSchema.DEFAULT_COLUMN_ORDER;

			for(int k = 0; k < values.length; k++){
				Assertions.assertEquals(values[k], mapper.get(columns[k]));
			}
		});
	}

}
