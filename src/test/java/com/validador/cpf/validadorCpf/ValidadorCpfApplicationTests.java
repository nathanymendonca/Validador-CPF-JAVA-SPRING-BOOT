package com.validador.cpf.validadorCpf;

import com.validador.cpf.validadorCpf.models.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.InputMismatchException;

@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("94622036010");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("94622036011");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfComDigitoAMenos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("9462203602");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("946.220.360-10");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("946.220.360-11");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComVirgula() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("946,220.360-11");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoFinal() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("946.220.360-10 ");
		assertEquals(true, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoComeco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf(" 946.220.360-10");
		assertEquals(true, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoMeio() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("946.220. 360-10");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfMaluco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("69b.969.790-88");
		assertEquals(true, cliente.validarCPF());
	}
}
