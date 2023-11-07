package com.framework.actions;

import com.framework.exceptions.ExceptionHandler;
import foxtrot.Task;
import foxtrot.Worker;
import java.awt.event.ActionEvent;

public class DefaultActionListener
  implements FrameworkActionListener
{
  private AbstractAction action;

  public void actionPerformed(ActionEvent e)
  {
    try
    {
      this.action.preExecution();
      Worker.post(new Task() {
        public Object run() throws Exception {
          DefaultActionListener.this.action.executeAction(null);
          return null;
        }
      });
      this.action.postExecution();
    } catch (Exception ex) {
      ExceptionHandler.getInstance().handle(ex);
    } finally {
      this.action.rearmOldState();
    }
  }

  public void setAction(AbstractAction action) {
    this.action = action;
  }
}

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.framework.actions.DefaultActionListener
 * JD-Core Version:    0.6.0
 */