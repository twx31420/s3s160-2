package edu.nf.ch06_hw.service.impl;

import edu.nf.ch06_hw.dao.ClassInfoDao;
import edu.nf.ch06_hw.entity.ClassInfo;
import edu.nf.ch06_hw.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/5
 */
@Service("claservice")
public class ClassInfoServiceImpl implements ClassInfoService {

    @Autowired
    private ClassInfoDao cladao;

    @Override
    public List<ClassInfo> getInfo() {
        return cladao.getInfo();
    }
}
