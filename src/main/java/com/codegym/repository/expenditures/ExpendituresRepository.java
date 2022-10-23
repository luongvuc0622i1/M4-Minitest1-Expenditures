package com.codegym.repository.expenditures;

import com.codegym.model.Expenditures;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ExpendituresRepository implements IExpendituresRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Expenditures> findAll() {
        TypedQuery<Expenditures> query = em.createQuery("select c from Expenditures c", Expenditures.class);
        return query.getResultList();
    }

    @Override
    public Expenditures findById(Long id) {
        TypedQuery<Expenditures> query = em.createQuery("select c from Expenditures c where c.expenditures_id=:id", Expenditures.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Expenditures model) {
        if (model.getExpenditures_id() != null) {
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Expenditures model = findById(id);
        if (model != null) {
            em.remove(model);
        }
    }
}
