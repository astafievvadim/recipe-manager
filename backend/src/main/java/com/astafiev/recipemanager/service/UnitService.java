package com.astafiev.recipemanager.service;

import com.astafiev.recipemanager.model.Unit;
import com.astafiev.recipemanager.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

    private UnitRepository unitRepository;
    @Autowired
    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public Unit getById(Long id){
        return unitRepository.findUnitById(id).orElse(null);
    }
}
