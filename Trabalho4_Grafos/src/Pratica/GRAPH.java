package Pratica;

import java.util.LinkedList;

public class GRAPH {

	private LinkedList<Integer> []vertexList;
	private Integer[] distance, parent;
	private Status[] visited;
	private String caminho = "";
	
	public GRAPH(int n) {
		vertexList = new LinkedList[n+1];
		
		visited = new Status[this.vertexList.length];
		distance = new Integer[this.vertexList.length];
		parent = new Integer[this.vertexList.length];
		
		for(int x = 1; x <= n; x++) {
			vertexList[x] = new LinkedList<Integer>();
		}
	}
	
	
	public void addEdge(int source, int target) {
		if(source < 0 || source > this.vertexList.length) {
			 throw new ArrayIndexOutOfBoundsException("Posição de Origem Invalida");
		}else if(target < 0 || target > this.vertexList.length) {
			 throw new ArrayIndexOutOfBoundsException("Posição de Destino Invalida");
		}else {
			 vertexList[source].add(target);
			 vertexList[target].add(source);
		}
	}
	
	
	public int Vertices() {
		return this.vertexList.length-1;
	}
	
	
	public int Arestas() {
		int cont = 0;
		
		for(int x = 1; x < Vertices(); x++) {
			for(int y = (x+1); y <= Vertices(); y++) {
				
				if(vertexList[x].contains(y)) {
					cont ++;
				}
			}}
		
		return cont;
	}
	

	public LinkedList<Integer>[] getVertexList() {
		return vertexList;
	}


	public void BFS(int raiz) {

		for(int x = 1; x <= this.Vertices(); x++) {
			visited[x] = Status.não_descoberto;
			distance[x] = -1;
			parent[x] = null;
		}
		
		
		LinkedList<Integer> fila = new LinkedList<Integer>();
		
		visited[raiz] = Status.descoberto;
		distance[raiz] = 0;
		fila.add(raiz);
		
	
		while(!fila.isEmpty()) {
			
			int aux = fila.poll();
					
			  for(Integer x : this.vertexList[aux]) {
				
				  if(visited[x] == Status.não_descoberto) {
					  
					  visited[x] = Status.descoberto;
					  parent[x] = aux;
					  distance[x] = distance[aux] + 1;
					  
					  fila.add(x);	
				}
			}
			
			visited[aux] = Status.explorado;
		}
	}
	

	public void GerarCaminho(int source, int target) {
		
		if(source == target) {
			 caminho += (source + " ");
			 
		}else if(parent[source] != null) {
			caminho += (source + " ");
			GerarCaminho(parent[source], target);
			
		}else {
			throw new RuntimeException("Caminho Não Identificado");
		}
	}
	
	
	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public Integer[] getDistance() {
		return distance;
	}
	
	
	private int Grau(int vertex) {
		return this.vertexList[vertex].size();
	}
	
	
	public float GrauMedio() {
		float soma = 0;
		
		for(int x = 1; x < this.vertexList.length; x++) {
			soma += Grau(x);
		}
		
		return (soma/Vertices());
	}
	
	
	public int GrauMáximo() {
		int maior = Grau(1);
		
		for(int x = 2; x < this.vertexList.length; x++) {
			if(Grau(x) > maior) {
				maior = Grau(x);
			}}
		
		return maior;
	}
	
	
	public int GrauMinimo() {
		int menor = Grau(1);
		
		for(int x = 2; x < this.vertexList.length; x++) {
			if(Grau(x) < menor) {
				menor = Grau(x);
			}}
		
		return menor;
	}	
	
}