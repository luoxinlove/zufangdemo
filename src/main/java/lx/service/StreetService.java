package lx.service;

import lx.entity.Street;

import java.util.List;

public interface StreetService {

    //id删除街道
    int shanchujiedao(Integer id);

    //id查找街道
    List<Street> findallid(Integer id);
}
