package com.framework.factorys;

import com.framework.abstractfactorys.AbstractPanel;
import com.framework.abstractfactorys.PanelsRegistry;
import com.framework.components.RefreshableComponent;
import com.framework.components.TargetEnable;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public abstract interface UseCaseFactory extends RefreshableContainer, RefreshableComponent, TargetEnable
{
  public abstract void startUseCase()
    throws Exception;

  public abstract PanelsRegistry getPanelsRegistry();

  public abstract Container getPanel();

  public abstract Dimension getSize();

  public abstract LayoutManager getLayout();

  public abstract Class getAsociatedModel();

  public abstract Container getParent();

  public abstract void setPadre(RefreshableComponent paramRefreshableComponent);

  public abstract void impactModel(boolean paramBoolean);

  public abstract boolean isRestartable();

  public abstract void restart();

  public abstract boolean isStarted();

  public abstract void addPanel(AbstractPanel paramAbstractPanel);

  public abstract void add(Component paramComponent, Object paramObject);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.factorys.UseCaseFactory
 * JD-Core Version:    0.6.0
 */