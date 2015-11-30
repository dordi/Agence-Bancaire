package tp3.action.client;

import static com.opensymphony.xwork2.Action.SUCCESS;


import com.opensymphony.xwork2.ActionSupport;
import tp3.dao.ClientDAO;
import tp3.model.Client;

@SuppressWarnings({"serial"})
public class EditClientInit extends ActionSupport {

    private long id;
    private String cin;
    private String firstName;
    private String phoneNumber;
    private String address;
    private String lastName;
    private String job;

    @Override
    public String execute() { 
        Client cb = ClientDAO.getInstance().getByCin(cin);
        setFirstName(cb.getFirstName());
        setLastName(cb.getLastName());
        setPhoneNumber(cb.getPhoneNumber());
        setAddress(cb.getAddress());
        setJob(cb.getJob());
        return SUCCESS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
