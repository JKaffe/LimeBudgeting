package com.pojo;

import com.converters.ParserVisitor;

public interface BudgettingVisitableElement<E> {

	E stringParse(ParserVisitor converter, String recordStr);

}
