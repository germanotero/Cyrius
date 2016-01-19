package com.cyrius.searchers;

import java.util.Collection;

import org.hibernate.criterion.Restrictions;

import com.cyrius.entities.Persona;
import com.cyrius.entities.Turno;
import com.cyrius.informes.Informe;
import com.framework.persistence.CriteriaBuilder;
import com.framework.persistence.PersistenceService;

public class InformeSearcher {
	public static InformeSearcher instance;

	public static synchronized InformeSearcher getInstance() {
		if (instance == null) {
			instance = new InformeSearcher();
		}
		return instance;
	}

	public Collection findInformesByPerson(Persona persona) {
		CriteriaBuilder builder = PersistenceService.getInstance().criteriaBuilder(Informe.class);
		builder.getCriteria().createCriteria("turno").add(Restrictions.eq("paciente", persona));
		return (Collection) builder.build();
	}

	public boolean exsistsByTurno(Turno turno) {
		CriteriaBuilder criteria = PersistenceService.getInstance().uniqueCriteriaBuilder(Informe.class);
		criteria.getCriteria().add(Restrictions.eq("turno", turno));
		return criteria.build() != null;
	}
}
