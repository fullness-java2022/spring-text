package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver{
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		// 例外メッセージをAttributeにセット
		modelAndView.addObject("message",ex.getMessage());
		// スタックトレースをStringBufferに文字列として格納
		StringBuffer stringBuffer = new StringBuffer();
		for(StackTraceElement stackTraceElement : ex.getStackTrace()) {
			stringBuffer.append(stackTraceElement.toString()+"\n");
		}
		// スタックトレース文字列をAttributeにセット
		modelAndView.addObject("trace", stringBuffer);
		// View名の指定
		modelAndView.setViewName("exception");
		// HTTPレスポンスのステータスコードをINTERNAL_SERVER_ERROR（505）
		modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return modelAndView;
	}

}
