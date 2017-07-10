package mum.waa.fd.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.fd.app.domain.AuthorityRole;
import mum.waa.fd.app.domain.User;

@Controller

public class LoginController {

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(@ModelAttribute("user") User user, HttpServletRequest request) {
		String path = redirectByRole(request);

		if ("".equals(path)) {
			return "login";
		}

		return path;
	}

	
	@RequestMapping(value = "/login-success", method = RequestMethod.GET)
	public String loginSuccess(HttpServletRequest request) {
		String path = redirectByRole(request);

		if ("".equals(path)) {
			return "redirect:/home";
		}

		return path;
	}

	
	private String redirectByRole(HttpServletRequest request) {
		if (request.isUserInRole(AuthorityRole.ROLE_PATIENT.toString())) {
			return "redirect:/patients/home";
		}

		if (request.isUserInRole(AuthorityRole.ROLE_DOCTOR.toString())) {
			return "redirect:/doctors/home";
		}

		if (request.isUserInRole(AuthorityRole.ROLE_ADMIN.toString())) {
			return "redirect:/admin";
		}

		return "";
	}

	
	@RequestMapping(value = "/login-failed", method = RequestMethod.GET)
	public String loginFailed(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("fail", true);
		return "login";
	}

	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "redirect:/home";
	}

	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String error(Model model) {
		return "403";
	}
}
