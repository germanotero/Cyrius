package com.framework.components;

import com.framework.components.listeners.ModelTargetListener;
import com.framework.components.validators.FormValueSelectionContainerValidator;
import com.framework.models.DefaultComboModel;
import com.framework.models.FormModel;
import com.framework.print.builder.PrintableElementsBuilder;
import com.framework.utils.CollectionFactory;
import com.framework.utils.ExtraCollectionUtils;
import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.FalsePredicate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultComboBox extends JAutoComboBox
  implements Combo
{
  private transient Log log = LogFactory.getLog(getClass());

  private Predicate invisibleCondition = FalsePredicate.INSTANCE;

  private Predicate disablePredicate = FalsePredicate.INSTANCE;
  private FormModel model;
  private Collection values;
  private Collection<ModelTargetListener> modelTargetListeners = CollectionFactory.createCollection(ModelTargetListener.class);

  private FormValueSelectionContainerValidator validator = FormValueSelectionContainerValidator.DUMMY_INSTANCE;

  private boolean withNullElement = true;
  private JLabel label;
  private boolean doRefresh = true;

  private Transformer onCommitAction = new Transformer()
  {
    public Object transform(Object arg0) {
      return arg0.equals("") ? null : arg0;
    }
  };

  public DefaultComboBox()
  {
  }

  public DefaultComboBox(String name)
  {
    this();
    createLabel(name);
  }

  private void createLabel(String name)
  {
    this.label = new JLabel();
    this.label.setBackground(getBackground());
    this.label.setText(name);
    this.label.setFocusable(false);
  }

  public void initComponent()
  {
    setAutocomplete(true);
    setEditable(true);
    fireModelChange();
  }

  public void setValues(Collection values) {
    this.values = values;
    if (this.withNullElement) {
      this.values = ExtraCollectionUtils.union(CollectionFactory.createCollectionWith(""), values);
    }
    if (values != null)
      super.setModel(new DefaultComboBoxModel(this.values.toArray()));
  }

  public DefaultComboModel getValues()
  {
    return new DefaultComboModel(this.values);
  }

  public void refreshComponent()
  {
    if (this.doRefresh) {
      Object itemReminder = getSelectedItem();
      checkVisivility();
      fireModelChange();
      setSelectedItem(itemReminder);
    }
  }

  private void fireModelChange() {
    for (Iterator iter = this.modelTargetListeners.iterator(); iter.hasNext(); ) {
      ModelTargetListener element = (ModelTargetListener)iter.next();
      element.load(this.model);
    }
  }

  public void setSelectedItem(Object anObject)
  {
    super.setSelectedItem(anObject);
  }

  private void checkVisivility() {
    setVisible(!this.invisibleCondition.evaluate(this.model));
    setEnabled(!this.disablePredicate.evaluate(this.model));
  }

  public FormComponent setNotVisibleOn(Predicate condition) {
    this.invisibleCondition = condition;
    return this;
  }

  public FormComponent setDisableOn(Predicate condition) {
    this.disablePredicate = condition;
    return this;
  }

  public void setModel(FormModel model)
  {
    this.model = model;
  }

  public boolean isColumnComponent()
  {
    return false;
  }

  public void addModelTargetListener(ModelTargetListener listener) {
    this.modelTargetListeners.add(listener);
  }

  public void addComboRestriction(Combo combo, String propertyList) {
    throw new RuntimeException("Analizar esto");
  }

  public void direct(PrintableElementsBuilder print) {
    if (getSelectedItem() != null) {
      this.log.debug("Se va a imprimir el valor del combo: " + getName());
      print.addInputValue(getName(), getSelectedItem());
    } else {
      this.log.debug(
        "Se salteo el valor del combo: " + getName() + " por no estar seleccionado.");
    }
  }

  public void setValidator(FormValueSelectionContainerValidator validator) {
    this.validator = validator;
  }

  public Object getValor() {
    return getSelectedItem();
  }

  public void setValue(Object value) {
    setSelectedItem(value);
  }

  public boolean isEmpty() {
    return getSelectedItem() == null;
  }

  public void impactModel(boolean validate) {
    this.validator.validate(this);
  }

 public Object getSelectedItem()
  {
    if (isAutoComplete())
      return getOnCommitAction().transform(
        super.getSelectedItem() == null ? super.getComboText() : super.getSelectedItem());
    return getOnCommitAction().transform(super.getSelectedItem());
  }

  public void withOutNullElement() {
    this.withNullElement = false;
  }

  public void setFull() {
    getLabel().setForeground(Color.BLACK);
  }

  public void setNotFull() {
    getLabel().setForeground(Color.RED);
  }

  public JComponent getLabel() {
    return this.label;
  }

  public void setName(String name)
  {
    super.setName(name);
    createLabel(name);
  }

  public void setOnCommitAction(Transformer onCommitAction) {
    this.onCommitAction = onCommitAction;
  }

  public Transformer getOnCommitAction() {
    return this.onCommitAction;
  }

  public void doRefresh() {
    this.doRefresh = true;
  }

  public void dontRefresh() {
    this.doRefresh = false;
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.DefaultComboBox
 * JD-Core Version:    0.6.0
 */