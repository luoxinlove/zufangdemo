package lx.service.impl;

import lx.dao.StreetMapper;
import lx.entity.Street;
import lx.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {


    @Autowired
    public StreetMapper streetMapper;

    @Override
    public int shanchujiedao(Integer id) {
        return streetMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Street> findallid(Integer id) {
        return streetMapper.allid(id);
    }
}
