package com.travel.visitor;

import com.travel.visitor.Visitor;

/**
 * 可被访问的接口，模型类实现此接口以允许 Visitor 访问
 */
public interface Visitable {
    void accept(Visitor visitor);
}