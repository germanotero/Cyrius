package com.framework.components.builders.impl;

import com.framework.exceptions.ProgramException;
import com.framework.utils.MapFactory;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class I18nMessage
{
  private String i18nValue;
  private Map values = MapFactory.createMap();

  public I18nMessage(String i18nValue, Map valueMap)
  {
    this.i18nValue = i18nValue;
    this.values = valueMap;
  }

  public String toString()
  {
    int startIndex = this.i18nValue.indexOf("${");
    while (startIndex != -1) {
      int endIndex = this.i18nValue.indexOf("}");
      String keyToChange = this.i18nValue.substring(startIndex + 2, endIndex);
      Object valor = this.values.get(keyToChange);
      ProgramException.validateNotNull(
        "Error no se encontro el valor para la key " + keyToChange, 
        valor);
      String value = valor.toString();
      this.i18nValue = 
        StringUtils.replace(this.i18nValue, this.i18nValue
        .substring(startIndex, endIndex + 1), value);
      startIndex = this.i18nValue.indexOf("${");
    }
    return this.i18nValue;
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.builders.impl.I18nMessage
 * JD-Core Version:    0.6.0
 */