package com.gndc.core.api.partner;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class APDataAnalysisTableResponse implements Serializable {

    /**
     * 产品名
     */
    private String productName;

    /**
     * 统计项列表
     */
    List<APDataAnalysisTableRow> rows;

}
