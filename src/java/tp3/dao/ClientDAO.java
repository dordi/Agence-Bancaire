package tp3.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tp3.model.Client;

@SuppressWarnings({"unchecked", "deprecation"})
public class ClientDAO {

    private static ClientDAO daoInstance = new ClientDAO();
    private SessionFactory sessFact = null;
    private Session session = null;

    private ClientDAO() {
        sessFact = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = sessFact.openSession();
    }

    public static ClientDAO getInstance() {
        if (daoInstance == null) {
            daoInstance = new ClientDAO();
        }
        return daoInstance;
    }

    public Client getByCin(String cin) {
        String sql = "SELECT * FROM client WHERE cin = '" + cin.replace("'", "''") + "'";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Client.class);
        List<Client> results = query.list();
        if (results.size() > 0) {
            return results.get(0);
        }
        return null;
    }

    public Client getById(long id) {
        String sql = "SELECT * FROM client WHERE id = :client_id";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Client.class);
        query.setParameter("client_id", id);
        List<Client> results = query.list();
        if (results.size() > 0) {
            return results.get(0);
        }
        return null;
    }

    public List<Long> getAllCin() {
        String sql = "SELECT `cin` FROM client";
        SQLQuery query = session.createSQLQuery(sql);
        return query.list();
    }

    public void addClient(Client client) {
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
    }

    public void updateClien(Client client) {
        session.beginTransaction();
        session.update(client);
        session.getTransaction().commit();
    }

    public void deleteClient(Client client) {
        session.beginTransaction();
        session.delete(client);
        session.getTransaction().commit();
    }

    public List<Client> getAll() {
        String sql = "SELECT * FROM client";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Client.class);
        return query.list();
    }
}
