package com.gndc.core.api.producthot;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

public class ProductHotEditRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    // id
    private byte id;
    // 状态
    private byte status;

    /**
     * @return productId
     */

    /**
     * @return status
     */
    public byte getStatus() {
        return status;
    }

    /**
     * @param status 要设置的 status
     */
    public void setStatus(byte status) {
        this.status = status;
    }

    /**
     * @return id
     */
    public byte getId() {
        return id;
    }

    /**
     * @param id 要设置的 id
     */
    public void setId(byte id) {
        this.id = id;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.PRODHOT_EDIT);
    }

}
