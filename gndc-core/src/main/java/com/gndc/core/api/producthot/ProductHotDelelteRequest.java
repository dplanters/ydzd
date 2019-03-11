package com.gndc.core.api.producthot;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

public class ProductHotDelelteRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    private byte id;

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
        header.setAction(HjAction.PRODHOT_DELETE);
    }

}
