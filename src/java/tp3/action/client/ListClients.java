package tp3.action.client;

import java.util.List;

import tp3.dao.ClientDAO;
import tp3.model.Client;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "serial" })
public class ListClients extends ActionSupport {

  private List<Client> clientList;

  public String execute() { 
    setClientList(ClientDAO.getInstance().getAll());
    return SUCCESS;
  }

  public List<Client> getClientList() {
    return clientList;
  }

  public void setClientList(List<Client> clientList) {
    this.clientList = clientList;
  }

}
