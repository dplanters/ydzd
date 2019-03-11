package com.gndc.common.common.utils;

import com.gndc.common.api.HjException;
import com.gndc.common.api.ResultCode;
import com.gndc.common.enums.admin.AdminType;
import com.gndc.common.enums.admin.RightType;
import com.gndc.common.model.Admin;
import com.gndc.common.model.Right;

/**
 * 权限验证工具类
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2017年11月7日 上午10:31:58
 */
public class VerifyRightUtil {
    /**
     * 校验管理员是否有权限，如果没有，直接抛出异常
     *
     * @param admin
     * @param rightType
     * @return
     * @throws HjException
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public static boolean verifyRight(Admin admin, RightType rightType) throws HjException {
        if (admin == null) {
            throw new HjException(ResultCode.NOT_PERMISSION);
        }

        if (admin.getLevel() == AdminType.SUPER_ADMIN.getCode()) {
            return true;
        }

        if (admin.getRightList().isEmpty()) {
            throw new HjException(ResultCode.NOT_PERMISSION);
        }

        for (Right right : admin.getRightList()) {
            if (RightType.fetch(right.getUniqueSign()) != null) {
                if (rightType.getCode().equals(RightType.fetch(right.getUniqueSign()).getCode())) {
                    return true;
                }
            }
        }
        throw new HjException(ResultCode.NOT_PERMISSION);

    }

    /**
     * 校验管理员是否有权限，返回true or false
     *
     * @param admin
     * @param rightType
     * @return
     * @throws HjException
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public static boolean hasRight(Admin admin, RightType rightType) {
        if (admin == null) {
            return false;
        }

        if (admin.getLevel() == AdminType.SUPER_ADMIN.getCode()) {
            return true;
        }

        if (admin.getRightList().isEmpty()) {
            return false;
        }

        for (Right right : admin.getRightList()) {
            if (RightType.fetch(right.getUniqueSign()) != null) {
                if (rightType.getCode().equals(RightType.fetch(right.getUniqueSign()).getCode())) {
                    return true;
                }
            }
        }
        return false;

    }
}
