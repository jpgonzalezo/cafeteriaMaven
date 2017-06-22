/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;
import entities.Client;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DarkAnimat
 */
@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();
    
    List<List<String>> consultarOrden(String email);
    
    public List<String> consultarUser(String mail, String pass);
    
    Client consulta(Integer idClient);
}
