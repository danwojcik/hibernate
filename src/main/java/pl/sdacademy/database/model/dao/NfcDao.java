package pl.sdacademy.database.model.dao;

import pl.sdacademy.database.model.entity.NfcTag;

import java.util.List;

public interface NfcDao {

    NfcTag findById(Integer id);
    List<NfcTag> findAll();
    void save(NfcTag nfcTag);
    void deleteById(Integer id);
}
