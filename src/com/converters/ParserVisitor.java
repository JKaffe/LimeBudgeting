package com.converters;

import com.BudgetingVisitor;
import com.pojo.Category;
import com.pojo.Item;
import com.pojo.Shop;
import com.pojo.ShoppingEvent;

import java.util.Map;

public interface BudgetingConverterVisitor extends BudgetingVisitor {

	/* The map -> from field name to value. */

	Object visitElement(Map<String, String> values, Category mapper);
	Object visitElement(Map<String, String> values, Item mapper);
	Object visitElement(Map<String, String> values, Shop mapper);
	Object visitElement(Map<String, String> values, ShoppingEvent mapper);

}
