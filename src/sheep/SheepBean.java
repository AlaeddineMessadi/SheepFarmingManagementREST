package sheep;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import persistance.Sheep;

import services.sheepServices.SheepServicesLocal;

@ManagedBean
@ViewScoped
public class SheepBean {
	
	@EJB
	private SheepServicesLocal sheepServicesLocal;
	private Sheep sheep = new Sheep();
	private List<Sheep> sheeps;
	private List<Sheep> filteredSheeps;
	private boolean formDisplayed = false;

	
	public SheepBean(){
		
	}
	@PostConstruct
	public void init(){
		sheeps = sheepServicesLocal.getSheeps();
	}
	
	public void updateSheep(){
		
		sheepServicesLocal.updateSheep(sheep);
		sheeps = sheepServicesLocal.getSheeps();
		formDisplayed = false;
		
	}
	public void doNew(){
		sheep = new Sheep();
		formDisplayed = true;
		
	}
	public void doCancel(){
		sheeps = sheepServicesLocal.getSheeps();
		formDisplayed = false;
		
	}
	public void doDelete(){
		
		sheepServicesLocal.deleteSheep(sheep);
		sheeps = sheepServicesLocal.getSheeps();
		formDisplayed = false;
		
	}
public void onRowSelect(SelectEvent event){
		
		formDisplayed = true;
		
	}
	public Sheep getSheep() {
		return sheep;
	}
	public void setSheep(Sheep sheep) {
		this.sheep = sheep;
	}
	
	
	public List<Sheep> getSheeps() {
		return sheeps;
	}
	public void setSheeps(List<Sheep> sheeps) {
		this.sheeps = sheeps;
	}
	public boolean isFormDisplayed() {
		return formDisplayed;
	}
	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}
	public List<Sheep> getFilteredSheeps() {
		return filteredSheeps;
	}
	public void setFilteredSheeps(List<Sheep> filteredSheeps) {
		this.filteredSheeps = filteredSheeps;
	}

}
