package com.framework.print.builder;

import com.framework.abstractfactorys.AbstractGroup;

public abstract interface PrintableElementsBuilder
{
  public abstract PrintableElementsBuilder startGroup(AbstractGroup paramAbstractGroup);

  public abstract void endGroup(AbstractGroup paramAbstractGroup);

  public abstract void addInputValue(String paramString, Object paramObject);
}

