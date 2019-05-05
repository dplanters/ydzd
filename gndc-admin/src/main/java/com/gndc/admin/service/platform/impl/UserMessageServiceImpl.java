package com.gndc.admin.service.platform.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.common.model.UserMessage;
import com.gndc.admin.service.platform.UserMessageService;
import org.springframework.stereotype.Service;

/**
 * 平台反馈
 */
@Service
public class UserMessageServiceImpl extends BaseServiceImpl<UserMessage, Integer> implements UserMessageService {
}
