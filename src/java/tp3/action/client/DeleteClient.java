package tp3.action.client;

import tp3.dao.ClientDAO;
import tp3.model.Client;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteClient extends ActionSupport {

  String cin;

  public String execute() { 
    try {
      Client c = ClientDAO.getInstance().getByCin(getCin());
      ClientDAO.getInstance().deleteClient(c);
      return SUCCESS;
    } catch (Exception ex) {
      return ERROR;
    }
  }

  public String getCin() {
    return cin;
  }

  public void setCin(String cin) {
    this.cin = cin;
  }

}
