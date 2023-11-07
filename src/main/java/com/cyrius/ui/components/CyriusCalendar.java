package com.cyrius.ui.components;

import java.util.GregorianCalendar;

import org.apache.commons.collections4.Predicate;

import com.framework.components.FormComponent;
import com.framework.components.FormValueSelectionContainer;
import com.framework.components.listeners.ModelTargetListener;
import com.framework.components.listeners.NullModelTargetListener;
import com.framework.print.builder.PrintableElementsBuilder;
import com.standbysoft.datepicker.DateSelectionModel;
import com.standbysoft.datepicker.JMonthView;

public class CyriusCalendar extends JMonthView
        implements FormValueSelectionContainer {
    private DateSelectionModel dateSelectionModel;
    private Predicate visibleCondition;
    private ModelTargetListener modelTargetListener = NullModelTargetListener.getInstance();

    public CyriusCalendar() {
    }

    public CyriusCalendar(DateSelectionModel dateSelectionModel) {
        this.dateSelectionModel = dateSelectionModel;
    }

  public Object getValor()
  {
    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    gregorianCalendar.setTime(
      getDateSelectionModel().getLeadSelectionDate());
    return gregorianCalendar;
  }

    public void refreshComponent() {
        this.modelTargetListener.load(null);
    }

    public boolean hasVisibleCondition() {
        return this.visibleCondition != null;
    }

    public FormComponent setNotVisibleOn(Predicate condition) {
        this.visibleCondition = condition;
        return this;
    }

    public void initComponent() {
        getDateSelectionModel().setSelectionMode(
                DateSelectionModel.SelectionMode.SINGLE);
        // setDisplayToday(false); TODO
        setWeekNumbersVisible(false);
        setDateSelectionModel(this.dateSelectionModel);
    }

    public void addModelTargetListener(ModelTargetListener listener) {
        this.modelTargetListener = listener;
    }

    public void setValue(Object model) {
    }

    public boolean isEmpty() {
        return getValor() == null;
    }

    public void impactModel(boolean validate) {
        this.modelTargetListener.unLoad(null);
    }

    public boolean isColumnComponent() {
        return false;
    }

    public void direct(PrintableElementsBuilder print) {
    }

    public FormComponent setDisableOn(Predicate condition) {
        throw new RuntimeException("Under Construction:" + getClass());
    }

    public void setFull() {
    }

    public void setNotFull() {
    }
}

/*
 * Location: E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name: com.cyrius.ui.components.CyriusCalendar
 * JD-Core Version: 0.6.0
 */