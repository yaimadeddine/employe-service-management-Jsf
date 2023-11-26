
import beans.Service;
import service.ServiceService;
import util.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoaim
 */

public class Test {

    public static void main(String[] args) {
        // Créer une instance de ServiceService
        ServiceService serviceService = new ServiceService();

        // Créer un service
        Service service1 = new Service();
        service1.setNom("Informatique");

        Service service2 = new Service();
        service2.setNom("Ressources Humaines");

        // Enregistrer les services
        serviceService.create(service1);
        serviceService.create(service2);

        // Afficher les services
        System.out.println("Services créés avec succès!");

        // Fermer la session Hibernate
        HibernateUtil.getSessionFactory().close(); 
    }
}
