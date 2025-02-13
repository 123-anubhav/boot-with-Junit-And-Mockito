package in.anubhav.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.anubhav.service.MessageService;

@WebMvcTest(value = RestController.class)
public class RestControllerTest {

	@MockBean
	private MessageService msgService;

	private MockMvc mockMvc;

	public void greetMessageTest() throws Exception {
		when(msgService.getMessage()).thenReturn("good morning anubhav");
		MockHttpServletRequestBuilder mvcBuilder = MockMvcRequestBuilders.get("/greet"); 
		MvcResult mvcResult = mockMvc.perform(mvcBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int actualMockResponseStatus = response.getStatus();
		assertEquals(200, actualMockResponseStatus);
	}
}
