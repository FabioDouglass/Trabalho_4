package Pratica;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class Projetar_Grafo {

	
	/*  public static void CriarGrafo(GRAPH gh) {
		
		ProjectController pc = Lookup.getDefault().lookup(ProjectController.class);
		pc.newProject();
		 	
		PreviewModel preview = Lookup.getDefault().lookup(PreviewController.class).getModel();
		 
		preview.getProperties().putValue(PreviewProperty.SHOW_NODE_LABELS, Boolean.TRUE);
		preview.getProperties().putValue(PreviewProperty.SHOW_EDGES, Boolean.TRUE);
		preview.getProperties().putValue(PreviewProperty.EDGE_COLOR, new EdgeColor(Color.BLACK));
		preview.getProperties().putValue(PreviewProperty.EDGE_CURVED, Boolean.FALSE);
		
		
		GraphModel model = Lookup.getDefault().lookup(GraphController.class).getGraphModel();
		 
		DirectedGraph directed =  model.getDirectedGraph();
		 
		 
		for(int x = 1; x <= gh.Vertices(); x++) {
			Node n = model.factory().newNode();
			 
			n.setLabel(String.valueOf(x));
			 
			n.setColor(Color.WHITE);
			n.setSize(10);
			n.setPosition((float) ((0.01 + Math.random()) * 1000) - 500, (float) ((0.01 + Math.random()) * 1000) - 500);
			directed.addNode(n);
		 }
		 
		 
		 Node[] nodeList = directed.getNodes().toArray();
		 
		 for(int x = 0; x < gh.Vertices()-1; x++) {
			 
			 for(int y = (x+1); y <= gh.Vertices()-1; y++) {
				 
				 if(gh.getVertexList()[x+1].contains(y+1)) {
					
					Edge e1 = model.factory().newEdge(nodeList[x], nodeList[y]);
					Edge e2 = model.factory().newEdge(nodeList[y], nodeList[x]);

					directed.addEdge(e1);
					directed.addEdge(e2);
				 }
			 }
		 }
		 
		 
		 ExportController ec = Lookup.getDefault().lookup(ExportController.class);
		
		 try {
			ec.exportFile(new File("Distância_Caminho_Grafo.pdf"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	} */
	
	
	
	public static void Exportar_Pdf(GRAPH gh, int raiz) {

		gh.BFS(raiz);
		Document doc = new Document();
		
		try {
			PdfWriter.getInstance(doc, new FileOutputStream("Distância_Caminho_Grafo.pdf"));			
			doc.open();

			for (int x = 1; x <= gh.Vertices(); x++) {  
				gh.GerarCaminho(x, raiz);
				
				System.out.println("d(" + x + "," + raiz + ") = " + gh.getDistance()[x] + " / " + gh.getCaminho());
				doc.add(new Paragraph("d(" + x + "," + raiz + ") = " + gh.getDistance()[x] + " / " + gh.getCaminho()));
				gh.setCaminho("");
			}
			  
			  doc.close();
			  
		  } catch (DocumentException e) {
			  e.printStackTrace();
			  
		  } catch (FileNotFoundException e) {
			  e.printStackTrace();
		  }
	}

}