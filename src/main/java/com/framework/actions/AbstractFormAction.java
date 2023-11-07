package com.framework.actions;

import com.framework.components.FormComponent;
import com.framework.components.ModelTargetEnableContainer;
import com.framework.models.FormModel;
import com.framework.utils.StringUtils;
import java.awt.Cursor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.FalsePredicate;

public abstract class AbstractFormAction extends AbstractAction
  implements FormAction{
  private ModelTargetEnableContainer padre;
  private Predicate invisibleCondition = FalsePredicate.INSTANCE;
  private FormModel modelo;
  private boolean refreshAfterExecute = false;

  private Predicate disablePredicate = FalsePredicate.INSTANCE;

  private boolean validate = true;


  public void setRefreshAfterExecute(boolean refreshAfterExecute) {
    this.refreshAfterExecute = refreshAfterExecute;
  }

  public void dontValidate() {
    this.validate = false;
  }

  public AbstractFormAction()
  {
  }

  public AbstractFormAction(ModelTargetEnableContainer frameFactory) {
    this(frameFactory, null);
  }

  public AbstractFormAction(Icon icon) {
    super(icon);
  }

  public AbstractFormAction(ModelTargetEnableContainer container, ImageIcon icon)
  {
    this(icon);
    this.padre = container;
  }

  protected String getActionKey()
  {
    Object modelo = this.padre != null ? this.padre.getModelo() : "";
    return StringUtils.getI18NKey(modelo, super.getActionKey());
  }

  public void setModelo(FormModel modelo) {
    this.modelo = modelo;
  }

  public void setParent(ModelTargetEnableContainer model) {
    this.padre = model;
  }

  public Object getModelo() {
    return this.modelo;
  }

  protected ModelTargetEnableContainer getPadre()
  {
    return this.padre.getContainer();
  }

  protected ModelTargetEnableContainer getPanelParent() {
    return this.padre;
  }

  public void initComponent()
  {
    super.initComponent();
    checkVisivility();
  }

  public void refreshComponent()
  {
    checkVisivility();
  }

  private void checkVisivility()
  {
    setVisible(!this.invisibleCondition.evaluate(this.modelo));
    setEnabled(!this.disablePredicate.evaluate(this.modelo));
  }

  protected final void executeAction(Object model)
    throws Exception
  {
    if (isImpactableModelAction())
      getPadre().impactModel(this.validate);
    executeFormAction(getPadre().getOpenTarget()
      .getModel(this.modelo));
    if (this.refreshAfterExecute)
      this.padre.refreshComponent();
  }

  public FormComponent setNotVisibleOn(Predicate condition)
  {
    this.invisibleCondition = condition;
    return this;
  }

  public FormComponent setDisableOn(Predicate condition) {
    this.disablePredicate = condition;
    return this;
  }

  protected void preExecution()
  {
    getPadre().setCursor(new Cursor(3));
  }

  protected void rearmOldState()
  {
    getPadre().setCursor(new Cursor(0));
  }

  protected abstract boolean isImpactableModelAction();

  protected abstract void executeFormAction(FormModel paramFormModel)
    throws Exception;
}
