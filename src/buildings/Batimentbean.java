package buildings;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import persistance.Batiment;


@ManagedBean
@ViewScoped
public class Batimentbean {
	@EJB
	services.batimentServices.BatimentServicesLocal local;
	
	private Batiment batiment=new Batiment();
	private List<Batiment> batiments ;
	private boolean formdisplayed=false;
	private List<Batiment>  filteredvalue;
	

	public boolean isFormdisplayed() {
		return formdisplayed;
	}


	public void setFormdisplayed(boolean formdisplayed) {
		this.formdisplayed = formdisplayed;
	}


	public Batimentbean(){
		
		
	}
	


	
	public Batiment getBatiment() {
		return batiment;
	}


	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}


	public List<Batiment> getBatiments() {
		return batiments;
	}


	public void setBatiments(List<Batiment> batiments) {
		this.batiments = batiments;
	}


	public List<Batiment> getFilteredvalue() {
		return filteredvalue;
	}


	public void setFilteredvalue(List<Batiment> filteredvalue) {
		this.filteredvalue = filteredvalue;
	}


	public void dosaveorupdate(){	
		local.createBatiment(batiment);
        formdisplayed=false;	
	}
	
	public void doupdate(){
		
		
		local.updateBatiment(batiment);
        batiments = local.getBatiment();
        formdisplayed=false;
		
		
		
	}
	
	
	public void donew(){
		batiment = new Batiment(); 
	formdisplayed = true;
	

		
		
		
	}
	
	public void docancel(){
		
	formdisplayed = false;
		
		
		
	}
	public void dodelete(){

		
		local.deleteBatiment(batiment);
		batiments = local.getBatiment();
        formdisplayed=false;
		
		
		
	}
	
public void onrowselect(SelectEvent event){
	
formdisplayed=true;
		
	}
	@PostConstruct
	public void init(){
		
		batiments = local.getBatiment();
		
	}
	
}
