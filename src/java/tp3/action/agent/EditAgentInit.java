package tp3.action.agent;

import static com.opensymphony.xwork2.Action.SUCCESS;


import com.opensymphony.xwork2.ActionSupport;
import tp3.dao.AgentBancaireDAO;
import tp3.model.AgentBancaire;

@SuppressWarnings({"serial"})
public class EditAgentInit extends ActionSupport {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private int admin;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
   
    @Override
    public String execute() { 
        AgentBancaire agent = AgentBancaireDAO.getInstance().getById(getId());
        setFirstName(agent.getFirstName());
        setLastName(agent.getLastName());
        setLogin(agent.getLogin());
        setPassword(agent.getPassword());
        setAdmin(agent.getAdmin());
        return SUCCESS;
    }
}
