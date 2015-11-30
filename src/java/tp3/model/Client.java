package tp3.model;

public class Client {

  long   id;
  String cin;
  String firstName;
  String phoneNumber;
  String address;
  String lastName;
  String job;

  public Client() {}

  public Client(String cin, String firstName, String phoneNumber, String address, String lastName, String job) {
    this.cin = cin;
    this.firstName = firstName;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.lastName = lastName;
    this.job = job;
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
