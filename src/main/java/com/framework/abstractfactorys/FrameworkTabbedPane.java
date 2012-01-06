/*     */ package com.framework.abstractfactorys;
/*     */ 
/*     */ import com.framework.components.wrappers.UseCaseImplementation;
/*     */ import com.framework.exceptions.ExceptionHandler;
/*     */ import com.framework.exceptions.NotFullFormException;
/*     */ import com.framework.models.FormModel;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.MenuItem;
/*     */ import java.awt.Point;
/*     */ import java.awt.PopupMenu;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ 
/*     */ public class FrameworkTabbedPane extends JTabbedPane
/*     */   implements FrameworkPanel
/*     */ {
/*  21 */   private static ImageIcon ICON_TAB_COMPLETED = new ImageIcon(
/*  22 */     "Img/ok.gif");
/*     */ 
/*  24 */   private static ImageIcon ICON_TAB_UNCOMPLETED = new ImageIcon(
/*  25 */     "Img/fail.gif");
/*     */ 
/*  27 */   private UseCasePanelPopUpMenu popUpMenu = new UseCasePanelPopUpMenu();
/*     */ 
/*  29 */   private boolean disableEnable = false;
/*     */   private int oldIndex;
/*     */   int selectedTab;
/*     */   private AbstractUseCaseFactory padre;
/*     */ 
/*     */   public FrameworkTabbedPane(AbstractUseCaseFactory factory)
/*     */   {
/*  38 */     this.padre = factory;
/*     */   }
/*     */ 
/*     */   public void initComponent() {
/*  42 */     add(this.popUpMenu);
/*  43 */     addMouseListener(new MouseAdapter() {
/*     */       public void mousePressed(MouseEvent evt) {
/*  45 */         FrameworkTabbedPane.this.selectedTab = FrameworkTabbedPane.this.indexAtLocation(evt.getPoint());
/*  46 */         if ((evt.isPopupTrigger()) && (FrameworkTabbedPane.this.disableEnable) && 
/*  47 */           (FrameworkTabbedPane.this.selectedTab >= 0))
/*  48 */           FrameworkTabbedPane.this.popUpMenu.show(evt.getComponent(), evt.getX(), 
/*  49 */             evt.getY());
/*     */       }
/*     */ 
/*     */       public void mouseReleased(MouseEvent evt)
/*     */       {
/*  55 */         mousePressed(evt);
/*     */       }
/*     */     });
/*  59 */     addChangeListener(new ChangeListener()
/*     */     {
/*     */       public void stateChanged(ChangeEvent e) {
/*     */         try {
/*  63 */           if (((AbstractPanel)FrameworkTabbedPane.this.getComponent(FrameworkTabbedPane.this.oldIndex)).isCompleted())
/*  64 */             FrameworkTabbedPane.this.setIconAt(FrameworkTabbedPane.this.oldIndex, FrameworkTabbedPane.ICON_TAB_COMPLETED);
/*     */           else
/*  66 */             FrameworkTabbedPane.this.setIconAt(FrameworkTabbedPane.this.oldIndex, FrameworkTabbedPane.ICON_TAB_UNCOMPLETED);
/*     */         }
/*     */         catch (NotFullFormException ex) {
/*  69 */           ExceptionHandler.getInstance().handle(ex);
/*     */         }
/*     */       }
/*     */     });
/*  73 */     if (this.padre.getInternalWindow().getModelo().isPersisted())
/*  74 */       for (int i = getTabCount() - 1; i >= 0; i--)
/*     */       {
/*  76 */         if (!((AbstractPanel)getComponentAt(i)).isCompleted())
/*  77 */           disableTab(i);
/*     */         else
/*  79 */           setIconAt(i, ICON_TAB_COMPLETED);
/*     */       }
/*     */   }
/*     */ 
/*     */   public void addTab(String title, Container component)
/*     */   {
/*  86 */     addTab(title, ICON_TAB_UNCOMPLETED, component);
/*     */   }
/*     */ 
/*     */   public void next()
/*     */   {
/*  93 */     setSelectedIndex(getSelectedIndex() + 1);
/*     */   }
/*     */ 
/*     */   public void previous()
/*     */   {
/* 101 */     setSelectedIndex(getSelectedIndex() - 1);
/*     */   }
/*     */ 
/*     */   public int indexAtLocation(Point mousePosition) {
/* 105 */     return indexAtLocation((int)mousePosition.getX(), 
/* 106 */       (int)mousePosition.getY());
/*     */   }
/*     */ 
/*     */   public void setSelectedIndex(int index)
/*     */   {
/* 112 */     this.oldIndex = getSelectedIndex();
/* 113 */     super.setSelectedIndex(index);
/*     */   }
/*     */ 
/*     */   private void disableTab(int tabIndex)
/*     */   {
/* 149 */     setEnabledAt(tabIndex, false);
/* 150 */     getComponent(tabIndex).setEnabled(false);
/*     */   }
/*     */ 
/*     */   public void setDisableEnable(boolean value) {
/* 154 */     this.disableEnable = value;
/*     */   }
/*     */ 
/*     */   private class UseCasePanelPopUpMenu extends PopupMenu
/*     */   {
/* 117 */     MenuItem habilitar = new MenuItem("Habilitar");
/*     */ 
/* 119 */     MenuItem desHabilitar = new MenuItem("Deshabilitar");
/*     */ 
/*     */     public UseCasePanelPopUpMenu()
/*     */     {
/* 123 */       addItems();
/*     */     }
/*     */ 
/*     */     private void addItems() {
/* 127 */       add(this.habilitar);
/* 128 */       add(this.desHabilitar);
/*     */ 
/* 130 */       this.desHabilitar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent arg0) {
/* 133 */           FrameworkTabbedPane.this.disableTab(FrameworkTabbedPane.this.selectedTab);
/*     */         }
/*     */       });
/* 137 */       this.habilitar.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent arg0) {
/* 140 */           FrameworkTabbedPane.this.setEnabledAt(FrameworkTabbedPane.this.selectedTab, true);
/* 141 */           FrameworkTabbedPane.this.getComponent(FrameworkTabbedPane.this.selectedTab).setEnabled(true);
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.abstractfactorys.FrameworkTabbedPane
 * JD-Core Version:    0.6.0
 */