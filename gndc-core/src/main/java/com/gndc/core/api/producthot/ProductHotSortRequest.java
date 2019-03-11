package com.gndc.core.api.producthot;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

public class ProductHotSortRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    // 位置下调项的id
    private int downId;

    // 位置上调项的id
    private int upperId;

    // 位置下调项的position
    private int downPosition;

    // 位置上调项的position
    private int upperPosition;

    /**
     * @return downId
     */
    public int getDownId() {
        return downId;
    }

    /**
     * @param downId 要设置的 downId
     */
    public void setDownId(int downId) {
        this.downId = downId;
    }

    /**
     * @return upperId
     */
    public int getUpperId() {
        return upperId;
    }

    /**
     * @param upperId 要设置的 upperId
     */
    public void setUpperId(int upperId) {
        this.upperId = upperId;
    }

    /**
     * @return downPosition
     */
    public int getDownPosition() {
        return downPosition;
    }

    /**
     * @param downPosition 要设置的 downPosition
     */
    public void setDownPosition(int downPosition) {
        this.downPosition = downPosition;
    }

    /**
     * @return upperPosition
     */
    public int getUpperPosition() {
        return upperPosition;
    }

    /**
     * @param upperPosition 要设置的 upperPosition
     */
    public void setUpperPosition(int upperPosition) {
        this.upperPosition = upperPosition;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.PRODHOT_SORT);
    }

}
