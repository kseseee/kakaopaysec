package com.kakaopaysec.sjc.exception;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Controller
public class GlobalExceptionHandler {
	@ExceptionHandler(value=BizException.class)
	@ResponseBody
	public Map<String,Object> handleBizException(BizException e) {
		Map<String,Object> map = new HashMap<>();
		map.put("code", "404");
		map.put("메세지", e.getMessage());
		return map;	
	}
}
