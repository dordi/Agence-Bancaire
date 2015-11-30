package tp3.action.account;

import java.util.List;

import tp3.dao.ClientDAO;
import tp3.dao.CompteBancaireDAO;
import tp3.model.Client;
import tp3.model.CompteBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({"serial"})
public class DeleteAccount extends ActionSupport {

    private long rib;

    @Override
    public String execute() { 
        CompteBancaire cbToDelete = CompteBancaireDAO.getInstance().getByRib(getRib());
        if (cbToDelete == null) {
            return ERROR;
        }

        // Delete the account
        CompteBancaireDAO.getInstance().deleteCompteBancaire(cbToDelete);

        // And if it was the last one, delete also the client
        Client client = cbToDelete.getClient();
        List<CompteBancaire> listCB = CompteBancaireDAO.getInstance().getByClient(client);

        if (listCB != null && listCB.size() == 0) {
            ClientDAO.getInstance().deleteClient(client);
        }
        return SUCCESS;
    }

    public long getRib() {
        return rib;
    }

    public void setRib(long rib) {
        this.rib = rib;
    }

}
