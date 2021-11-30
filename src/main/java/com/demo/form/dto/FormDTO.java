package com.demo.form.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author sheetal_sam_abraham
 *
 */
public class FormDTO {

	@NotBlank(message = "Input text cannot be empty")
	@Size(min = 1, max = 10, message = "Input text can have a maximum of 10 characters")
	private String inputText;

	/**
	 * @return the inputText
	 */
	public String getInputText() {
		return inputText;
	}

	/**
	 * @param inputText
	 *            the inputText to set
	 */
	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

}
