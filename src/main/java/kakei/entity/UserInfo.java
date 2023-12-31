package kakei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_kanri")
@Data
public class UserInfo {

	/** 管理ユーザーID */
	@Id
	@Column(name = "kanri_user_id")
	private String kanriUserId;

	/** 管理ユーザーパスワード */
	@Column(name = "kanri_user_password")
	private String kanriUserPassword;
}
