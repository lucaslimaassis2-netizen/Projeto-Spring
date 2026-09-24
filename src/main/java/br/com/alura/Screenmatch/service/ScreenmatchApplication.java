package br.com.alura.Screenmatch.service;

import br.com.alura.Screenmatch.Model.DadoSerie;
import br.com.alura.Screenmatch.Model.DadosEpisodios;
import br.com.alura.Screenmatch.Model.DadosTemporadas;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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

		json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=d3490d38");

		DadosEpisodios dadosEpisodios = converteInfo.obterDados(json,DadosEpisodios.class);
		System.out.println(dadosEpisodios);

		json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&apikey=d3490d38");
        List<DadosTemporadas> listaTemporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=d3490d38");
			DadosTemporadas dadosTemporadas = converteInfo.obterDados(json, DadosTemporadas.class);
			listaTemporadas.add(dadosTemporadas);
		}
		listaTemporadas.forEach(System.out::println);
	}
}
