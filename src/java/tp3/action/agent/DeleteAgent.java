package tp3.action.agent;

import tp3.dao.AgentBancaireDAO;
import tp3.model.AgentBancaire;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteAgent extends ActionSupport {

  long id;

  public String execute() { 
    AgentBancaire agent = AgentBancaireDAO.getInstance().getById(getId());
    if (agent == null)
      return ERROR;

    // Delete the account
    AgentBancaireDAO.getInstance().deleteAgent(agent);

    return SUCCESS;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
