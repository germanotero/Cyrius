package com.cyrius.searchers;

import com.cyrius.entities.Persona;
import com.cyrius.entities.TipoDocumento;
import com.framework.persistence.CriteriaBuilder;
import com.framework.persistence.PersistenceService;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class BuscadorPersona {
    private static BuscadorPersona instance;

    public static synchronized BuscadorPersona getInstance() {
        if (instance == null)
            instance = new BuscadorPersona();
        return instance;
    }

    public static Collection findAll() {
        return PersistenceService.getInstance().loadAll(Persona.class);
    }

    public static Persona findById(Integer id) {
        return (Persona) PersistenceService.getInstance().load(Persona.class, id);
    }

    public Collection findByNombreApellido(String nombre, String apellido) {
        CriteriaBuilder builder = createCriteriaNombreApellido(nombre, apellido);
        return (Collection) builder.build();
    }

    public boolean existsByNombreApellido(String nombre, String apellido) {
        CriteriaBuilder builder = createCriteriaNombreApellido(nombre, apellido);
        return !((Collection) (Collection) builder.build()).isEmpty();
    }

    private CriteriaBuilder<Collection> createCriteriaNombreApellido(String nombre, String apellido) {
        CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(Persona.class);
        builder.dontAcceptNullValues();
        builder.addilike("nombre", nombre, MatchMode.ANYWHERE);
        builder.addilike("apellido", apellido, MatchMode.ANYWHERE);
        return builder;
    }

    public boolean existByDocumento(Integer nroDocumento, TipoDocumento tipoDocumento) {
        Session currentSession = PersistenceService.getInstance().getCurrentSession();
        currentSession.beginTransaction();
        Criteria builder = currentSession.createCriteria(Persona.class);
        builder.add(Restrictions.eq("documento", nroDocumento));
        builder.add(Restrictions.eq("tipoDocumento", tipoDocumento));
        builder.setMaxResults(1);
        boolean value = !builder.list().isEmpty();
        currentSession.getTransaction().commit();
        return value;
    }

    @SuppressWarnings("unchecked")
    public Collection<Persona> findByDni(String dni) {
        return (Collection<Persona>)createCriteriaDni(dni).build();
    }

    private CriteriaBuilder<Collection<Persona>> createCriteriaDni(String dni) {
        CriteriaBuilder<Collection<Persona>> builder = PersistenceService.getInstance().criteriaBuilder(Persona.class);
        builder.dontAcceptNullValues();
        builder.addEquals("documento", Integer.valueOf(dni.trim()));
        return builder;
    }
}
