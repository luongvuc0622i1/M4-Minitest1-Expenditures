package com.codegym.repository.expenditures;

import com.codegym.model.Expenditures;

import javax.persistence.EntityManager;
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
        return null;
    }

    @Override
    public void save(Expenditures expenditures) {

    }

    @Override
    public void remove(Long id) {

    }
}
