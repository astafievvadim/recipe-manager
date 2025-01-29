package com.astafiev.recipemanager.services;

import com.astafiev.recipemanager.model.Unit;
import com.astafiev.recipemanager.repos.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

    private UnitRepository unitRepository;

    @Autowired
    public void setUnitRepository(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public Unit getById(Long id){
        return unitRepository.findUnitById(id).orElse(null);
    }
}
