package com.gndc.core.api.partner.dataAnalysis;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class APDataAnalysisListResponse implements Serializable {

    private Date date;

    private Long count;
}
