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
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JMenuBar;
/*     */ 
/*     */ public class JFrameWrapper
/*     */   implements UseCaseImplementation
/*     */ {
/*     */   private JFrame frame;
/*  47 */   private WindowListener closeUseCaseWindowListener = new WindowAdapter() { } ;
/*     */ 
/*  52 */   private Collection<RefreshListener> refreshListeners = CollectionFactory.createCollection(RefreshListener.class);
/*     */ 
/*  55 */   private Collection<ImpactModelListener> imapactModelListeners = CollectionFactory.createCollection(ImpactModelListener.class);
/*     */ 
/*  58 */   private Collection<ModelChangeListener> modelChangeListeners = CollectionFactory.createCollection(ModelChangeListener.class);
/*     */   private FormModel formModel;
/*     */   private Class asociatedModel;
/*     */   private SimpleModelTarget returnTarget;
/*     */   private PanelsRegistry panelsRegistry;
/*     */ 
/*     */   public JFrameWrapper(JFrame frame)
/*     */   {
/*  71 */     this.frame = frame;
/*  72 */     this.frame.setExtendedState(6);
/*  73 */     this.frame.setDefaultCloseOperation(0);
/*     */   }
/*     */ 
/*     */   public Window getWraped() {
/*  77 */     return this.frame;
/*     */   }
/*     */ 
/*     */   public void setTitle(String valueOf) {
/*  81 */     this.frame.setTitle(valueOf);
/*     */   }
/*     */ 
/*     */   public void setSize(Dimension dimension)
/*     */   {
/*  86 */     this.frame.setSize(dimension);
/*     */   }
/*     */ 
/*     */   public void setLocation(Point point) {
/*  90 */     this.frame.setLocation(point);
/*     */   }
/*     */ 
/*     */   public void setContentPane(Container panel) {
/*  94 */     this.frame.setContentPane(panel);
/*     */   }
/*     */ 
/*     */   public void setJMenuBar(JMenuBar bar)
/*     */   {
/*  99 */     this.frame.setJMenuBar(bar);
/*     */   }
/*     */ 
/*     */   public FrameworkTabbedPane getContentPane()
/*     */   {
/* 104 */     return (FrameworkTabbedPane)this.frame.getContentPane();
/*     */   }
/*     */ 
/*     */   public boolean isVisible() {
/* 108 */     return this.frame.isVisible();
/*     */   }
/*     */ 
/*     */   public void setVisible(boolean b) {
/* 112 */     this.frame.setVisible(b);
/*     */   }
/*     */ 
/*     */   public Dimension getSize()
/*     */   {
/* 117 */     return this.frame.getSize();
/*     */   }
/*     */ 
/*     */   public Class getAsociatedModel() {
/* 121 */     return this.asociatedModel;
/*     */   }
/*     */ 
/*     */   public void setAsociatedModel(Class asociatedModel) {
/* 125 */     this.asociatedModel = asociatedModel;
/*     */   }
/*     */ 
/*     */   public void refreshComponent()
/*     */   {
/* 132 */     CollectionUtils.forAllDo(this.refreshListeners, 
/* 133 */       new ExecuteRefreshListenerClosure());
/*     */   }
/*     */ 
/*     */   public void turnOff() {
/* 137 */     this.frame.setVisible(false);
/*     */   }
/*     */ 
/*     */   public void setBackground(Color c) {
/* 141 */     this.frame.setBackground(c);
/*     */   }
/*     */ 
/*     */   public void setForeground(Color c)
/*     */   {
/* 146 */     this.frame.setForeground(c);
/*     */   }
/*     */ 
/*     */   public void setLocation(int x, int y)
/*     */   {
/* 151 */     this.frame.setLocation(x, y);
/*     */   }
/*     */ 
/*     */   public void setEnabled(boolean b)
/*     */   {
/* 156 */     this.frame.setEnabled(b);
/*     */   }
/*     */ 
/*     */   public void setCursor(Cursor cursor)
/*     */   {
/* 161 */     this.frame.setCursor(cursor);
/*     */   }
/*     */ 
/*     */   public void setPreferredSize(Dimension dimension) {
/* 165 */     this.frame.setPreferredSize(dimension);
/*     */   }
/*     */ 
/*     */   public void setModelo(FormModel model)
/*     */   {
/* 173 */     this.formModel = model;
/* 174 */     CollectionUtils.forAllDo(this.modelChangeListeners, 
/* 175 */       new ExecuteModelChangeListenerClosure());
/*     */   }
/*     */ 
/*     */   public FormModel getModelo() {
/* 179 */     if (this.formModel != null)
/* 180 */       return this.formModel;
/*     */     try {
/* 182 */       this.formModel = FormModelUtils.wrap(
/* 183 */         getAsociatedModel().newInstance());
/*     */     } catch (Exception e) {
/* 185 */       throw new RuntimeException(e);
/*     */     }
/* 187 */     return this.formModel;
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate)
/*     */   {
/* 192 */     NotFullFormExceptionBuilder builder = new NotFullFormExceptionBuilder();
/* 193 */     ImpactModelClosure closure = new ImpactModelClosure(validate);
/* 194 */     for (Iterator iter = this.imapactModelListeners.iterator(); iter
/* 195 */       .hasNext(); ) {
/*     */       try
/*     */       {
/* 197 */         closure.execute(iter.next());
/*     */       } catch (NotFullFormException nffe) {
/* 199 */         builder.add(nffe);
/*     */       }
/*     */     }
/* 202 */     if (builder.hasException())
/* 203 */       throw builder.build();
/*     */   }
/*     */ 
/*     */   public SimpleModelTarget getOpenTarget() {
/* 207 */     return new SimpleUseCaseTargetDecorator(this);
/*     */   }
/*     */ 
/*     */   public void addModelChangeListener(ModelChangeListener modelChangeListener) {
/* 211 */     this.modelChangeListeners.add(modelChangeListener);
/*     */   }
/*     */ 
/*     */   public void addRefreshListener(RefreshListener refreshListener) {
/* 215 */     this.refreshListeners.add(refreshListener);
/*     */   }
/*     */ 
/*     */   public SimpleModelTarget getReturnTarget() {
/* 219 */     return this.returnTarget == null ? 
/* 220 */       new CloseAndSaveUseCaseTargetDecorator(this) : 
/* 221 */       new CloseAndSaveUseCaseTargetDecorator(this, 
/* 221 */       this.returnTarget);
/*     */   }
/*     */ 
/*     */   public void setReturnTarget(SimpleModelTarget modelTargetDecorator)
/*     */   {
/* 232 */     this.returnTarget = modelTargetDecorator;
/*     */   }
/*     */ 
/*     */   public ModelTargetEnableContainer getContainer()
/*     */   {
/* 237 */     return this;
/*     */   }
/*     */ 
/*     */   public void addImapactModelListeners(ImpactModelListener impactModelListener) {
/* 241 */     this.imapactModelListeners.add(impactModelListener);
/*     */   }
/*     */ 
/*     */   public void nextPanel() {
/* 245 */     getContentPane().next();
/*     */   }
/*     */ 
/*     */   public void previousPanel() {
/* 249 */     getContentPane().previous();
/*     */   }
/*     */ 
/*     */   public void startUseCase() {
/* 253 */     this.frame.addWindowListener(this.closeUseCaseWindowListener);
/*     */   }
/*     */ 
/*     */   public PanelsRegistry getPanelsRegistry()
/*     */   {
/* 258 */     throw new RuntimeException("Esto no deberia estar aca");
/*     */   }
/*     */ 
/*     */   public Container getPanel()
/*     */   {
/* 263 */     return getContentPane();
/*     */   }
/*     */ 
/*     */   public LayoutManager getLayout() {
/* 267 */     return getPanel().getLayout();
/*     */   }
/*     */ 
/*     */   public Container getParent() {
/* 271 */     return (Container)getContainer();
/*     */   }
/*     */ 
/*     */   public void setPadre(RefreshableComponent useCaseParent)
/*     */   {
/* 276 */     throw new RuntimeException("This frame cannot be inside another frame");
/*     */   }
/*     */ 
/*     */   public boolean isRestartable()
/*     */   {
/* 281 */     return false;
/*     */   }
/*     */ 
/*     */   public void restart()
/*     */   {
/* 289 */     throw new UnsupportedOperationException("Ver porque estaesto");
/*     */   }
/*     */ 
/*     */   public boolean isStarted() {
/* 293 */     return isVisible();
/*     */   }
/*     */ 
/*     */   public void addPanel(AbstractPanel panel) {
/* 297 */     getContentPane().add(panel);
/*     */   }
/*     */ 
/*     */   public void add(Component component, Object string)
/*     */   {
/* 302 */     getContentPane().add(component, string);
/*     */   }
/*     */ 
/*     */   public void setDefaultCloseOperation(int operation) {
/* 306 */     this.frame.setDefaultCloseOperation(operation);
/*     */   }
/*     */ 
/*     */   public void setMinimumSize(Dimension dimension) {
/* 310 */     this.frame.setMinimumSize(dimension);
/*     */   }
/*     */ 
/*     */   public void setPanelRegistry(PanelsRegistry panelsRegistry) {
/* 314 */     this.panelsRegistry = panelsRegistry;
/*     */   }
/*     */ 
/*     */   public Iterator panelsIterator() {
/* 318 */     return this.panelsRegistry.panelsIterator();
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 322 */     return this.frame.getTitle();
/*     */   }
/*     */ 
/*     */   public void setCloseAction(FormAction action) {
/* 326 */     this.closeUseCaseWindowListener = new CloseUseCaseWindowListener(action);
/*     */   }
/*     */ 
/*     */   public void setIcon(Image icon) {
/* 330 */     this.frame.setIconImage(icon);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.wrappers.JFrameWrapper
 * JD-Core Version:    0.6.0
 */