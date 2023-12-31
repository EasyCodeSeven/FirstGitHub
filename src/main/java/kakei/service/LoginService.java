package kakei.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import kakei.entity.UserInfo;
import kakei.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

	/** ユーザー情報テーブルDAO */
	private final UserInfoRepository userInfoRepository;

	public Optional<UserInfo> searchUserById(String loginId) {
		return userInfoRepository.findById(loginId);
	}
}
