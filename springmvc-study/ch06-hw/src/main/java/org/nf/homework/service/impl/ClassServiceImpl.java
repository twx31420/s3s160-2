package org.nf.homework.service.impl;

import org.nf.homework.dao.ClassDao;
import org.nf.homework.entity.ClassInfo;
import org.nf.homework.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/6
 */
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassDao classDaoImpl;

    @Override
    public List<ClassInfo> listClass() {
        return classDaoImpl.listClass();
    }
}
