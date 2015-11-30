package tp3.action.agent;

import java.util.List;

import tp3.dao.AgentBancaireDAO;
import tp3.model.AgentBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({"serial"})
public class ListAgents extends ActionSupport {

    private List<AgentBancaire> agentList;

    @Override
    public String execute() { 
        setAgentList(AgentBancaireDAO.getInstance().getAll());
        return SUCCESS;
    }

    public List<AgentBancaire> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<AgentBancaire> agentList) {
        this.agentList = agentList;
    }

}
