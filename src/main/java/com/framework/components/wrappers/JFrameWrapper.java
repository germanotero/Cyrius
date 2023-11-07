package com.framework.components.wrappers;

import com.framework.abstractfactorys.AbstractPanel;
import com.framework.abstractfactorys.FrameworkTabbedPane;
import com.framework.abstractfactorys.PanelsRegistry;
import com.framework.actions.CloseAndSaveUseCaseTargetDecorator;
import com.framework.actions.FormAction;
import com.framework.actions.SimpleModelTarget;
import com.framework.actions.SimpleUseCaseTargetDecorator;
import com.framework.components.ModelTargetEnableContainer;
import com.framework.components.RefreshableComponent;
import com.framework.components.listeners.ModelChangeListener;
import com.framework.entities.FormModelUtils;
import com.framework.exceptions.NotFullFormException;
import com.framework.exceptions.NotFullFormExceptionBuilder;
import com.framework.models.FormModel;
import com.framework.utils.CollectionFactory;
import com.framework.utils.ExtraCollectionUtils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class JFrameWrapper
        implements UseCaseImplementation {
    private JFrame frame;
    private WindowListener closeUseCaseWindowListener = new WindowAdapter() {
    };

    private Collection<RefreshListener> refreshListeners = CollectionFactory.createCollection(RefreshListener.class);

    private Collection<ImpactModelListener> imapactModelListeners = CollectionFactory
            .createCollection(ImpactModelListener.class);

    private Collection<ModelChangeListener> modelChangeListeners = CollectionFactory
            .createCollection(ModelChangeListener.class);
    private FormModel formModel;
    private Class asociatedModel;
    private SimpleModelTarget returnTarget;
    private PanelsRegistry panelsRegistry;

    public JFrameWrapper(JFrame frame) {
        this.frame = frame;
        this.frame.setExtendedState(6);
        this.frame.setDefaultCloseOperation(0);
    }

    public Window getWraped() {
        return this.frame;
    }

    public void setTitle(String valueOf) {
        this.frame.setTitle(valueOf);
    }

    public void setSize(Dimension dimension) {
        this.frame.setSize(dimension);
    }

    public void setLocation(Point point) {
        this.frame.setLocation(point);
    }

    public void setContentPane(Container panel) {
        this.frame.setContentPane(panel);
    }

    public void setJMenuBar(JMenuBar bar) {
        this.frame.setJMenuBar(bar);
    }

    public FrameworkTabbedPane getContentPane() {
        return (FrameworkTabbedPane) this.frame.getContentPane();
    }

    public boolean isVisible() {
        return this.frame.isVisible();
    }

    public void setVisible(boolean b) {
        this.frame.setVisible(b);
    }

    public Dimension getSize() {
        return this.frame.getSize();
    }

    public Class getAsociatedModel() {
        return this.asociatedModel;
    }

    public void setAsociatedModel(Class asociatedModel) {
        this.asociatedModel = asociatedModel;
    }

    public void refreshComponent() {
        ExtraCollectionUtils.forAllDo(this.refreshListeners, new ExecuteRefreshListenerClosure());
    }

    public void turnOff() {
        this.frame.setVisible(false);
    }

    public void setBackground(Color c) {
        this.frame.setBackground(c);
    }

    public void setForeground(Color c) {
        this.frame.setForeground(c);
    }

    public void setLocation(int x, int y) {
        this.frame.setLocation(x, y);
    }

    public void setEnabled(boolean b) {
        this.frame.setEnabled(b);
    }

    public void setCursor(Cursor cursor) {
        this.frame.setCursor(cursor);
    }

    public void setPreferredSize(Dimension dimension) {
        this.frame.setPreferredSize(dimension);
    }

    public void setModelo(FormModel model) {
        this.formModel = model;
        ExtraCollectionUtils.forAllDo(this.modelChangeListeners, new ExecuteModelChangeListenerClosure());
    }

    public FormModel getModelo() {
        if (this.formModel != null)
            return this.formModel;
        try {
            this.formModel = FormModelUtils.wrap(
                    getAsociatedModel().newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return this.formModel;
    }

    public void impactModel(boolean validate) {
        NotFullFormExceptionBuilder builder = new NotFullFormExceptionBuilder();
        ImpactModelClosure closure = new ImpactModelClosure(validate);
        for (Iterator iter = this.imapactModelListeners.iterator(); iter
                .hasNext();) {
            try {
                closure.execute(iter.next());
            } catch (NotFullFormException nffe) {
                builder.add(nffe);
            }
        }
        if (builder.hasException())
            throw builder.build();
    }

    public SimpleModelTarget getOpenTarget() {
        return new SimpleUseCaseTargetDecorator(this);
    }

    public void addModelChangeListener(ModelChangeListener modelChangeListener) {
        this.modelChangeListeners.add(modelChangeListener);
    }

    public void addRefreshListener(RefreshListener refreshListener) {
        this.refreshListeners.add(refreshListener);
    }

    public SimpleModelTarget getReturnTarget() {
        return this.returnTarget == null ? new CloseAndSaveUseCaseTargetDecorator(this)
                : new CloseAndSaveUseCaseTargetDecorator(this,
                        this.returnTarget);
    }

    public void setReturnTarget(SimpleModelTarget modelTargetDecorator) {
        this.returnTarget = modelTargetDecorator;
    }

    public ModelTargetEnableContainer getContainer() {
        return this;
    }

    public void addImapactModelListeners(ImpactModelListener impactModelListener) {
        this.imapactModelListeners.add(impactModelListener);
    }

    public void nextPanel() {
        getContentPane().next();
    }

    public void previousPanel() {
        getContentPane().previous();
    }

    public void startUseCase() {
        this.frame.addWindowListener(this.closeUseCaseWindowListener);
    }

    public PanelsRegistry getPanelsRegistry() {
        throw new RuntimeException("Esto no deberia estar aca");
    }

    public Container getPanel() {
        return getContentPane();
    }

    public LayoutManager getLayout() {
        return getPanel().getLayout();
    }

    public Container getParent() {
        return (Container) getContainer();
    }

    public void setPadre(RefreshableComponent useCaseParent) {
        throw new RuntimeException("This frame cannot be inside another frame");
    }

    public boolean isRestartable() {
        return false;
    }

    public void restart() {
        throw new UnsupportedOperationException("Ver porque estaesto");
    }

    public boolean isStarted() {
        return isVisible();
    }

    public void addPanel(AbstractPanel panel) {
        getContentPane().add(panel);
    }

    public void add(Component component, Object string) {
        getContentPane().add(component, string);
    }

    public void setDefaultCloseOperation(int operation) {
        this.frame.setDefaultCloseOperation(operation);
    }

    public void setMinimumSize(Dimension dimension) {
        this.frame.setMinimumSize(dimension);
    }

    public void setPanelRegistry(PanelsRegistry panelsRegistry) {
        this.panelsRegistry = panelsRegistry;
    }

    public Iterator panelsIterator() {
        return this.panelsRegistry.panelsIterator();
    }

    public String getName() {
        return this.frame.getTitle();
    }

    public void setCloseAction(FormAction action) {
        this.closeUseCaseWindowListener = new CloseUseCaseWindowListener(action);
    }

    public void setIcon(Image icon) {
        this.frame.setIconImage(icon);
    }
}

/*
 * Location: E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name: com.framework.components.wrappers.JFrameWrapper
 * JD-Core Version: 0.6.0
 */