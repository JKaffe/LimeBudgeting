package com.pojo.traites;

import com.database.ParserVisitor;
import com.pojo.CompositePojo;

public interface ParsableElement<E extends CompositePojo> {

	void stringParse(ParserVisitor converter, String recordStr);

}
