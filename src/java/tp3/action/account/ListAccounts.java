package tp3.action.account;

import java.util.List;

import tp3.dao.CompteBancaireDAO;
import tp3.model.CompteBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "serial" })
public class ListAccounts extends ActionSupport {

  private List<CompteBancaire> accountsList;

  public String execute() { 
    setAccountsList(CompteBancaireDAO.getInstance().getAll());
    return SUCCESS;
  }

  public List<CompteBancaire> getAccountsList() {
    return accountsList;
  }

  public void setAccountsList(List<CompteBancaire> accountsList) {
    this.accountsList = accountsList;
  }

}
