package com.framework.abstractfactorys;

import com.framework.components.FormComponent;
import com.framework.components.FormContainer;
import com.framework.components.RowComponent;
import com.framework.components.builders.impl.FormActionBuilderImpl;
import com.framework.components.builders.impl.FormElementsBuilderImpl;
import com.framework.exceptions.NotFullFormException;
import com.framework.exceptions.NotFullFormExceptionBuilder;
import com.framework.print.builder.PrintableElementsBuilder;
import com.framework.utils.ArrayIterator;
import com.framework.utils.ExtraCollectionUtils;
import com.framework.utils.StringProvider;
import java.util.Iterator;
import javax.swing.JTabbedPane;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.FalsePredicate;

public class FormTabbedPanel extends JTabbedPane
  implements FormContainer, RowComponent
{
  private Predicate visibleCondition;
  private AbstractPanel parent;
  private Predicate disablePredicate = FalsePredicate.INSTANCE;

  public FormTabbedPanel(AbstractPanel parent)
  {
    this.parent = parent;
    setTabLayoutPolicy(1);
    setTabPlacement(3);
  }

  public final void initComponent()
  {
  }

  public final boolean hasVisibleCondition()
  {
    return this.visibleCondition != null;
  }

  public final FormComponent setNotVisibleOn(Predicate condition)
  {
    this.visibleCondition = condition;
    return this;
  }

  public void impactModel(boolean validate)
  {
    NotFullFormExceptionBuilder builder = new NotFullFormExceptionBuilder();
    for (Iterator iter = getGroups(); iter.hasNext(); ) {
      try {
        AbstractGroup grupo = (AbstractGroup)iter.next();
        grupo.impactModel(validate);
      } catch (NotFullFormException nffe) {
        builder.add(nffe);
      }
    }
    if (builder.hasException())
      throw builder.build();
  }

  private Iterator getGroups() {
    return new ArrayIterator(getComponents(), 
      new InstanceOfAbstractGroupPredicate());
  }

  public boolean isRowComponent()
  {
    return true;
  }

  public void refreshComponent()
  {
    for (Iterator iter = getGroups(); iter.hasNext(); ) {
      AbstractGroup grupo = (AbstractGroup)iter.next();
      grupo.refreshComponent();
    }
  }

  public void initGroups()
  {
    for (Iterator iter = getGroups(); iter.hasNext(); ) {
      AbstractGroup grupo = (AbstractGroup)iter.next();
      grupo.setPadre(this.parent);
      initGroup(grupo);
    }
  }

  protected void setUpGroup(AbstractGroup group) {
    FormElementsBuilderImpl elementBuilder = new FormElementsBuilderImpl(
      group);
    FormActionBuilderImpl actionBuilder = new FormActionBuilderImpl(group);
    group.setUp();
    group.registerElements(elementBuilder);
    elementBuilder.build();
    group.registerActions(actionBuilder);
    actionBuilder.build();
    group.initComponent();
  }

  protected void initGroup(AbstractGroup group) {
    setUpGroup(group);
    String title = StringProvider.getInstance().getValueOf(
      group.getClass().getName());
    group.setBorder(BorderFactory.createDefaultGroupBorder(title));
  }

  public boolean isColumnComponent()
  {
    return false;
  }

  public void direct(PrintableElementsBuilder print) {
    ExtraCollectionUtils.forAllDo(getGroups(), 
      new DirectGroupsClosure(print));
  }

  public FormComponent setDisableOn(Predicate condition)
  {
    this.disablePredicate = condition;
    return this;
  }

  private class InstanceOfAbstractGroupPredicate
    implements Predicate
  {
    private InstanceOfAbstractGroupPredicate()
    {
    }

    public boolean evaluate(Object arg0)
    {
      return arg0 instanceof AbstractGroup;
    }
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.FormTabbedPanel
 * JD-Core Version:    0.6.0
 */