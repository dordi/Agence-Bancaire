package tp3.action.account;

import tp3.dao.ClientDAO;
import tp3.dao.CompteBancaireDAO;
import tp3.model.Client;
import tp3.model.CompteBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "serial" })
public class AddAccount extends ActionSupport {

  private Long   rib;
  private Double solde;
  private String clientCin;

  public String execute() { 
    try {
      Client cl = ClientDAO.getInstance().getByCin(getClientCin());
      if (cl != null) {
        CompteBancaire cb = new CompteBancaire(getRib(), cl, getSolde());
        CompteBancaireDAO.getInstance().addCompteBancaire(cb);
        return SUCCESS;
      }
    } catch (Exception e) {
      e.printStackTrace();
      // And then return ERROR :p
    }
    return ERROR;
  }

  @Override
  public void validate() {
    if (getRib() == null || getRib().toString().length() < 10) {
      addFieldError("rib", "The RIB is not valid [RIB is a 10 characters code]");
    }

    if (getClientCin() == null || getClientCin().toString().length() < 7) {
      addFieldError("clientCin", "The CIN is not valid");
    }

    if (getSolde() == null || getSolde().toString().length() < 1) {
      addFieldError("solde", "The balance is not valid");
    }
  }

  public Long getRib() {
    return rib;
  }

  public void setRib(Long rib) {
    this.rib = rib;
  }

  public Double getSolde() {
    return solde;
  }

  public void setSolde(Double solde) {
    this.solde = solde;
  }

  public String getClientCin() {
    return clientCin;
  }

  public void setClientCin(String clientCin) {
    this.clientCin = clientCin;
  }
}
