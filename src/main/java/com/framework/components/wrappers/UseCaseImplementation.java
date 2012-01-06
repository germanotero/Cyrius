package com.framework.components.wrappers;

import com.framework.abstractfactorys.FrameworkTabbedPane;
import com.framework.abstractfactorys.PanelsRegistry;
import com.framework.actions.SimpleModelTarget;
import com.framework.components.RefreshableComponent;
import com.framework.components.listeners.ModelChangeListener;
import com.framework.factorys.NavigableUseCase;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Window;
import java.util.Iterator;
import javax.swing.JMenuBar;

public abstract interface UseCaseImplementation extends RefreshableComponent, NavigableUseCase
{
  public abstract Window getWraped();

  public abstract void setTitle(String paramString);

  public abstract void setSize(Dimension paramDimension);

  public abstract void setLocation(Point paramPoint);

  public abstract void setContentPane(Container paramContainer);

  public abstract void setJMenuBar(JMenuBar paramJMenuBar);

  public abstract FrameworkTabbedPane getContentPane();

  public abstract boolean isVisible();

  public abstract void setVisible(boolean paramBoolean);

  public abstract Dimension getSize();

  public abstract Class getAsociatedModel();

  public abstract void addModelChangeListener(ModelChangeListener paramModelChangeListener);

  public abstract void addRefreshListener(RefreshListener paramRefreshListener);

  public abstract void addImapactModelListeners(ImpactModelListener paramImpactModelListener);

  public abstract void setReturnTarget(SimpleModelTarget paramSimpleModelTarget);

  public abstract void setAsociatedModel(Class paramClass);

  public abstract void setDefaultCloseOperation(int paramInt);

  public abstract void setPanelRegistry(PanelsRegistry paramPanelsRegistry);

  public abstract Iterator panelsIterator();

  public abstract String getName();

  public abstract void setIcon(Image paramImage);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.components.wrappers.UseCaseImplementation
 * JD-Core Version:    0.6.0
 */