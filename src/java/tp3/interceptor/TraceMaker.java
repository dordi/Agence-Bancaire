package tp3.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.dispatcher.SessionMap;
import tp3.action.login.Authentificate;
import tp3.model.AgentBancaire;

/**
 *
 * @author Dordi
 */
@SuppressWarnings("serial")
public class TraceMaker implements Interceptor, StrutsStatics {

    private static final long serialVersionUID = 1L;

    String className = null;
    String message = "";
    long endingTime = 0;
    final HttpServletRequest request = (HttpServletRequest) ActionContext
            .getContext().get(ServletActionContext.HTTP_REQUEST);

    SessionMap session = Authentificate.getSession();

    FileWriter log;

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        message += "Destroying Interceptor\n";
        message += "-=-=-=-=-=-=-=-=-=-=-=-=-\n";

    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        try {
            log = new FileWriter("C:\\Users\\Dordi\\Documents\\Log.txt", true); //the true will append the new data
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // TODO Auto-generated method stub
        className = invocation.getAction().getClass().getName();
        String result = invocation.invoke();
        AgentBancaire a = (AgentBancaire) Authentificate.getSession().get("agent");
        endingTime = System.currentTimeMillis();
        message += "Time: " + new Date(endingTime) + "\n";
        message += "Agent: " + a.getFirstName() + " " + a.getLastName() + "\n";
        message += "Operation: " + className + "\n";

        message += "-=-=-=-=-=-=-=-=-=-=-=-=-\n";
        message += "-=-=-=-=-=-=-=-=-=-=-=-=-\n";

        log.write(message);
        log.close();
        return result;
    }
}
