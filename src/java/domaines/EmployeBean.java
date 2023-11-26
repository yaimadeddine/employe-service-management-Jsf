/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaines;

import beans.Employe;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.EmployeService;

/**
 *
 * @author yoaim
 */
@ManagedBean
public class EmployeBean {
private Employe employe;
private List<Employe> employes;
private EmployeService employeService;
    public EmployeBean() {
         employe = new Employe();
        employeService = new EmployeService();
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public List<Employe> getEmployes() {
         if(employes == null){
            employes = employeService.getAll();
        }
        return employes;
    }
    
     public void onCreateAction(){
        employeService.create(employe);
        employe = new Employe();
    }
     
     

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
    
}
