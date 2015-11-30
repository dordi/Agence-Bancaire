package tp3.model;

public class CompteBancaire {

  long   rib;
  Client client;
  double solde;

  public CompteBancaire() {}

  public CompteBancaire(long _rib, Client _client, double _solde) {
    this.rib = _rib;
    this.client = _client;
    this.solde = _solde;
  }

  public long getRib() {
    return rib;
  }

  public void setRib(long rib) {
    this.rib = rib;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public double getSolde() {
    return solde;
  }

  public void setSolde(double solde) {
    this.solde = solde;
  }

}
