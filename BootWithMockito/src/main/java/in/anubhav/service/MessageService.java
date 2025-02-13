package in.anubhav.service;

import org.springframework.stereotype.Service;

import in.anubhav.constants.AppConstants;

@Service
public class MessageService {

	public String getMessage() {
		return AppConstants.MESSAGE;
	}
}
