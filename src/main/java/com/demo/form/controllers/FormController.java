package com.demo.form.controllers;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.form.dto.FormDTO;

/**
 * FormController implements POST-redirect-GET pattern.
 * 
 * @author sheetal_sam_abraham
 *
 */
@RestController
public class FormController {

	/**
	 * Displays a form to the user.
	 * 
	 * @param formDTO
	 * @return ModelAndView This represents the form to be displayed.
	 */
	@GetMapping("/form")
	public ModelAndView getForm(FormDTO formDTO) {
		return new ModelAndView("form");
	}

	/**
	 * Redirects user to a success URL in case of no validation errors on the
	 * form, else displays the errors on the original URL.
	 * 
	 * @param formDTO
	 *            This has the input entered by the user
	 * @param bindingResult
	 *            This holds the result of form validation
	 * @return ModelAndView Redirects user to a success URL in case of no
	 *         validation errors, else displays the errors on the original URL.
	 */
	@PostMapping("/form")
	public ModelAndView submitForm(@Valid FormDTO formDTO,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("form");
		} else {
			return new ModelAndView("redirect:/success");
		}
	}

	/**
	 * Displays a success URL.
	 * 
	 * @return ModelAndView This represents the success page to be displayed.
	 */
	@GetMapping("/success")
	public ModelAndView success() {
		return new ModelAndView("success");
	}
}
