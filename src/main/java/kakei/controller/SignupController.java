package kakei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kakei.entity.UserInfo;
import kakei.form.SignupForm;
import kakei.service.SignupService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SignupController {

	/** ユーザー登録画面 Service */
	private final SignupService service;

	/**
	 * サインアップ画面の初期表示
	 * @param model
	 * @param form
	 * @return サインアップ画面
	 */
	@GetMapping("/signup")
	public String viewSignup(Model model, SignupForm form) {
		return "signup";
	}

	@PostMapping("/resist")
	public void signup(Model model, SignupForm form) {
		UserInfo userInfo = service.resistUserInfo(form);
	}
}
