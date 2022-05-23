package com.aurosks.services;

import com.aurosks.models.Set;
import com.aurosks.repository.KPacRepository;
import com.aurosks.repository.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KPacService {

    private final SetRepository setRepository;
    private final KPacRepository kPacRepository;

    @Autowired
    public KPacService(SetRepository setRepository, KPacRepository kPacRepository) {
        this.setRepository =  setRepository;
        this.kPacRepository = kPacRepository;
    }
    @Transactional
    public boolean deleteSet(int id) {
        return setRepository.deleteSet(id);
    }
    @Transactional
    public boolean addSet(Set set) {
        return setRepository.addSet(set);
    }
    @Transactional
    public boolean deleteKPac(int id) {
        return kPacRepository.deleteKPac(id);
    }
}
