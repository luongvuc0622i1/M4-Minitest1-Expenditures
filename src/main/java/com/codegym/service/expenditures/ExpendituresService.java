package com.codegym.service.expenditures;

import com.codegym.model.Expenditures;
import com.codegym.repository.expenditures.IExpendituresRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExpendituresService implements IExpendituresService {
    @Autowired
    private IExpendituresRepository expendituresRepository;
    @Override
    public List<Expenditures> findAll() {
        return expendituresRepository.findAll();
    }

    @Override
    public Expenditures findById(Long id) {
        return expendituresRepository.findById(id);
    }

    @Override
    public void save(Expenditures model) {
        expendituresRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        expendituresRepository.remove(id);
    }
}
