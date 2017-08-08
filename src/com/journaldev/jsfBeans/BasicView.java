package com.journaldev.jsfBeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
 
@ManagedBean(name="dtBasicView")
@ViewScoped
public class BasicView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Car> cars;
	private String city;
	private Map<String,String> cities = new HashMap<String, String>();
	
    @ManagedProperty("#{carService}")
    private CarService service;
 
    @PostConstruct
    public void init() {
        cars = service.createCars(10);
    }
    public void createExtAccount(ActionEvent actionEvent){
    	cities = new HashMap<String, String>();
        cities.put("New York", "New York");
        cities.put("London","London");
        cities.put("Paris","Paris");
        cities.put("Barcelona","Barcelona");
        cities.put("Istanbul","Istanbul");
        cities.put("Berlin","Berlin");
        city=cities.get("");
    	RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
    }
    public List<Car> getCars() {
        return cars;
    }
    public void validerExtAccount(ActionEvent actionEvent){
    	RequestContext.getCurrentInstance().execute("PF('dlg2').hide();");
    }
    
    public void setService(CarService service) {
        this.service = service;
    }
	public Map<String, String> getCities() {
		return cities;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}