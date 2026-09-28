package br.com.alura.Screenmatch.principal;

import br.com.alura.Screenmatch.Model.DadoSerie;
import br.com.alura.Screenmatch.Model.DadosEpisodios;
import br.com.alura.Screenmatch.Model.DadosTemporadas;
import br.com.alura.Screenmatch.service.ConsumoApi;
import br.com.alura.Screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados converteInfo = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=d3490d38";

    public void exibeMenu() {
        System.out.println("Digite o nome do filme que você deseja buscar: ");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadoSerie dados = converteInfo.obterDados(json, DadoSerie.class);
        System.out.println(dados);

        List<DadosTemporadas> listaTemporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporadas dadosTemporadas = converteInfo.obterDados(json, DadosTemporadas.class);
            listaTemporadas.add(dadosTemporadas);
        }
        listaTemporadas.forEach(System.out::println);

//        for (int i = 0; i < dados.totalTemporadas(); i++) {
//            List<DadosEpisodios> episodiosTemporada = listaTemporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }

        listaTemporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
    }
}
