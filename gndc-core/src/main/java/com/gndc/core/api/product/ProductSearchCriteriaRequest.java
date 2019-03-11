package com.gndc.core.api.product;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * Description: 找贷款搜索项配置
 * User: chenzuozhou
 * Date: 2019-02-27
 * Time: 上午11:53
 */
public class ProductSearchCriteriaRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.P_SEARCH_CRITERIA_FIND);

    }
}
