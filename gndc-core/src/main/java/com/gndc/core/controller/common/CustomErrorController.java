package com.gndc.core.controller.common;

import com.gndc.common.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ErrorProperties.IncludeStacktrace;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.Map;
@Slf4j
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomErrorController extends AbstractErrorController {

	private final ErrorProperties errorProperties;

	/**
	 * Create a new {@link CustomErrorController} instance.
	 * @param errorAttributes the error attributes
	 * @param errorProperties configuration properties
	 */

	public CustomErrorController(ErrorAttributes errorAttributes,
                                 ErrorProperties errorProperties) {
		this(errorAttributes, errorProperties, Collections.emptyList());
	}

	/**
	 * Create a new {@link CustomErrorController} instance.
	 * @param errorAttributes the error attributes
	 * @param errorProperties configuration properties
	 * @param errorViewResolvers error view resolvers
	 */
	public CustomErrorController(ErrorAttributes errorAttributes,
                                 ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
		super(errorAttributes, errorViewResolvers);
		Assert.notNull(errorProperties, "ErrorProperties must not be null");
		this.errorProperties = errorProperties;
	}

	@Override
	public String getErrorPath() {
		return this.errorProperties.getPath();
	}

	@RequestMapping(produces = "text/html")
	public ModelAndView errorHtml(HttpServletRequest request,
			HttpServletResponse response) {
		HttpStatus status = getStatus(request);
		Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(
				request, isIncludeStackTrace(request, MediaType.TEXT_HTML)));
		response.setStatus(status.value());
		ModelAndView modelAndView = resolveErrorView(request, response, status, model);
		return (modelAndView != null) ? modelAndView : new ModelAndView("error", model);
	}

	@RequestMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.ALL));
		HttpStatus status = getStatus(request);
		if (HttpStatus.NOT_FOUND.equals(status)){
		    body.clear();
            body.put("success", false);
            body.put("code", ResultCode.NOT_FOUND.getCode());
            body.put("msg", ResultCode.NOT_FOUND.getI18NContent());
        }
        if (HttpStatus.OK.equals(status)) {
            String code = ((String) body.get("message"));
            ResultCode response = ResultCode.fetch(Integer.valueOf(code));
            body.clear();
            body.put("success", true);
            body.put("code", response.getCode());
            body.put("msg", response.getI18NContent());
        }
		return new ResponseEntity<>(body, status);
	}

	/**
	 * Determine if the stacktrace attribute should be included.
	 * @param request the source request
	 * @param produces the media type produced (or {@code MediaType.ALL})
	 * @return if the stacktrace attribute should be included
	 */
	protected boolean isIncludeStackTrace(HttpServletRequest request,
			MediaType produces) {
		IncludeStacktrace include = getErrorProperties().getIncludeStacktrace();
		if (include == IncludeStacktrace.ALWAYS) {
			return true;
		}
		if (include == IncludeStacktrace.ON_TRACE_PARAM) {
			return getTraceParameter(request);
		}
		return false;
	}

	/**
	 * Provide access to the error properties.
	 * @return the error properties
	 */
	protected ErrorProperties getErrorProperties() {
		return this.errorProperties;
	}

}
