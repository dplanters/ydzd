package com.gndc.core.exception;

import com.gndc.common.api.ResultCode;
import com.gndc.common.exception.ProblemMarker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.DefaultProblem;
import org.zalando.problem.Problem;
import org.zalando.problem.ProblemBuilder;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.validation.ConstraintViolationProblem;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandling implements ProblemHandling {

    @Override
    public ResponseEntity<Problem> process(@Nullable ResponseEntity<Problem> entity, NativeWebRequest request) {

        if (entity == null) {
            return entity;
        }

        Problem problem = entity.getBody();

        Integer code = ResultCode.ERROR.getCode();
        String msg = ResultCode.ERROR.getI18NContent();

        ProblemBuilder builder = Problem.builder()
                .withType(problem.getType())
                .withStatus(problem.getStatus())
                .withTitle(problem.getTitle())
                .with("success", false)
                .with("path", request.getNativeRequest(HttpServletRequest.class).getRequestURI())
                .with("msg", msg)
                .with("code", code);

        if (problem instanceof ConstraintViolationProblem) {
            builder.with("violations", ((ConstraintViolationProblem) problem).getViolations());
        } else if (problem instanceof DefaultProblem){
            builder.withCause(((DefaultProblem) problem).getCause())
                    .withDetail(problem.getDetail())
                    .withInstance(problem.getInstance());
        } else if (problem instanceof ProblemMarker) {
            builder.with("code", ((ProblemMarker) problem).getCode())
                    .with("msg", ((ProblemMarker) problem).getMsg());
        }
        return new ResponseEntity<>(builder.build(), entity.getHeaders(), entity.getStatusCode());
    }
}