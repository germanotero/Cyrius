package com.cyrius.entities;

import com.cyrius.utils.PracticaVisitor;
import com.framework.utils.CollectionFactory;
import java.util.Collection;
import java.util.stream.Collectors;

public class PracticaNoNomenclada extends Practica {

    private Collection<ConfiguracionPracticaNoNomencladaObraSocial> configuracionesObraSocial = CollectionFactory.createCollection(ConfiguracionPracticaNoNomencladaObraSocial.class);

    public Collection<ConfiguracionPracticaNoNomencladaObraSocial> getRelacionObraSocialCodigoCosto()
    {
        return this.configuracionesObraSocial;
    }

    public void setRelacionObraSocialCodigoCosto(Collection<ConfiguracionPracticaNoNomencladaObraSocial> relacionesOsCodCost)
    {
        this.configuracionesObraSocial = relacionesOsCodCost;
    }

    public void accept(PracticaVisitor visitor)
    {
        visitor.visit(this);
    }

    public void validate() {
        this.configuracionesObraSocial = this.configuracionesObraSocial.stream().filter(relacion -> relacion.getCodigo() != null).collect(Collectors.toList());
        this.configuracionesObraSocial.stream().forEach(relacion -> relacion.validate());
    }
}