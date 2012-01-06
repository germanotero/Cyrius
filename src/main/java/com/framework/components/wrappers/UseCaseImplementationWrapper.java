/*     */ package com.framework.components.wrappers;
/*     */ 
/*     */ import com.framework.abstractfactorys.AbstractPanel;
/*     */ import com.framework.abstractfactorys.FrameworkTabbedPane;
/*     */ import com.framework.abstractfactorys.PanelsRegistry;
/*     */ import com.framework.actions.FormAction;
/*     */ import com.framework.actions.SimpleModelTarget;
/*     */ import com.framework.components.ModelTargetEnableContainer;
/*     */ import com.framework.components.RefreshableComponent;
/*     */ import com.framework.components.listeners.ModelChangeListener;
/*     */ import com.framework.models.FormModel;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Image;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.Point;
/*     */ import java.awt.Window;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.JMenuBar;
/*     */ 
/*     */ public class UseCaseImplementationWrapper
/*     */   implements UseCaseImplementation
/*     */ {
/*     */   private UseCaseImplementation useCaseImplementation;
/*     */   private SimpleModelTarget returnTarget;
/*     */   private SimpleModelTarget openTarget;
/*     */ 
/*     */   public UseCaseImplementationWrapper(UseCaseImplementation useCaseImplementation)
/*     */   {
/*  36 */     this.useCaseImplementation = useCaseImplementation;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  40 */     return this.useCaseImplementation.getName();
/*     */   }
/*     */ 
/*     */   public Window getWraped() {
/*  44 */     return this.useCaseImplementation.getWraped();
/*     */   }
/*     */ 
/*     */   public void setTitle(String valueOf) {
/*  48 */     this.useCaseImplementation.setTitle(valueOf);
/*     */   }
/*     */ 
/*     */   public void setSize(Dimension dimension) {
/*  52 */     this.useCaseImplementation.setSize(dimension);
/*     */   }
/*     */ 
/*     */   public void setLocation(Point point) {
/*  56 */     this.useCaseImplementation.setLocation(point);
/*     */   }
/*     */ 
/*     */   public void setContentPane(Container panel) {
/*  60 */     this.useCaseImplementation.setContentPane(panel);
/*     */   }
/*     */ 
/*     */   public void setJMenuBar(JMenuBar bar)
/*     */   {
/*  65 */     this.useCaseImplementation.setJMenuBar(bar);
/*     */   }
/*     */ 
/*     */   public FrameworkTabbedPane getContentPane() {
/*  69 */     return this.useCaseImplementation.getContentPane();
/*     */   }
/*     */ 
/*     */   public boolean isVisible() {
/*  73 */     return this.useCaseImplementation.isVisible();
/*     */   }
/*     */ 
/*     */   public void setVisible(boolean b) {
/*  77 */     this.useCaseImplementation.setVisible(b);
/*     */   }
/*     */ 
/*     */   public Dimension getSize() {
/*  81 */     return this.useCaseImplementation.getSize();
/*     */   }
/*     */ 
/*     */   public Class getAsociatedModel() {
/*  85 */     return this.useCaseImplementation.getAsociatedModel();
/*     */   }
/*     */ 
/*     */   public void addModelChangeListener(ModelChangeListener modelChangeListener) {
/*  89 */     this.useCaseImplementation.addModelChangeListener(modelChangeListener);
/*     */   }
/*     */ 
/*     */   public void addRefreshListener(RefreshListener refreshableComponent) {
/*  93 */     this.useCaseImplementation.addRefreshListener(refreshableComponent);
/*     */   }
/*     */ 
/*     */   public void addImapactModelListeners(ImpactModelListener impactModelListener) {
/*  97 */     this.useCaseImplementation
/*  98 */       .addImapactModelListeners(impactModelListener);
/*     */   }
/*     */ 
/*     */   public void setReturnTarget(SimpleModelTarget modelTargetDecorator) {
/* 102 */     this.returnTarget = modelTargetDecorator;
/*     */   }
/*     */ 
/*     */   public void setAsociatedModel(Class asociatedModel) {
/* 106 */     this.useCaseImplementation.setAsociatedModel(asociatedModel);
/*     */   }
/*     */ 
/*     */   public void refreshComponent() {
/* 110 */     this.useCaseImplementation.refreshComponent();
/*     */   }
/*     */ 
/*     */   public void turnOff() {
/* 114 */     this.useCaseImplementation.turnOff();
/*     */   }
/*     */ 
/*     */   public ModelTargetEnableContainer getContainer() {
/* 118 */     return this;
/*     */   }
/*     */ 
/*     */   public void setBackground(Color c) {
/* 122 */     this.useCaseImplementation.setBackground(c);
/*     */   }
/*     */ 
/*     */   public void setForeground(Color c)
/*     */   {
/* 127 */     this.useCaseImplementation.setForeground(c);
/*     */   }
/*     */ 
/*     */   public void setLocation(int x, int y) {
/* 131 */     this.useCaseImplementation.setLocation(x, y);
/*     */   }
/*     */ 
/*     */   public void setEnabled(boolean b)
/*     */   {
/* 136 */     this.useCaseImplementation.setEnabled(b);
/*     */   }
/*     */ 
/*     */   public void setCursor(Cursor cursor) {
/* 140 */     this.useCaseImplementation.setCursor(cursor);
/*     */   }
/*     */ 
/*     */   public void setPreferredSize(Dimension dimension) {
/* 144 */     this.useCaseImplementation.setPreferredSize(dimension);
/*     */   }
/*     */ 
/*     */   public FormModel getModelo() {
/* 148 */     return this.useCaseImplementation.getModelo();
/*     */   }
/*     */ 
/*     */   public void setModelo(FormModel model) {
/* 152 */     this.useCaseImplementation.setModelo(model);
/*     */   }
/*     */ 
/*     */   public void impactModel(boolean validate) {
/* 156 */     this.useCaseImplementation.impactModel(validate);
/*     */   }
/*     */ 
/*     */   public SimpleModelTarget getOpenTarget()
/*     */   {
/* 164 */     if (this.openTarget != null)
/* 165 */       return this.openTarget;
/* 166 */     return this.useCaseImplementation.getOpenTarget();
/*     */   }
/*     */ 
/*     */   public void setOpenTarget(SimpleModelTarget openTarget) {
/* 170 */     this.openTarget = openTarget;
/*     */   }
/*     */ 
/*     */   public SimpleModelTarget getReturnTarget() {
/* 174 */     if (this.returnTarget == null)
/* 175 */       return this.useCaseImplementation.getReturnTarget();
/* 176 */     return this.returnTarget;
/*     */   }
/*     */ 
/*     */   public void nextPanel() {
/* 180 */     this.useCaseImplementation.nextPanel();
/*     */   }
/*     */ 
/*     */   public void previousPanel() {
/* 184 */     this.useCaseImplementation.previousPanel();
/*     */   }
/*     */ 
/*     */   public void startUseCase() throws Exception {
/* 188 */     this.useCaseImplementation.startUseCase();
/*     */   }
/*     */ 
/*     */   public PanelsRegistry getPanelsRegistry() {
/* 192 */     return this.useCaseImplementation.getPanelsRegistry();
/*     */   }
/*     */ 
/*     */   public Container getPanel() {
/* 196 */     return this.useCaseImplementation.getPanel();
/*     */   }
/*     */ 
/*     */   public LayoutManager getLayout() {
/* 200 */     return this.useCaseImplementation.getLayout();
/*     */   }
/*     */ 
/*     */   public Container getParent() {
/* 204 */     return this.useCaseImplementation.getParent();
/*     */   }
/*     */ 
/*     */   public void setPadre(RefreshableComponent useCaseParent) {
/* 208 */     this.useCaseImplementation.setPadre(useCaseParent);
/*     */   }
/*     */ 
/*     */   public boolean isRestartable() {
/* 212 */     return this.useCaseImplementation.isRestartable();
/*     */   }
/*     */ 
/*     */   public void restart() {
/* 216 */     this.useCaseImplementation.restart();
/*     */   }
/*     */ 
/*     */   public boolean isStarted() {
/* 220 */     return this.useCaseImplementation.isStarted();
/*     */   }
/*     */ 
/*     */   public void addPanel(AbstractPanel panel) {
/* 224 */     this.useCaseImplementation.addPanel(panel);
/*     */   }
/*     */ 
/*     */   public void add(Component component, Object string) {
/* 228 */     this.useCaseImplementation.add(component, string);
/*     */   }
/*     */ 
/*     */   public void setDefaultCloseOperation(int operation) {
/* 232 */     this.useCaseImplementation.setDefaultCloseOperation(operation);
/*     */   }
/*     */ 
/*     */   public void setMinimumSize(Dimension dimension) {
/* 236 */     this.useCaseImplementation.setMinimumSize(dimension);
/*     */   }
/*     */ 
/*     */   public void setPanelRegistry(PanelsRegistry panelsRegistry) {
/* 240 */     this.useCaseImplementation.setPanelRegistry(panelsRegistry);
/*     */   }
/*     */ 
/*     */   public Iterator panelsIterator() {
/* 244 */     return this.useCaseImplementation.panelsIterator();
/*     */   }
/*     */ 
/*     */   public void setCloseAction(FormAction action) {
/* 248 */     this.useCaseImplementation.setCloseAction(action);
/*     */   }
/*     */ 
/*     */   public void setIcon(Image image) {
/* 252 */     this.useCaseImplementation.setIcon(image);
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.wrappers.UseCaseImplementationWrapper
 * JD-Core Version:    0.6.0
 */