package tp3.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import tp3.model.AgentBancaire;

@SuppressWarnings({"unchecked", "deprecation"})
public class AgentBancaireDAO {

    private static AgentBancaireDAO daoInstance = new AgentBancaireDAO();
    private SessionFactory sessFact = null;
    private Session session = null;

    private AgentBancaireDAO() {
        sessFact = new AnnotationConfiguration().configure().buildSessionFactory();
        session = sessFact.openSession();
    }

    public static AgentBancaireDAO getInstance() {
        if (daoInstance == null) {
            daoInstance = new AgentBancaireDAO();
        }
        return daoInstance;
    }

    public void addAgent(AgentBancaire agent) {
        session.beginTransaction();
        session.save(agent);
        session.getTransaction().commit();
    }

    public void updateAgent(AgentBancaire agent) {
        session.beginTransaction();
        session.update(agent);
        session.getTransaction().commit();
    }

    public void deleteAgent(AgentBancaire agent) {
        session.beginTransaction();
        session.delete(agent);
        session.getTransaction().commit();
    }

    public List<AgentBancaire> getAll() {
        String sql = "SELECT * FROM agent_bancaire";
        SQLQuery query = session.createSQLQuery(sql).addEntity(AgentBancaire.class);
        return query.list();
    }

    public boolean checkLogin(String login, String password) {
        String sql = "SELECT * FROM agent_bancaire WHERE login = :agent_login AND password = MD5(:agent_pass)";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(AgentBancaire.class);
        query.setParameter("agent_login", login);
        query.setParameter("agent_pass", password);
        List<AgentBancaire> results = query.list();
        return (results.size() > 0);
    }

    public AgentBancaire getById(long id) {
        String sql = "SELECT * FROM agent_bancaire WHERE id = :agent_id";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(AgentBancaire.class);
        query.setParameter("agent_id", id);
        List<AgentBancaire> results = query.list();
        if (results.size() > 0) {
            return results.get(0);
        }
        return null;
    }

    public AgentBancaire getByLogin(String login) {
        String sql = "SELECT * FROM agent_bancaire WHERE login = :agent_login";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(AgentBancaire.class);
        query.setParameter("agent_login", login);
        List<AgentBancaire> results = query.list();
        if (results.size() > 0) {
            return results.get(0);
        }
        return null;
    }

    public boolean isAdmin(AgentBancaire ab) {
        return (ab.getAdmin() == 1);
    }

}
