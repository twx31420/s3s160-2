package edu.nf.library.service.impl;

import edu.nf.library.dao.ReadDao;
import edu.nf.library.entity.Read;
import edu.nf.library.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/7
 */
@Service
public class ReadServiceImpl implements ReadService {
    @Autowired
    private ReadDao readDao;
    @Override
    public List<Read> listRead() {
         return readDao.listRead();
    }

    @Override
    public void addRead(Read read) {
        readDao.addRead(read);
    }

    @Override
    public void updateRead(Read read) {
        readDao.updateRead(read);
    }
}
