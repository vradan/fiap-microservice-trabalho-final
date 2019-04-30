package br.com.fiap.trabalhofinal.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.trabalhofinal.repositories.TransactionRepository;
import br.com.fiap.trabalhofinal.vo.TransactionVO;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private TransactionRepository repository;

	@Test
	public void transactionSaved() throws Exception {
		TransactionVO transaction = new TransactionVO(System.currentTimeMillis(), 500d);

		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();

		String json = mapper.writeValueAsString(transaction);

		mvc.perform(post("/transaction/").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
				.content(json)).andExpect(status().isCreated());
	}

	@Test
	public void transactionNotValid() throws Exception {
		Long currentTime = System.currentTimeMillis() - 60000;

		TransactionVO transaction = new TransactionVO(currentTime, 500d);

		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();

		String json = mapper.writeValueAsString(transaction);

		mvc.perform(post("/transaction/").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
				.content(json)).andExpect(status().isNoContent());
	}

}
