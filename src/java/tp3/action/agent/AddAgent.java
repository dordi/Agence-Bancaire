package tp3.action.agent;

import tp3.dao.AgentBancaireDAO;
import tp3.model.AgentBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddAgent extends ActionSupport {

    AgentBancaire agent;

    @Override
    public String execute() { 
        AgentBancaireDAO.getInstance().addAgent(agent);
        return SUCCESS;
    }

    public AgentBancaire getAgent() {
        return agent;
    }

    public void setAgent(AgentBancaire agent) {
        this.agent = agent;
    }

}
