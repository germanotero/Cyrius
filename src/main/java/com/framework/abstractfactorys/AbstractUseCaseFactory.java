/*     */ package com.framework.abstractfactorys;
/*     */ 
/*     */ import com.framework.actions.SimpleModelTarget;
/*     */ import com.framework.components.builders.impl.MenuBarBuilderImpl;
/*     */ import com.framework.components.builders.impl.UseCaseBuilderImpl;
/*     */ import com.framework.components.builders.interfaces.MenuBarBuilder;
/*     */ import com.framework.components.builders.interfaces.UseCaseBuilder;
/*     */ import com.framework.components.listeners.ModelChangeListener;
/*     */ import com.framework.components.wrappers.ImpactModelListener;
/*     */ import com.framework.components.wrappers.RefreshListener;
/*     */ import com.framework.components.wrappers.UseCaseImplementation;
/*     */ import com.framework.models.FormModel;
/*     */ import com.framework.utils.StringProvider;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Image;
/*     */ import java.awt.Point;
/*     */ import java.awt.Toolkit;
/*     */ 
/*     */ public abstract class AbstractUseCaseFactory
/*     */ {
/*     */   private FrameworkPanel panel;
/*     */   private UseCaseBuilderImpl builder;
/*     */   private UseCaseImplementation internalWindow;
/*  38 */   private boolean disablePanelsEnable = false;
/*     */   private PanelsRegistry panelRegistry;
/*     */   private String name;
/*  44 */   private boolean multiplePanels = false;
/*     */ 
/*     */   public void setMultiplePanels(boolean multiplePanels)
/*     */   {
/*  51 */     this.multiplePanels = multiplePanels;
/*     */   }
/*     */ 
/*     */   public void setInternalWindow(UseCaseImplementation internalWindow) {
/*  55 */     this.internalWindow = internalWindow;
/*     */   }
/*     */ 
/*     */   public UseCaseImplementation getInternalWindow() {
/*  59 */     return this.internalWindow;
/*     */   }
/*     */ 
/*     */   public void setTabPopUp(boolean value)
/*     */   {
/*  67 */     this.disablePanelsEnable = value;
/*     */   }
/*     */ 
/*     */   protected void initGui() {
/*  71 */     if (this.name == null) {
/*  72 */       this.internalWindow.setTitle(
/*  73 */         StringProvider.getInstance().getValueOf(getClass().getName()));
/*     */     }
/*  75 */     this.internalWindow.setSize(setUseCaseDimension());
/*     */ 
/*  77 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*     */ 
/*  79 */     int resAncho = (int)screenSize.getWidth();
/*  80 */     int resAlto = (int)screenSize.getHeight();
/*  81 */     int x = (int)this.internalWindow.getSize().getWidth();
/*  82 */     int y = (int)this.internalWindow.getSize().getHeight();
/*     */ 
/*  84 */     this.internalWindow.setLocation(
/*  85 */       new Point(resAncho / 2 - x / 2, 
/*  85 */       resAlto / 2 - y / 2));
/*  86 */     this.internalWindow.setIcon(getIcon());
/*  87 */     this.internalWindow.setVisible(true);
/*     */   }
/*     */ 
/*     */   protected Image getIcon() {
/*  91 */     return null;
/*     */   }
/*     */ 
/*     */   protected Dimension setUseCaseDimension()
/*     */   {
/*  99 */     return new Dimension(1000, 650);
/*     */   }
/*     */ 
/*     */   public void startUseCase() throws Exception {
/* 103 */     initComponents();
/* 104 */     initGui();
/* 105 */     this.internalWindow.startUseCase();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 112 */     if (this.multiplePanels)
/* 113 */       this.panel = new FrameworkTabbedPane(this);
/*     */     else
/* 115 */       this.panel = new FrameworkPanelImpl();
/* 116 */     this.panel.setDisableEnable(this.disablePanelsEnable);
/* 117 */     this.internalWindow.setContentPane((Container)this.panel);
/* 118 */     this.internalWindow.setAsociatedModel(getAsociatedModel());
/*     */ 
/* 120 */     this.builder = new UseCaseBuilderImpl(this);
/*     */ 
/* 122 */     registerFactorys(this.builder);
/* 123 */     this.builder.build();
/*     */ 
/* 125 */     MenuBarBuilderImpl menuBuilder = new MenuBarBuilderImpl(
/* 126 */       this.internalWindow);
/* 127 */     addMenuBar(menuBuilder);
/* 128 */     this.internalWindow.setJMenuBar(menuBuilder.build());
/*     */ 
/* 130 */     this.panel.initComponent();
/*     */ 
/* 135 */     this.internalWindow.addModelChangeListener(new ModelChangeListener()
/*     */     {
/*     */       public void modelChanged()
/*     */       {
/* 140 */         AbstractUseCaseFactory.this.internalWindow.refreshComponent();
/*     */       }
/*     */     });
/* 144 */     this.internalWindow.setPanelRegistry(this.panelRegistry);
/*     */   }
/*     */ 
/*     */   protected void addMenuBar(MenuBarBuilder menuBuilder)
/*     */   {
/*     */   }
/*     */ 
/*     */   public Container getPanel()
/*     */   {
/* 156 */     return (Container)this.panel;
/*     */   }
/*     */ 
/*     */   public boolean isRestartable()
/*     */   {
/* 164 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isStarted()
/*     */   {
/* 171 */     return this.internalWindow.isVisible();
/*     */   }
/*     */ 
/*     */   public abstract void registerFactorys(UseCaseBuilder paramUseCaseBuilder);
/*     */ 
/*     */   public void addPanel(String name,final AbstractPanel panel)
/*     */   {
/* 186 */     this.panel.addTab(name, panel);
/* 187 */     this.internalWindow.addRefreshListener(new RefreshListener()
/*     */     {
/*     */       public void isRefleshing() {
/* 190 */         panel.refreshComponent();
/*     */       }
/*     */     });
/* 193 */     this.internalWindow.addImapactModelListeners(new ImpactModelListener()
/*     */     {
/*     */       public void impactingToModel(boolean validate) {
/* 196 */         panel.impactModel(validate);
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public abstract Class getAsociatedModel();
/*     */ 
/*     */   public void turnOff()
/*     */   {
/* 212 */     this.internalWindow.setVisible(false);
/*     */   }
/*     */ 
/*     */   public void setModelo(FormModel modelo) {
/* 216 */     this.internalWindow.setModelo(modelo);
/*     */   }
/*     */ 
/*     */   public void setReturnTarget(SimpleModelTarget modelTargetDecorator) {
/* 220 */     this.internalWindow.setReturnTarget(modelTargetDecorator);
/*     */   }
/*     */ 
/*     */   public void setPanelRegistry(PanelsRegistry registry) {
/* 224 */     this.panelRegistry = registry;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 228 */     this.name = name;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.AbstractUseCaseFactory
 * JD-Core Version:    0.6.0
 */