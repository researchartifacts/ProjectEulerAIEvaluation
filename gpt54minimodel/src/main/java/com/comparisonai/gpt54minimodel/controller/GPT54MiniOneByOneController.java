package com.comparisonai.gpt54minimodel.controller;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Map;

@RestController
@RequestMapping("/api/gpt54mini/onebyone")
public class GPT54MiniOneByOneController {

	// Spring automatically populates this map with ALL registered service beans.
	// Key = bean name (e.g., "GPT54MiniOneByOneQ1"), Value = service instance
	private final Map<String, Object> questionServices;

	public GPT54MiniOneByOneController(Map<String, Object> questionServices) {
		this.questionServices = questionServices;
	}

	@GetMapping("/q{number}")
	public ResponseDto getQuestion(@PathVariable int number) {
		if (number < 1 || number > 1000) {
			throw new IllegalArgumentException("Question number must be between 1 and 1000");
		}

		// Construct the Spring Bean name (Spring defaults class names to lower camelCase)
		// GPT54MiniOneByOneQ11 -> GPT54MiniOneByOneQ11
		String beanName = "GPT54MiniOneByOneQ" + number;
		Object service = questionServices.get(beanName);

		if (service == null) {
			throw new IllegalStateException("Service bean not found for question: " + number);
		}

		long startTime = System.nanoTime();
		ResponseDto dto;

		try {
			// Construct the method name, e.g., "Question1"
			String methodName = "Question" + number;

			// Dynamically invoke Question{number}() on the specific bean
			Method method = service.getClass().getMethod(methodName);
			dto = (ResponseDto) method.invoke(service);

		} catch (NoSuchMethodException e) {
			// Fallback in case the method inside the service class is named simply "Question()"
			try {
				Method method = service.getClass().getMethod("Question");
				dto = (ResponseDto) method.invoke(service);
			} catch (Exception ex) {
				throw new RuntimeException("Failed to invoke question method for Q" + number, ex);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error executing question " + number, e);
		}

		dto.setTime(System.nanoTime() - startTime);
		return dto;
	}
}
