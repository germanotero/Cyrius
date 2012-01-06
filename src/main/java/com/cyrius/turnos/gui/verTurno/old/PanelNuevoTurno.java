package com.cyrius.turnos.gui.verTurno.old;

import com.cyrius.entities.Medico;
import javax.swing.JFrame;

public abstract interface PanelNuevoTurno
{
  public abstract PanelNuevoTurno setSelectedIndex(int paramInt);

  public abstract Medico getSelectedMedico();

  public abstract JFrame getFrameParent();

  public abstract PanelNuevoTurno setEnabledAt(int paramInt, boolean paramBoolean);

  public abstract PanelNuevoTurno setMedico(Medico paramMedico);
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.turnos.gui.verTurno.old.PanelNuevoTurno
 * JD-Core Version:    0.6.0
 */