 package com.framework.abstractfactorys;
 
 import com.framework.components.FormComponent;
 import com.framework.components.FormModelContainer;
 import com.framework.components.builders.interfaces.FormActionBuilder;
 import com.framework.components.builders.interfaces.FormElementsBuilder;
 import com.framework.components.listeners.ModelTargetListener;
 import com.framework.components.listeners.NullModelTargetListener;
 import com.framework.entities.FormModelUtils;
 import com.framework.models.FormModel;
 import com.framework.print.builder.PrintableElementsBuilder;
 import com.framework.utils.ClassUtils;
 import com.framework.utils.ExtraCollectionUtils;
 import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
 import org.apache.commons.collections4.functors.FalsePredicate;
 
 public abstract class AbstractGroup extends AbstractPanel
   implements FormModelContainer
 {
   private Predicate invisiblePredicate = FalsePredicate.INSTANCE;
 
   private Predicate disablePredicate = FalsePredicate.INSTANCE;
   private FormModel model;
   private ModelTargetListener modelTargetListener = NullModelTargetListener.getInstance();
 
   public final void initComponent() {
     this.modelTargetListener.load(this.model);
     initSubComponent();
     CollectionUtils.forAllDo(getAllComponents(), new CheckEnabilityClosure());
     checkVisivility();
   }
 
   public void direct(PrintableElementsBuilder print)
   {
     print.startGroup(this);
     super.direct(print);
     print.endGroup(this);
   }
 
   protected void initSubComponent()
   {
   }
 
   public void registerElements(FormElementsBuilder builder) {
     registerGroupElements(builder);
   }
 
   public void registerActions(FormActionBuilder builder) {
     registerGroupActions(builder);
   }
 
   public void addModelTargetListener(ModelTargetListener listener)
   {
     this.modelTargetListener = listener;
   }
 
   public void setModelo(FormModel model) {
     this.model = model;
   }
 
   public FormModel getModelo()
   {
     if (this.model != null)
       return this.model;
     Class asociatedModelClass = getAsociatedModel();
     if (asociatedModelClass == null)
       return super.getModelo();
     this.model = FormModelUtils.wrap(ClassUtils.newInstance(asociatedModelClass));
     return this.model;
   }
 
   public final FormComponent setNotVisibleOn(Predicate predicate) {
     this.invisiblePredicate = predicate;
     return this;
   }
 
   public FormComponent setDisableOn(Predicate predicate) {
     this.disablePredicate = predicate;
     return this;
   }
 
   public void refreshComponent()
   {
     CollectionUtils.forAllDo(getAllComponents(), new RefreshClosure());
     checkVisivility();
   }
 
   private void checkVisivility()
   {
     setVisible(!this.invisiblePredicate.evaluate(getModelo()));
   }
 
   public final void setVisible(boolean b) {
     super.setVisible(b);
     if (b)
       this.modelTargetListener.load(null);
   }
 
   public void impactModel(boolean validate) {
     super.impactModel(validate);
     this.modelTargetListener.unLoad(this.model);
   }
 
   protected void registerGroupActions(FormActionBuilder builder)
   {
   }
 
   public boolean isColumnComponent()
   {
     return false; } 
   protected abstract Class getAsociatedModel();
 
   protected abstract void registerGroupElements(FormElementsBuilder paramFormElementsBuilder);
 
   private class RefreshClosure implements Closure { private AbstractGroup.CheckEnabilityClosure enableClosure = new AbstractGroup.CheckEnabilityClosure();
 
     private RefreshClosure() {  }
 
     public void execute(Object arg0) { FormComponent element = (FormComponent)arg0;
       element.refreshComponent();
       this.enableClosure.execute(arg0); } }
 
   private class CheckEnabilityClosure implements Closure {
     private CheckEnabilityClosure() {
     }
 
     public void execute(Object object) {
       FormComponent element = (FormComponent)object;
       if (!AbstractGroup.this.disablePredicate.equals(FalsePredicate.INSTANCE)) {
         boolean result = AbstractGroup.this.disablePredicate.evaluate(AbstractGroup.this.getModelo().getValue());
         element.setEnabled(!result);
       }
     }
   }
 }

