package edu.nf.library.service;

import edu.nf.library.entity.State;

import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/7
 */
public interface StateService {
    /**
     * 查询所有状态
     * @return
     */
    List<State> listState();

    /**
     * 添加状态
     * @param state
     */
    void addState(State state);

    /**
     * 修改状态
     * @param state
     */
    void updateState(State state);
}
