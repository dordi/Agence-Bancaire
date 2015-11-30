package tp3.action.account;

import tp3.dao.ClientDAO;
import tp3.dao.CompteBancaireDAO;
import tp3.model.CompteBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({"serial"})
public class EditAccount extends ActionSupport {

    private Long rib;
    private Double solde;
    private String clientCin;

    @Override
    public String execute() {
        CompteBancaire cb = CompteBancaireDAO.getInstance().getByRib(getRib());
        if (cb == null) {
            return ERROR;
        }

        cb.setClient(ClientDAO.getInstance().getByCin(getClientCin()));
        cb.setSolde(getSolde());

        CompteBancaireDAO.getInstance().updateCompteBancaire(cb);

        return SUCCESS;
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
