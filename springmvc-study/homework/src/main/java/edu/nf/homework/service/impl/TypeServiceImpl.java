package edu.nf.homework.service.impl;

import edu.nf.homework.dao.TypeDao;
import edu.nf.homework.entity.Type;
import edu.nf.homework.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/14
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDao typeDao;

    @Override
    public void save(Type type) {
        typeDao.save(type);
    }

    @Override
    public List<Type> getTypes() {
        return typeDao.getTypes();
    }
}
