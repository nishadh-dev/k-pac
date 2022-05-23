package com.aurosks.repository;

import com.aurosks.models.KPac;

import java.util.List;

public interface KPacRepository {
    boolean addKPac(KPac pac);
    List<KPac> listKPacs();
    boolean deleteKPac(int id);
    List<KPac> findKPacBySet(int setId);

}
