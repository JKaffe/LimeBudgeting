package com.converters;

import com.pojo.Category;
import com.pojo.Item;
import com.pojo.Shop;
import com.pojo.ShoppingEvent;

public interface ParserVisitor{

	/* The map -> from field name to value. */

	Object visitElement(Category obj, String value);
	Object visitElement(Item obj, String value);
	Object visitElement(Shop obj, String value);
	Object visitElement(ShoppingEvent obj, String value);

}
