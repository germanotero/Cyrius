package com.framework.entities;

import com.framework.models.FormModel;
import com.framework.utils.MapFactory;
import com.framework.utils.StringUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.Map;

public class DynamicFormModel implements FormModel {
	private Map values = MapFactory.createMap();
	private DynamicFormDecorator decorator;

	public DynamicFormModel() {
	}

	public DynamicFormModel(DynamicFormDecorator decorator) {
		this.decorator = decorator;
		String xml = decorator.getDatosXML();
		if (!StringUtils.isNullOrEmpty(xml)) {
			XStream xstream = new XStream(new DomDriver());
			this.values = ((Map) xstream.fromXML(xml));
		}
	}

	public DynamicFormDecorator getDecorator() {
		return this.decorator;
	}

	public void save() {
		XStream xstream = new XStream(new DomDriver());
		String xml = xstream.toXML(this.values);
		this.decorator.finishForm(xml);
	}

	public FormModel getProperty(String key) {
		return (FormModel) this.values.get(key);
	}

	public void setProperty(String aspect, Object value) {
		this.values.put(aspect, FormModelUtils.wrap(value));
	}

	public Object getValue() {
		return this;
	}

	public void refresh() {
	}

	public Class getDecoratedClass() {
		return getClass();
	}

	public boolean isPersisted() {
		return this.decorator.isPersisted();
	}
}
