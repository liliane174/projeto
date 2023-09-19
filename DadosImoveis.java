package imobiliaria;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DadosImoveis {
	private ArrayList<Imovel> vetImv = new ArrayList<Imovel>();
	
	public boolean cadastrarTerreno(Terreno t) {
		if (t != null) {
			vetImv.add(new Terreno(t));
			System.out.println("Total de imóveis: " + vetImv.size());
			
			// Armazenando em arquivo
			
			try{
				FileWriter fileWriter = new FileWriter("C:\\Users\\chris\\Downloads\\Base.txt", true);
				BufferedWriter escritor = null; //objeto escritor
				escritor = new BufferedWriter(fileWriter);
			//Instanciação do objeto escritor
			escritor.write(t.toString());
			
			escritor.flush();
			escritor.close();
			fileWriter.close();
			
			} catch(IOException e3){
			e3.printStackTrace();
			}	
			
			return true;
		}
		else return false;
	}
	
	public boolean cadastrarCasa(Casa c) {
		if (c != null) {
			vetImv.add(new Casa(c));
			System.out.println("Total de imóveis: " + vetImv.size());
			
			// Armazenando em arquivo
			
			try{
				FileWriter fileWriter = new FileWriter("C:\\Users\\chris\\Downloads\\Base.txt", true);
				BufferedWriter escritor = null; //objeto escritor
				escritor = new BufferedWriter(fileWriter);
			//Instanciação do objeto escritor
			escritor.write(c.toString());
			
			escritor.flush();
			escritor.close();
			fileWriter.close();
			
			} catch(IOException e3){
			e3.printStackTrace();
			}	
			
			return true;
		}
		else return false;
	}
	
	public boolean cadastrarSala(SalaComercial sc) {
		if (sc != null) {
			vetImv.add(new SalaComercial(sc));
			System.out.println("Total de imóveis: " + vetImv.size());
			
			// Armazenando em arquivo
			
			try{
				FileWriter fileWriter = new FileWriter("C:\\Users\\chris\\Downloads\\Base.txt", true);
				BufferedWriter escritor = null; //objeto escritor
				escritor = new BufferedWriter(fileWriter);
			//Instanciação do objeto escritor
			escritor.write(sc.toString());
			
			escritor.flush();
			escritor.close();
			fileWriter.close();
			
			} catch(IOException e3){
			e3.printStackTrace();
			}	
			
			return true;
		}
		else return false;
	}
	
	public boolean cadastrarApartamento(Apartamento ap) {
		if (ap != null) {
			vetImv.add(new Apartamento(ap));
			System.out.println("Total de imóveis: " + vetImv.size());
			
			// Armazenando em arquivo
			
			try{
				FileWriter fileWriter = new FileWriter("C:\\Users\\chris\\Downloads\\Base.txt", true);
				BufferedWriter escritor = null; //objeto escritor
				escritor = new BufferedWriter(fileWriter);
			//Instanciação do objeto escritor
			escritor.write(ap.toString());
			
			escritor.flush();
			escritor.close();
			fileWriter.close();
			
			} catch(IOException e3){
			e3.printStackTrace();
			}
			
			return true;
		}
		else return false;
	}
	
	public void listar(){
		for (Imovel obj: vetImv) {
			obj.mostrarDados();
		}
	}
	
	// Este método retorna o objeto Imóvel caso encontrado, ou null, caso não encontrado
	public Imovel buscar(String cod) {
		Imovel i = null;
		for (Imovel obj: vetImv) {
			if (obj.getCodigo().equals(cod)) {
				i = obj;
				break;
			}
		}
		return i;
	}
	
	//este método usa o método buscar já implementado
	public boolean excluir(String cod){
		Imovel i = buscar(cod);
		if (i != null) {
			vetImv.remove(i);
			return true;
		}
		else
			return false;
	}

}
