package tp3.action.client;

import tp3.dao.ClientDAO;
import tp3.model.Client;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddClient extends ActionSupport {

  Client client;

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  @Override
  public String execute() { 
    ClientDAO.getInstance().addClient(client);
    return SUCCESS;
  }

}
