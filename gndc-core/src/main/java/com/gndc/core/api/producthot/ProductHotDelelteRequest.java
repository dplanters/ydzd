package com.gndc.core.api.producthot;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductHotDelelteRequest extends RequestMessage {

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

}
