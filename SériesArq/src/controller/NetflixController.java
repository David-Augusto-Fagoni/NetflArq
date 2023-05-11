package controller;
import model.Serie;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import controllerFila.fatec.Fila;
import matheus.ListaObject.ListaObject;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.PrintWriter;

public class NetflixController {
	public void chamarFila() throws Exception {
		filaArquivo();
	}
	public void chamarLista() throws Exception {
		listaArquivo();
	}
	private void filaArquivo() throws Exception {
		Serie S = new Serie();
		Fila fila = new Fila();
		File arq = new File("C:\\TEMP", "netflixSeries.txt");
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if(!vetLinha[0].contains("major_genre")) {
					S.Serie(vetLinha[0], vetLinha[1], vetLinha[2], Integer.parseInt(vetLinha[4]), vetLinha[10], vetLinha[6], Integer.parseInt(vetLinha[11]));
					fila.insert(S.getMajor_genre()+";"+S.getTitle()+vetLinha[2]+";"+S.getPremire_year()+";"+S.getEpisodes()+";"+S.getStatus()+";"+S.getImdb_rating());
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
			String nome = (String) fila.remove();
			String[] N = nome.split(";");
			File dir = new File("C:\\TEMP");
			if (dir.exists() && dir.isDirectory()) {
				File arq1 = new File("C:\\TEMP", N[0]+".csv");
				boolean existe = false;
				if (arq1.exists()) {
					existe = true;
				}
				String conteudo = nome;
				FileWriter abreArq = new FileWriter(arq1, existe);
				PrintWriter escreveArq = new PrintWriter(abreArq);
				escreveArq.write(nome+"\r\n");
				while(!fila.filaVazia()) {
					escreveArq.write((String) fila.remove()+"\r\n");
				}
				escreveArq.flush();
				escreveArq.close();
				abreArq.close();
			} else {
				throw new IOException("Diretório Inválido");
			}
			
		}
	}
	private void listaArquivo() throws Exception {
		Serie S = new Serie();
		ListaObject lista = new ListaObject();
		File arq = new File("C:\\TEMP", "netflixSeries.txt");
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if(!vetLinha[0].contains("major_genre")) {
					S.Serie(vetLinha[0], vetLinha[1], vetLinha[2], Integer.parseInt(vetLinha[4]), vetLinha[10], vetLinha[6], Integer.parseInt(vetLinha[11]));
					lista.addFirst(S.getMajor_genre()+";"+S.getTitle()+vetLinha[2]+";"+S.getPremire_year()+";"+S.getEpisodes()+";"+S.getStatus()+";"+S.getImdb_rating());
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
			
			File dir = new File("C:\\TEMP");
			if (dir.exists() && dir.isDirectory()) {
				File arq1 = new File("C:\\TEMP", "Comedy.csv");
				boolean existe = false;
				if (arq1.exists()) {
					existe = true;
				}
				FileWriter abreArq = new FileWriter(arq1, existe);
				PrintWriter escreveArq = new PrintWriter(abreArq);
				while (!lista.isEmpty()) {
					String N = (String) lista.get(0);
					String[] vetLinha = N.split(";");
					if (vetLinha[4].contains("Renewed")) {
					escreveArq.write((String) lista.get(0)+"\r\n");
					}
					lista.removeFirst();
				}
				escreveArq.flush();
				escreveArq.close();
				abreArq.close();
			} else {
				throw new IOException("Diretório Inválido");
			}
			
		}
	}
	
}
