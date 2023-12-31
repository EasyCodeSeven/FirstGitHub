package kakei.service;

import org.dozer.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kakei.entity.UserInfo;
import kakei.form.SignupForm;
import kakei.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignupService {

	/** ユーザー情報テーブルDAO */
	private final UserInfoRepository userInfoRepository;

	/** Dozer Mapper */
	private final Mapper mapper;

	/** PasswordEncoder */
	private final PasswordEncoder passwordEncoder;

	/**
	 * ユーザー情報テーブル 新規登録
	 * @param form 入力情報
	 * @return 登録情報(ユーザー情報Entity)
	 */
	public UserInfo resistUserInfo(SignupForm form) {

		UserInfo userInfo = mapper.map(form, UserInfo.class);

		var encodedPassword = passwordEncoder.encode(form.getKanriUserPassword());
		userInfo.setKanriUserPassword(encodedPassword);

		return userInfoRepository.save(userInfo);
	}
}
