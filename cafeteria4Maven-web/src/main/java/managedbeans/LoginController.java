package managedbeans;

import sessionbeans.ClientFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import managedbeans.OrdenController;
import org.primefaces.context.RequestContext;

@Named("loginController")
@ManagedBean
@SessionScoped
public class LoginController implements Serializable{         
    private String email;
     
    private String password;
    
    private String redireccion = "login";
    
    private String clienteIdLogin;
    
    @EJB
    private ClientFacadeLocal ejbFacade;
    
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public String getRedireccion(){
        return redireccion;
    }
    
    public void setRedireccion(String redireccion){
       this.redireccion=redireccion;
    }
    
    private ClientFacadeLocal getFacade(){
        return ejbFacade;
        
    }
    
    public String getClienteIdLogin(){
        return clienteIdLogin;
    }
    
    public void setClienteIdLogin(String id){
        this.clienteIdLogin = id;
    }
    
    public String loginValidacion() {
        RequestContext context = RequestContext.getCurrentInstance();
        boolean loggedIn = false;
        System.err.println("Email: "+ email);
        System.err.println("pass: "+ password);
        if(email != null && password != null){
            
            List<String> resultadoConsulta = getFacade().consultarUser(email, password);
            System.err.println("entre al if");
            if(!resultadoConsulta.isEmpty()) {
                System.out.println("resultado"+resultadoConsulta);
                setClienteIdLogin(resultadoConsulta.get(0).toString());
                loggedIn = true;
            } else {
                System.err.println("no encontre usuario");
                loggedIn = false;
            }
            context.addCallbackParam("loggedIn", loggedIn);
        }
        if(loggedIn){
            System.out.println("true");
            
            return "/menu/mostrarMenu";
        }else{
            System.out.println("false");
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
            return "login";
        }
    }
}
