package com.framework.dynamicForms.targets;

import com.framework.actions.SimpleModelTarget;
import com.framework.dynamicForms.AddElementsModel;
import com.framework.dynamicForms.entities.DynamicForm;
import com.framework.dynamicForms.entities.RelacionToGroupTransformer;
import com.framework.entities.FormModelUtils;
import com.framework.exceptions.ExceptionFactory;
import com.framework.models.FormModel;
import com.framework.utils.ExtraCollectionUtils;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

public class AddDynamicFormElementToDynamicFormTarget extends SimpleModelTarget {
    public AddDynamicFormElementToDynamicFormTarget(SimpleModelTarget target) {
        super(target);
    }

    protected FormModel initModel(FormModel parentModel) {
        return FormModelUtils.wrap(new AddElementsModel());
    }

    protected final void returnAction(FormModel childModel) {
        DynamicForm form = (DynamicForm) getParentModel().getValue();
        Collection seleccionados = ((AddElementsModel) childModel.getValue())
                .getSelection();
        ExceptionFactory.validateFalse("Must.Select.One.Element",
                seleccionados.isEmpty());
        ExceptionFactory.validateTrue("FormElementAllReadySelected",
                ExtraCollectionUtils.containsAny(form.getSimpleElements(),
                        seleccionados));
        Collection transformedCollection = ExtraCollectionUtils.transformedCollection(form.getGroupElements(),
                new RelacionToGroupTransformer());
        ExceptionFactory.validateTrue("FormElementAllReadySelected",
                ExtraCollectionUtils.containsAny(transformedCollection,
                        seleccionados));
        handleSelectedElements(form, seleccionados);
    }

    protected void handleSelectedElements(DynamicForm form, Collection seleccionados) {
        form.addElements(seleccionados);
    }
}

/*
 * Location: E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:
 * com.framework.dynamicForms.targets.AddDynamicFormElementToDynamicFormTarget
 * JD-Core Version: 0.6.0
 */