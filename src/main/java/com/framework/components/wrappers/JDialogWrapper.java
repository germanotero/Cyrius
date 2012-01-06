/*     */ package com.framework.components.wrappers;
/*     */ 
/*     */ import com.framework.abstractfactorys.AbstractPanel;
/*     */ import com.framework.abstractfactorys.FrameworkTabbedPane;
/*     */ import com.framework.abstractfactorys.PanelsRegistry;
/*     */ import com.framework.actions.CloseAndSaveUseCaseTargetDecorator;
/*     */ import com.framework.actions.FormAction;
/*     */ import com.framework.actions.SimpleModelTarget;
/*     */ import com.framework.actions.SimpleUseCaseTargetDecorator;
/*     */ import com.framework.components.ModelTargetEnableContainer;
/*     */ import com.framework.components.RefreshableComponent;
/*     */ import com.framework.components.listeners.ModelChangeListener;
/*     */ import com.framework.entities.FormModelUtils;
/*     */ import com.framework.exceptions.NotFullFormException;
/*     */ import com.framework.exceptions.NotFullFormExceptionBuilder;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.utils.CollectionFactory;
/*     */ import com.framework.utils.CollectionUtils;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Image;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.Point;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowListener;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JMenuBar;
/*     */ 
/*     */ public class JDialogWrapper
/*     */   implements UseCaseImplementation
/*     */ {
/*  44 */   private WindowListener closeUseCaseWindowListener = new WindowAdapter() { } ;
/*     */   private JDialog dialog;
/*  50 */   private Collection<RefreshListener> refreshListeners = CollectionFactory.createCollection(RefreshListener.class);
/*     */ 
/*  53 */   private Collection<ImpactModelListener> imapactModelListeners = CollectionFactory.createCollection(ImpactModelListener.class);
/*     */ 
/*  56 */   private Collection<ModelChangeListener> modelChangeListeners = CollectionFactory.createCollection(ModelChangeListener.class);
/*     */   private PanelsRegistry panelsRegistry;
/*     */   private FormModel formModel;
/*     */   private Class asociatedModel;
/*     */   private SimpleModelTarget returnTarget;
/*     */ 
/*     */   public JDialogWrapper(JFrame parent)
/*     */   {
/*  69 */     this.dialog = new JDialog(parent);
/*     */   }
/*     */ 
/*     */   public JDialogWrapper(JDialog parent)
/*     */   {
/*  74 */     this.dialog = new JDialog(parent);
/*  75 */     this.dialog.setDefaultCloseOperation(0);
/*     */   }
/*     */ 
/*     */   public JDialogWrapper()
/*     */   {
/*  80 */     this.dialog = new JDialog();
/*     */   }
/*     */ 
/*     */   public Window getWraped() {
/*  84 */     return this.dialog;
/*     */   }
/*     */ 
/*     */   public void setTitle(String valueOf) {
/*  88 */     this.dialog.setTitle(valueOf);
/*     */   }
/*     */ 
/*     */   public void setSize(Dimension dimension)
/*     */   {
/*  93 */     this.dialog.setSize(dimension);
/*     */   }
/*     */ 
/*     */   public void setLocation(Point point) {
/*  97 */     this.dialog.setLocation(point);
/*     */   }
/*     */ 
/*     */   public void setContentPane(Container panel) {
/* 101 */     this.dialog.setContentPane(panel);
/*     */   }
/*     */ 
/*     */   public void setJMenuBar(JMenuBar bar)
/*     */   {
/* 106 */     this.dialog.setJMenuBar(bar);
/*     */   }
/*     */ 
/*     */   public FrameworkTabbedPane getContentPane()
/*     */   {
/* 111 */     return (FrameworkTabbedPane)this.dialog.getContentPane();
/*     */   }
/*     */ 
/*     */   public boolean isVisible() {
/* 115 */     return this.dialog.isVisible();
/*     */   }
/*     */ 
/*     */   public void setVisible(boolean b) {
/* 119 */     this.dialog.setVisible(b);
/*     */   }
/*     */ 
/*     */   public Dimension getSize()
/*     */   {
/* 124 */     return this.dialog.getSize();
/*     */   }
/*     */ 
/*     */   public Class getAsociatedModel() {
/* 128 */     return this.asociatedModel;
/*     */   }
/*     */ 
/*     */   public void setAsociatedModel(Class asociatedModel) {
/* 132 */     this.asociatedModel = asociatedModel;
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/* 139 */     CollectionUtils.forAllDo(this.refreshListeners, new ExecuteRefreshListenerClosure());
/*     */   }
/*     */ 
/*     */   public void turnOff() {
/* 143 */     this.dialog.setVisible(false);
/*     */   }
/*     */ 
/*     */   public void setBackground(Color c) {
/* 147 */     this.dialog.setBackground(c);
/*     */   }
/*     */ 
/*     */   public void setForeground(Color c)
/*     */   {
/* 152 */     this.dialog.setForeground(c);
/*     */   }
/*     */ 
/*     */   public void setLocation(int x, int y)
/*     */   {
/* 157 */     this.dialog.setLocation(x, y);
/*     */   }
/*     */ 
/*     */   public void setEnabled(boolean b)
/*     */   {
/* 162 */     this.dialog.setEnabled(b);
/*     */   }
/*     */ 
/*     */   public void setCursor(Cursor cursor)
/*     */   {
/* 167 */     this.dialog.setCursor(cursor);
/*     */   }
/*     */ 
/*     */   public void setPreferredSize(Dimension dimension) {
/* 171 */     this.dialog.setPreferredSize(dimension);
/*     */   }
/*     */ 
/*     */   public void setModelo(FormModel model)
/*     */   {
/* 179 */     this.formModel = model;
/* 180 */     CollectionUtils.forAllDo(this.modelChangeListeners, new ExecuteModelChangeListenerClosure());
/*     */   }
/*     */ 
/*     */   public FormModel getModelo() {
/* 184 */     if (this.formModel != null)
/* 185 */       return this.formModel;
/*     */     try {
/* 187 */       this.formModel = FormModelUtils.wrap(getAsociatedModel().newInstance());
/*     */     } catch (Exception e) {
/* 189 */       throw new RuntimeException(e);
/*     */     }
/* 191 */     return this.formModel;
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate)
/*     */   {
/* 196 */     NotFullFormExceptionBuilder builder = new NotFullFormExceptionBuilder();
/* 197 */     ImpactModelClosure closure = new ImpactModelClosure(validate);
/* 198 */     for (Iterator iter = this.imapactModelListeners.iterator(); iter.hasNext(); ) {
/*     */       try {
/* 200 */         closure.execute(iter.next());
/*     */       } catch (NotFullFormException nffe) {
/* 202 */         builder.add(nffe);
/*     */       }
/*     */     }
/* 205 */     if (builder.hasException())
/* 206 */       throw builder.build();
/*     */   }
/*     */ 
/*     */   public SimpleModelTarget getOpenTarget() {
/* 210 */     return new SimpleUseCaseTargetDecorator(this);
/*     */   }
/*     */ 
/*     */   public void addModelChangeListener(ModelChangeListener modelChangeListener) {
/* 214 */     this.modelChangeListeners.add(modelChangeListener);
/*     */   }
/*     */ 
/*     */   public void addRefreshListener(RefreshListener refreshableListener) {
/* 218 */     this.refreshListeners.add(refreshableListener);
/*     */   }
/*     */ 
/*     */   public SimpleModelTarget getReturnTarget() {
/* 222 */     return this.returnTarget == null ? new CloseAndSaveUseCaseTargetDecorator(this) : 
/* 223 */       new CloseAndSaveUseCaseTargetDecorator(this, this.returnTarget);
/*     */   }
/*     */ 
/*     */   public void setReturnTarget(SimpleModelTarget modelTargetDecorator) {
/* 227 */     this.returnTarget = modelTargetDecorator;
/*     */   }
/*     */ 
/*     */   public ModelTargetEnableContainer getContainer()
/*     */   {
/* 232 */     return this;
/*     */   }
/*     */ 
/*     */   public void addImapactModelListeners(ImpactModelListener impactModelListener) {
/* 236 */     this.imapactModelListeners.add(impactModelListener);
/*     */   }
/*     */ 
/*     */   public void nextPanel() {
/* 240 */     getContentPane().next();
/*     */   }
/*     */ 
/*     */   public void previousPanel() {
/* 244 */     getContentPane().previous();
/*     */   }
/*     */ 
/*     */   public void startUseCase() {
/* 248 */     this.dialog.addWindowListener(this.closeUseCaseWindowListener);
/*     */   }
/*     */ 
/*     */   public PanelsRegistry getPanelsRegistry()
/*     */   {
/* 253 */     throw new RuntimeException("Esto no deberia estar aca");
/*     */   }
/*     */ 
/*     */   public Container getPanel()
/*     */   {
/* 258 */     return getContentPane();
/*     */   }
/*     */ 
/*     */   public LayoutManager getLayout() {
/* 262 */     return getPanel().getLayout();
/*     */   }
/*     */ 
/*     */   public Container getParent() {
/* 266 */     return (Container)getContainer();
/*     */   }
/*     */ 
/*     */   public void setPadre(RefreshableComponent useCaseParent)
/*     */   {
/* 271 */     throw new RuntimeException("This dialog cannot be inside another frame");
/*     */   }
/*     */ 
/*     */   public boolean isRestartable()
/*     */   {
/* 276 */     return false;
/*     */   }
/*     */ 
/*     */   public void restart()
/*     */   {
/* 283 */     throw new UnsupportedOperationException("No se para que esta esto...");
/*     */   }
/*     */ 
/*     */   public boolean isStarted() {
/* 287 */     return isVisible();
/*     */   }
/*     */ 
/*     */   public void addPanel(AbstractPanel panel) {
/* 291 */     getContentPane().add(panel);
/*     */   }
/*     */ 
/*     */   public void add(Component component, Object string)
/*     */   {
/* 296 */     getContentPane().add(component, string);
/*     */   }
/*     */ 
/*     */   public void setDefaultCloseOperation(int operation) {
/* 300 */     this.dialog.setDefaultCloseOperation(operation);
/*     */   }
/*     */ 
/*     */   public void setMinimumSize(Dimension dimension) {
/* 304 */     this.dialog.setMinimumSize(dimension);
/*     */   }
/*     */ 
/*     */   public void setPanelRegistry(PanelsRegistry panelsRegistry) {
/* 308 */     this.panelsRegistry = panelsRegistry;
/*     */   }
/*     */ 
/*     */   public Iterator panelsIterator() {
/* 312 */     return this.panelsRegistry.panelsIterator();
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 316 */     return this.dialog.getTitle();
/*     */   }
/*     */ 
/*     */   public void setCloseAction(FormAction action)
/*     */   {
/* 321 */     this.closeUseCaseWindowListener = new CloseUseCaseWindowListener(action);
/*     */   }
/*     */ 
/*     */   public void setIcon(Image icon)
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.wrappers.JDialogWrapper
 * JD-Core Version:    0.6.0
 */