package br.com.fiap.trabalhofinal.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.trabalhofinal.vo.TransactionVO;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void transactionSaved() throws Exception {
		TransactionVO transaction = new TransactionVO(LocalDateTime.now(), 500);

		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();

		String json = mapper.writeValueAsString(transaction);

		mvc.perform(post("/transaction/")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isCreated());
	}

	@Test
	public void transactionNotValid() throws Exception {
		LocalDateTime dateTime = LocalDateTime.now().minusSeconds(60);

		TransactionVO transaction = new TransactionVO(dateTime, 500);

		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();

		String json = mapper.writeValueAsString(transaction);

		mvc.perform(post("/transaction/")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isNoContent());
	}

}
