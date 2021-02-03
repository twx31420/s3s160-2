package org.nf.homework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author 天文学
 * @date 2021/1/6
 */
@Data
public class ClassInfo {

    @NotNull(message = "{cla.cid.NotNull}")
    private Integer cid;
    private String cname;

}
