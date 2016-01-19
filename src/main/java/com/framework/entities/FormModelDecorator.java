package com.framework.entities;

import com.framework.models.DelegatingModel;
import com.framework.models.FormModel;
import com.framework.persistence.PersistibleObject;
import com.framework.utils.ClassUtils;
import com.framework.utils.CollectionUtils;
import com.framework.utils.MapFactory;
import com.framework.utils.PropertyUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import org.apache.commons.collections.Closure;

public class FormModelDecorator implements FormModel {
	private Object wrapped;
	private Map<String, FormModel> values = (Map) MapFactory.createMap(String.class, FormModel.class);
	
	public FormModelDecorator() {
		
	}

	public FormModelDecorator(Object wraped) {
		if (wraped == null)
			throw new RuntimeException("no se puede wrapear un modelo nulo.");
		if ((wraped instanceof FormModelDecorator))
			this.wrapped = ((FormModelDecorator) wraped).wrapped;
		else
			this.wrapped = wraped;
	}

	public Map<String, FormModel> getValues() {
		return this.values;
	}

	public FormModel getProperty(String aspect) {
		int pointIndex = aspect.indexOf('.');
		if (pointIndex != -1) {
			String simpleProperty = aspect.substring(0, pointIndex);
			FormModel firstProperty = getSimpleAspect(simpleProperty);
			if (firstProperty == null)
				return null;
			return firstProperty.getProperty(aspect.substring(pointIndex + 1));
		}
		return getSimpleAspect(aspect);
	}

	public FormModel getSimpleAspect(String aspect) {
		if (this.values.containsKey(aspect))
			return (FormModel) this.values.get(aspect);
		try {
			FormModel answer = null;
			try {
				Object property = PropertyUtils.getNestedProperty(this.wrapped, aspect);
				if (property != null)
					answer = FormModelUtils.wrap(property);
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Error al invocar el mensaje" + aspect);
			} catch (InvocationTargetException e) {
				if ((e.getCause() instanceof RuntimeException)) {
					throw ((RuntimeException) e.getCause());
				}
				throw new RuntimeException(e.getCause());
			}
			if (answer == null) {
				return null;
			}

			if (!(answer.getValue() instanceof Collection))
				this.values.put(aspect, answer);
			return answer;
		} catch (NoSuchMethodException e) {
			if ((this.wrapped instanceof DelegatingModel)) {
				DelegatingModel model = (DelegatingModel) this.wrapped;
				return FormModelUtils.wrap(model.getDelegatee()).getProperty(aspect);
			}
			throw new RuntimeException("Error al obtener la propiedad: "
					+ ClassUtils.getShortName(this.wrapped.getClass()) + " no tiene la propiedad: " + aspect, e);
		}

	}

	public void setProperty(String aspect, Object value) {
		if ((value instanceof Collection))
			inpactProperty(aspect, value);
		else
			this.values.put(aspect, FormModelUtils.wrap(value));
	}

	public Object getValue() {
		impactInternValues();
		this.values.clear();
		return this.wrapped;
	}

	public final void save() {
		impactInternValues();
		this.values.clear();
	}

	private void impactInternValues() {
		CollectionUtils.forAllDo((Collection) this.values.keySet(), new Closure() {
			public void execute(Object arg0) {
				String property = (String) arg0;
				FormModel formModel = (FormModel) FormModelDecorator.this.values.get(property);
				FormModelDecorator.this.inpactProperty(property, formModel.getValue());
			}
		});
	}

	private void inpactProperty(String property, Object value) {
		try {
			PropertyUtils.setNestedProperty(this.wrapped, property, value);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("Cuidado, se intento setear la propiedad: " + property
					+ " y se encontro que el objeto a setear es de otra clase, objecto a setear: " + value
					+ " de la clase: " + ClassUtils.getShortName(value.getClass()));
		} catch (NoSuchMethodException e) {
			if ((this.wrapped instanceof DelegatingModel)) {
				DelegatingModel model = (DelegatingModel) this.wrapped;
				try {
					PropertyUtils.setNestedProperty(model.getDelegatee(), property, value);
				} catch (Exception e1) {
					throw new RuntimeException(e1);
				}
			} else {
				throw new RuntimeException(e);
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	public void refresh() {
		this.values.clear();
	}

	public String toString() {
		return this.wrapped.toString();
	}

	public Class getDecoratedClass() {
		return this.wrapped.getClass();
	}

	public boolean isPersisted() {
		if ((this.wrapped instanceof PersistibleObject)) {
			return ((PersistibleObject) this.wrapped).getId() != null;
		}
		return false;
	}
}
