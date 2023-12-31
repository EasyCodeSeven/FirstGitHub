package kakei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "error_message")
@Data
public class ErrorMessage {

	/** エラーメッセージコード */
	@Id
	@Column(name = "error_msg_code")
	private String errorMsgCode;

	/** エラーメッセージ */
	@Column(name = "error_msg")
	private String errorMsg;

}
