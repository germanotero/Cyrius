package com.framework.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapUtils
{
  public static Object getKeyOf(Map map, Object value)
  {
    for (Iterator iter = map.keySet().iterator(); iter.hasNext(); ) {
      Object key = iter.next();
      if (map.get(key).equals(value)) {
        return key;
      }
    }
    throw new RuntimeException("el value, no se encuentra en el mapa");
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.utils.MapUtils
 * JD-Core Version:    0.6.0
 */