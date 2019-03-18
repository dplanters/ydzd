package com.gndc.common.enums.user;

/**
 * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
 * @version V1.0.1
 * @Description
 * @date 2018年7月4日 上午11:26:45
 */
public enum UserEventsTypeEnum {

    BANNER_CLICK((byte) 1, "BANNER_CLICK"), // banner类表点击点击

    RECOMMEND_CLICK((byte) 2, "RECOMMEND_CLICK"), // 爆款列表点击

    DOWNLOAD_CLICK((byte) 3, "DOWNLOAD_CLICK"), // 点击下载

    COLLECT((byte) 4, "COLLECT"), // 收藏

    CANCEL_COLLECT((byte) 5, "CANCEL_COLLECT"), // 取消收藏

    OPEN_APP((byte) 6, "OPEN_APP"), // 打开APP

    LOGIN((byte) 7, "LOGIN"), // 登录事件

    PRODUCT_CLICK((byte) 8, "PRODUCT_CLICK"), // 找贷款列表点击
    ;

    private byte code;
    private String name;

    UserEventsTypeEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    public static UserEventsTypeEnum fetch(byte code) {
        for (UserEventsTypeEnum userEventsType : UserEventsTypeEnum.values()) {
            if (userEventsType.code == code) {
                return userEventsType;
            }
        }
        return null;
    }

    public static String getName(byte code) {
        for (UserEventsTypeEnum userSexType : UserEventsTypeEnum.values()) {
            if (userSexType.code == code) {
                return userSexType.name;
            }
        }
        return null;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
