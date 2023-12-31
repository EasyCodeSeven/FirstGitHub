package kakei.controller;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kakei.entity.ErrorMessage;
import kakei.entity.UserInfo;
import kakei.form.LoginForm;
import kakei.service.ErrorMessageService;
import kakei.service.LoginService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	/** ログイン画面 service */
	private final LoginService loginService;

	/** エラーメッセージ service */
	private final ErrorMessageService errorMessageService;

	/** PasswordEncoder */
	private final PasswordEncoder passwordEncoder;

	/**
	 * ログイン画面の初期表示
	 * @param model
	 * @return ログイン画面
	 */
	@GetMapping("/login")
	public String view(Model model, LoginForm form) {
		return "login";
	}

	/**
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@PostMapping("/login")
	public String login(Model model, LoginForm form) {
		Optional<UserInfo> userInfo = loginService.searchUserById(form.getLoginId());
		boolean isCorrectUserAuth = userInfo.isPresent()
				&& passwordEncoder.matches(form.getPassword(), userInfo.get().getKanriUserPassword());
		if (isCorrectUserAuth) {
			return "redirect:/portal";
		} else {
			Optional<ErrorMessage> errorMessage = errorMessageService.searchErrorMessage("E0003");
			model.addAttribute("errorMsg", errorMessage.get().getErrorMsg());
			return "login";
		}
	}

	/*
	 * 登録画面に遷移
	 * @return 新規登録画面
	 */
	@PostMapping("/signup")
	public String signupUserInfo() {
		return "redirect:/signup";
	}
}
