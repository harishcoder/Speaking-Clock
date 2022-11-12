package com.example.speakingClock;

import com.example.speakingClock.controller.ClockController;
import com.example.speakingClock.service.ClockService;
import org.assertj.core.api.StringAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ClockController.class)
class SpeakingClockApplicationTests {

	@MockBean
	ClockService clockService;

	@Autowired
	private MockMvc mockMvc;

	String text = "It's ten";

	@Test
	void getConvertedTime() throws Exception {
		Mockito.when(clockService.timeConversion("10:00")).thenReturn(text);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/timeConverter/10:00").accept(
				MediaType.ALL_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertEquals(text, result.getResponse()
				.getContentAsString());
	}

}
