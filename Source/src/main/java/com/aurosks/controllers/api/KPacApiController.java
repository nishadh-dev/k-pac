package com.aurosks.controllers.api;

import com.aurosks.models.KPac;
import com.aurosks.models.Set;
import com.aurosks.repository.KPacRepository;
import com.aurosks.repository.SetRepository;
import com.aurosks.services.KPacService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
@CommonsLog
public class KPacApiController {

    private final KPacRepository kPacRepository;
    private final SetRepository setRepository;
    private final KPacService kPacService;
    @Autowired
    public KPacApiController(KPacRepository kPacRepository, SetRepository setRepository,
                             KPacService kPacService) {
        this.kPacRepository = kPacRepository;
        this.setRepository = setRepository;
        this.kPacService = kPacService;
    }

    @PostMapping(value = "/kpac")
    public boolean addKPac(@RequestBody KPac kPac) {
        try{
            return kPacRepository.addKPac(kPac);
        } catch(Exception e) {
            log.error("Exception in add K Pac", e);
        }
        return false;

    }

    @GetMapping(value = "/kpacs")
    public List<KPac> listKPacs() {
        try {
            return kPacRepository.listKPacs();
        } catch(Exception e) {
            log.error("Exception in list K Pac", e);
        }
        return Collections.emptyList();

    }

    @DeleteMapping(value = "/kpac/{id}")
    public boolean deleteKPac(@PathVariable int id) {
        try{
            return kPacService.deleteKPac(id);
        } catch(Exception e) {
            log.error("Exception in delete K Pac", e);
        }
        return false;
    }

    @PostMapping(value = "/set")
    public boolean addSet(@RequestBody Set set) {
        try{
            return kPacService.addSet(set);
        } catch (Exception e) {
            log.error("Exception in add Set", e);
        }
        return false;
    }
    @GetMapping(value = "/sets")
    public List<Set> listSets() {
        try {
            return setRepository.listSets();
        } catch(Exception e) {
            log.error("Exception in List Set", e);
        }
        return Collections.emptyList();
    }

    @DeleteMapping(value = "/set/{id}")
    public boolean deleteSet(@PathVariable int id) {
        try{
            return kPacService.deleteSet(id);
        }catch(Exception e) {
            log.error("Exception in Delete Set", e);
        }
        return false;

    }

    @GetMapping(value = "/set/{id}")
    public List<KPac> kpacBySet(@PathVariable int id) {
        try {
            return kPacRepository.findKPacBySet(id);
        } catch (Exception e) {
            log.error("Exception in Kpac by Set", e);
        }
        return Collections.emptyList();
    }

}
