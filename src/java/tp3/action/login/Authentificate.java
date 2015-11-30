package tp3.action.login;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import tp3.dao.AgentBancaireDAO;
import tp3.model.AgentBancaire;

import com.opensymphony.xwork2.ActionSupport;
import tp3.model.Client;
import tp3.model.CompteBancaire;

@SuppressWarnings({"serial", "rawtypes"})
public class Authentificate extends ActionSupport implements SessionAware {

    private static SessionMap session;

    public static SessionMap getSession() {
        return session;
    }

    private String username;
    private String password;
    private AgentBancaire agentBancaire;
    private Client client;
    private CompteBancaire compteBancaire;

    @Override
    public void setSession(Map map) {
        session = (SessionMap) map;
    }

    public String login() {
        if (session.containsKey("agent")) {
            setAgentBancaire((AgentBancaire) session.get("agent"));
            setUsername(getAgentBancaire().getLogin());
            return SUCCESS;
        }

        if (AgentBancaireDAO.getInstance().checkLogin(getUsername(), getPassword())) {
            setAgentBancaire(AgentBancaireDAO.getInstance().getByLogin(getUsername()));
            session.put("agent", (AgentBancaire) getAgentBancaire());
            session.put("isAdmin", (boolean) (getAgentBancaire().getAdmin() == 1));
            return SUCCESS;
        } else {
            session.invalidate();
            return ERROR;
        }
    }

    public String logout() {
        getSession().invalidate();
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (session.containsKey("agent")) {
            return;
        }
        try {
            if (getUsername().length() == 0) {
                addFieldError("username", "The username cannot be empty");
            } else if (!validateEntry(getUsername())) {
                addFieldError("username", "The username is not valid");
            }

            if (getPassword().length() == 0) {
                addFieldError("password", "The password cannot be empty");
            }
        } catch (NullPointerException e) {
            addActionError("You must use the form");
        }

    }

    /*
     * Usefull functions
     */
    private boolean validateEntry(final String str) {
        Pattern pattern = Pattern.compile("^[A-Za-z ]+$");;
        Matcher matcher = pattern.matcher((str.trim()).toLowerCase());
        return (matcher.matches() && (str.length() != 0));
    }

    /*
     * The getters and the setters
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AgentBancaire getAgentBancaire() {
        return agentBancaire;
    }

    public void setAgentBancaire(AgentBancaire agentBancaire) {
        this.agentBancaire = agentBancaire;
    }

}
