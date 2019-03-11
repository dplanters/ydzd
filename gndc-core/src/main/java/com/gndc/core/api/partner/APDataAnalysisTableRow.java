package com.gndc.core.api.partner;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class APDataAnalysisTableRow implements Serializable {

    private Date date;

    private Long count;
}
