package kakei.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import kakei.entity.ErrorMessage;
import kakei.repository.ErrorMessageRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ErrorMessageService {

	private final ErrorMessageRepository errorMessageRepository;

	public Optional<ErrorMessage> searchErrorMessage(String errorMsgCode) {
		return errorMessageRepository.findById(errorMsgCode);
	}
}
