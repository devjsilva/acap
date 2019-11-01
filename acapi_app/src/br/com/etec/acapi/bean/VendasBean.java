package br.com.etec.acapi.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.etec.acapi.modelo.Compra;
import br.com.etec.acapi.modelo.Produto;
import br.com.etec.acapi.modelo.Vendas;
import br.com.etec.acapi.modeloDAO.BancoDAO;

@ManagedBean
@ViewScoped
public class VendasBean {

	public List<Vendas> getVendas(){
		BancoDAO dao = new BancoDAO();
		List<Compra>listaCompra = dao.buscaListaCompra();
		List<Produto>listaAux = new ArrayList<Produto>();
		List<Vendas>listaVendas = new ArrayList<Vendas>();
		
		for (Compra compra : listaCompra) {
		    listaAux = compra.getProdutos();
		    for (Produto produtos : listaAux) {
		    	Vendas venda = new Vendas(produtos.toString(), produtos.getQtd());
		    	listaVendas.add(venda);
			}
		}
		
		
		return listaVendas;
		
	}
	
	public BarChartModel getVendasModel() {

	    BarChartModel model = new BarChartModel();
	    ChartSeries vendas = new ChartSeries();
	    vendas.setLabel("Quantidade de vendas por produto");
	    List<Vendas> listaVendasGrafico = getVendas();
	    System.out.println("Ola pessoal");
	    
	   
	   for (Vendas venda : listaVendasGrafico) {
		   System.out.println(venda.getNome());
		   vendas.set(venda.getNome(), venda.getValor());
	}
	   
	

	    
	    model.addSeries(vendas);
	    

	    return model;
	}
	
}
