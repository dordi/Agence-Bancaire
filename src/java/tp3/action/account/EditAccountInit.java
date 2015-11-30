package tp3.action.account;

import tp3.dao.CompteBancaireDAO;
import tp3.model.CompteBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({"serial"})
public class EditAccountInit extends ActionSupport {

    private Long rib;
    private Double solde;
    private String clientCin;

    @Override
    public String execute() {
        CompteBancaire cb = CompteBancaireDAO.getInstance().getByRib(rib);
        setRib(cb.getRib());
        setSolde(cb.getSolde());
        setClientCin(cb.getClient().getCin());
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
