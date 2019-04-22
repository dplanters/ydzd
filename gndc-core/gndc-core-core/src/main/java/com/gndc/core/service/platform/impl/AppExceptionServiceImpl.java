package com.gndc.core.service.platform.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.model.AppException;
import com.gndc.core.service.platform.AppExceptionService;
import org.springframework.stereotype.Service;

/**
 * APP异常
 */
@Service
public class AppExceptionServiceImpl extends BaseServiceImpl<AppException, Integer> implements AppExceptionService {
}
