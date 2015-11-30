package tp3.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tp3.model.Client;
import tp3.model.CompteBancaire;

@SuppressWarnings({ "unchecked", "deprecation" })
public class CompteBancaireDAO {

  private static CompteBancaireDAO daoInstance = new CompteBancaireDAO();
  private SessionFactory           sessFact    = null;
  private Session                  session     = null;

  private CompteBancaireDAO() {
    sessFact = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    session = sessFact.openSession();
  }

  public static CompteBancaireDAO getInstance() {
      if (CompteBancaireDAO.daoInstance == null) {
          CompteBancaireDAO.daoInstance = new CompteBancaireDAO();
      }
    return daoInstance;
  }

  public CompteBancaire getByRib(long rib) {
    String sql = "SELECT * FROM comptes_bancaires WHERE rib = :rib";
    SQLQuery query = session.createSQLQuery(sql);
    query.addEntity(CompteBancaire.class);
    query.setParameter("rib", rib);
    List<CompteBancaire> results = query.list();
    if (results.size() > 0) {
      return results.get(0);
    }
    return null;
  }

  public List<CompteBancaire> getByClient(Client cl) {
    String sql = "SELECT * FROM comptes_bancaires WHERE id_client = :id_client";
    SQLQuery query = session.createSQLQuery(sql);
    query.addEntity(CompteBancaire.class);
    query.setParameter("id_client", cl.getId());
    List<CompteBancaire> results = query.list();
    return results;
  }

  public void addCompteBancaire(CompteBancaire cb) {
    session.beginTransaction();
    session.save(cb);
    session.getTransaction().commit();
  }

  public void updateCompteBancaire(CompteBancaire cb) {
    session.beginTransaction();
    session.update(cb);
    session.getTransaction().commit();
  }

  public void deleteCompteBancaire(CompteBancaire cb) {
    session.beginTransaction();
    session.delete(cb);
    session.getTransaction().commit();
  }

  public List<CompteBancaire> getAll() {
    String sql = "SELECT * FROM comptes_bancaires";
    SQLQuery query = session.createSQLQuery(sql);
    query.addEntity(CompteBancaire.class);
    return query.list();
  }
}
