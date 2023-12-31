package kakei.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kakei.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

}
