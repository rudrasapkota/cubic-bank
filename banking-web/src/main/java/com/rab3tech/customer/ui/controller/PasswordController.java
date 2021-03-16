package com.rab3tech.customer.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rab3tech.customer.service.LoginService;
import com.rab3tech.customer.service.impl.SecurityQuestionService;
import com.rab3tech.vo.ChangePasswordVO;

/**
 * 
 * @author nagendra
 * This class for customer GUI
 *
 */
@Controller
public class PasswordController {
	@Autowired
	private SecurityQuestionService securityQuestionService;
	@Autowired
	private LoginService loginService;

	@GetMapping("/customer/forget/password")
	public String showForgetPassword(){
		return "/customer/forgetPass";//forgetPass.html
	}

	@PostMapping("/customer/forget/password")
	public String showForgetPasswordPost(@RequestParam("email") String email,Model model){
		List<String> questions=securityQuestionService.findQuestionAnswer(email);
		model.addAttribute("questions",questions);
		return "/customer/validateSecurityQuestion";//validateSecurityQuestion.html
	}
	@PostMapping("/customer/validate/question")
	public String validateQuestions(@RequestParam("email") String email,
			@RequestParam("securityAns1") String securityAns1,@RequestParam("securityAns2") String securityAns2,Model model){
		boolean status=securityQuestionService.validateQuestionAnswer(email,securityAns1,securityAns2);
		if(status){
			return "/customer/updatePassword";
		}else{
			List<String> questions=securityQuestionService.findQuestionAnswer(email);
			model.addAttribute("questions",questions);
			model.addAttribute("message","Hey! your security questions answer did not match!!!!!!!!!!");
			return "/customer/validateSecurityQuestion";//validateSecurityQuestion.html
		}
	}


	@PostMapping("/customer/updatePassword")
	public String customerUpdatePassword(@RequestParam("email") String email,
			@RequestParam("newPassword") String newPassword,@RequestParam("confirmPassword") String confirmPassword,Model model){
			if(newPassword!=null && !newPassword.equals(confirmPassword)){
				model.addAttribute("message", "Hey! your new password and confirm password are not same!");
				return "/customer/updatePassword";
			}else{
				//Logic to update password
				ChangePasswordVO changePasswordVO=new ChangePasswordVO();
				changePasswordVO.setLoginid(email);
				changePasswordVO.setNewPassword(newPassword);
				loginService.changePassword(changePasswordVO);
				model.addAttribute("message", "Hey! your password has been changed successfully!");
				return "/customer/login";
			}
	}

}
