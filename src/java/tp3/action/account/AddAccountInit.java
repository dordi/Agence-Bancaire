package tp3.action.account;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import tp3.dao.ClientDAO;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "serial" })
public class AddAccountInit extends ActionSupport implements SessionAware {

  private SessionMap sessionMap;

  public String execute() { 
    sessionMap.put("cinList", ClientDAO.getInstance().getAllCin());
    return SUCCESS;
  }

  @Override
  public void setSession(Map map) {
    sessionMap = (SessionMap) map;
  }

}
