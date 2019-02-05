package com.database;

import com.pojo.Item;
import com.pojo.ShoppingEvent;

public interface ParserVisitor{

	/* The map -> from field name to value. */

	void visitElement(Item obj, String value);
	void visitElement(ShoppingEvent obj, String value);
}
