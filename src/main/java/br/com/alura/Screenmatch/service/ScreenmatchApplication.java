package br.com.alura.Screenmatch.service;

import br.com.alura.Screenmatch.Model.DadoSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		String json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=d3490d38");
		System.out.println(json);

		ConverteDados converteInfo = new ConverteDados();

		DadoSerie dados = converteInfo.obterDados(json, DadoSerie.class);
		System.out.println(dados);
	}
}
