package com.aurosks.repository;

import com.aurosks.models.Set;

import java.util.List;

public interface SetRepository {
    boolean addSet(Set set);
    List<Set> listSets();
    boolean deleteSet(int id);
}
