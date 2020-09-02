package com.bandtec.gespospring.service.Office;

import com.bandtec.gespospring.entity.table.Office;
import com.bandtec.gespospring.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class OfficeServiceImpl implements OfficeService{

    @Autowired
    private OfficeRepository repository;

    @Override
    public void save(List<Office> offices){
        this.repository.saveAll(offices);
    }

    @Override
    public Boolean update(Office office){
        this.repository.save(office);
        return true;
    }

    @Override
    public Boolean delete(Integer id){
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public List<Office> findAll(){
        return this.repository.findAll();
    }
}
