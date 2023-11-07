package com.framework.utils;

import com.framework.interfaces.Comparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

public class ExtraCollectionUtils {

	public static Collection<Object> arrayToCollection(Object[] array) {
		Collection col = new ArrayList();
		for (int i = 0; i < array.length; i++) {
			col.add(array[i]);
		}
		return col;
	}

	public static Collection transformedCollection(Collection input, Transformer transformer) {
		Collection col = new ArrayList(input);
		CollectionUtils.transform(col, transformer);
		return col;
	}

	public static Object first(Collection col) {
		return col.iterator().next();
	}

	public static Collection<Object> select(Collection col, Predicate condition) {
		Collection result = new ArrayList();
		for (Iterator iter = col.iterator(); iter.hasNext();) {
			Object ob = iter.next();
			if (condition.evaluate(ob))
				result.add(ob);
		}
		return result;
	}

	public static boolean and(Collection col, Predicate cmp) {
		for (Iterator iter = col.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (!cmp.evaluate(element))
				return false;
		}
		return true;
	}

	public static boolean any(Collection col, Comparator cmp) {
		for (Iterator iter = col.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (cmp.compare(element))
				return true;
		}
		return false;
	}

	public static Collection union(Collection col1, Collection col2) {
		ArrayList answer = new ArrayList(col1.size() + col2.size());
		answer.addAll(col1);
		answer.addAll(col2);
		return answer;
	}

	public static Collection predicatedTransformedCollection(Collection collection, Transformer transformer,
			Predicate predicate) {
		return CollectionUtils.collect(CollectionUtils.predicatedCollection(collection, predicate), transformer);
	}

	public static int count(Collection collection, Predicate predicate) {
		int count = 0;
		for (Iterator iter = collection.iterator(); iter.hasNext();) {
			if (predicate.evaluate(iter.next())) {
				count++;
			}
		}
		return count;
	}

	public static boolean containsAny(Collection col1, Collection col2) {
		for (Iterator iter = col1.iterator(); iter.hasNext();) {
			final Object element = iter.next();
			if (CollectionUtils.find(col2, new Predicate() {
				public boolean evaluate(Object arg0) {
					return arg0.equals(element);
				}
			}) != null) {
				return false;
			}
		}
		return true;
	}

	public static Collection collect(Collection input, final String attribute) {
		return CollectionUtils.collect(input, new Transformer() {
			public Object transform(Object arg0) {
				try {
					return PropertyUtils.getNestedProperty(arg0, attribute);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}

	public static boolean exists(Collection list, Predicate predicate) {
		return CollectionUtils.find(list, predicate) != null;
	}

	public static Object last(Collection opciones) {
		Object last = null;
		for (Iterator iter = opciones.iterator(); iter.hasNext();) {
			Object element = iter.next();
			last = element;
		}
		return last;
	}

	public static void forAllDo(Iterator iterator, Closure closure) {
		for (Iterator iter = iterator; iter.hasNext();) {
			Object element = iter.next();
			closure.execute(element);
		}
	}
	
	public static void forAllDo(Iterable iterable, Closure closure) {
		for (Object element : iterable) {
			closure.execute(element);
		}
	}

	public static void keep(Collection original, Collection options) {
		for (Iterator iter = original.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (!options.contains(element))
				iter.remove();
		}
	}
}

/*
 * Location: E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name: com.framework.utils.CollectionUtils
 * JD-Core Version: 0.6.0
 */