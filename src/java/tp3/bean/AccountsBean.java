package tp3.bean;

import java.util.List;

import tp3.dao.ClientDAO;
import tp3.model.Client;

public class AccountsBean {

  private List<Long>   cinList;
  private List<Client> clientList;

  public List<Long> getCinList() {
    cinList = ClientDAO.getInstance().getAllCin();
    return cinList;
  }

  public void setCinList(List<Long> cinList) {
    this.cinList = cinList;
  }

  public List<Client> getClientList() {
    clientList = ClientDAO.getInstance().getAll();
    return clientList;
  }

  public void setClientList(List<Client> clientList) {
    this.clientList = clientList;
  }

}
