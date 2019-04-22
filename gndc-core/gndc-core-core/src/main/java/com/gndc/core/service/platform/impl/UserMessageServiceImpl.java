package com.gndc.core.service.platform.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.model.UserMessage;
import com.gndc.core.service.platform.UserMessageService;
import org.springframework.stereotype.Service;

/**
 * 平台反馈
 */
@Service
public class UserMessageServiceImpl extends BaseServiceImpl<UserMessage, Integer> implements UserMessageService {
}
