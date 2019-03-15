package com.gndc.core.service.platform.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.model.UserFeedback;
import com.gndc.core.service.platform.FeedbackService;
import org.springframework.stereotype.Service;

/**
 * 平台反馈
 */
@Service
public class FeedbackServiceImpl extends BaseServiceImpl<UserFeedback, Integer> implements FeedbackService {
}
