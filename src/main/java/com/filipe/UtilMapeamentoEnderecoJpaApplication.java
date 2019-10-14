package com.filipe;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.filipe.model.Cliente;
import com.filipe.model.Endereco;
import com.filipe.model.enums.UF;
import com.filipe.repository.ClienteRepository;
import com.filipe.repository.EnderecoRepository;

@SpringBootApplication
public class UtilMapeamentoEnderecoJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UtilMapeamentoEnderecoJpaApplication.class, args);
	}

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente(null, "JOÃO", "CASTRO", "0180875281");
		Cliente c2 = new Cliente(null, "PEDRO", "DE LARA", "018256963");
		
		Endereco e1= new Endereco(null, "Passagem Santa Terezinha", "25", "Próximo a Yamada", "66560750", "Belém", "Jurunas", "Brasil", UF.PA);
		Endereco e2= new Endereco(null, "Rua Silva Castro", "1050", "Próximo a Extrafarma", "665607700", "Belém", "Guamá", "Brasil", UF.PA);
		Endereco e3= new Endereco(null, "Av Conselheiro Furtado", "408", "Alcindo Cacela", "665600500", "Belém", "Nazaré", "Brasil", UF.PA);
		
		c1.getEnderecos().addAll(Arrays.asList(e1, e2));
		c2.getEnderecos().add(e3);
		
		enderecoRepository.saveAll(Arrays.asList(e1,e2, e3));
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
	}
}
