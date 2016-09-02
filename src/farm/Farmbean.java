package farm;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import persistance.Farm;


@ManagedBean
@ViewScoped
public class Farmbean {
	@EJB
	services.farmServices.FarmServicesLocal local;
	
	private Farm farm=new Farm();
	private List<Farm> farms ;
	private List<String> images;
	private boolean formdisplayed=false;
	private List<Farm>  filteredvalue;
	public List<Farm> getFilteredvalue() {
		return filteredvalue;
	}


	public void setFilteredvalue(List<Farm> filteredvalue) {
		this.filteredvalue = filteredvalue;
	}


	public List<Farm> getFarms() {
		return farms;
	}


	public void setFarms(List<Farm> farms) {
		this.farms = farms;
	}


	public boolean isFormdisplayed() {
		return formdisplayed;
	}


	public void setFormdisplayed(boolean formdisplayed) {
		this.formdisplayed = formdisplayed;
	}


	public Farmbean(){
		
	}


	public Farm getFarm() {
		return farm;
	}


	public void setFarm(Farm farm) {
		this.farm = farm;
	}
	public void dosaveorupdate(){
		
		
		local.createFarm(farm);
		
formdisplayed=false;
		
		
		
	}
	
	public void doupdate(){
		
		
		local.updateFarm(farm);
		farms = local.getFarms();
        formdisplayed=false;
		
		
		
	}
	
	
	public void donew(){
		farm = new Farm();
		farms=local.getFarms();
	formdisplayed = true;

	}
	
	
	public void docancel(){
		
	formdisplayed = false;
		
		
		
	}
	public void dodelete(){

		
		local.deleteFarm(farm);
		farms = local.getFarms();
formdisplayed=false;
		
		
		
	}
	
public void onrowselect(SelectEvent event){

		
formdisplayed=true;
		
		
		
	}
	@PostConstruct
	public void init(){
		
		farms = local.getFarms();
		
	}
	
	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
	
	

}
