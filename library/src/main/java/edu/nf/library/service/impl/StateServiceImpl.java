package edu.nf.library.service.impl;

import edu.nf.library.dao.StateDao;
import edu.nf.library.entity.State;
import edu.nf.library.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/7
 */
@Service
public class StateServiceImpl implements StateService {
    @Autowired
    private StateDao stateDao;
    @Override
    public List<State> listState() {
        return stateDao.listState() ;
    }

    @Override
    public void addState(State state) {
        stateDao.addState(state);
    }

    @Override
    public void updateState(State state) {
        stateDao.updateState(state);
    }
}
