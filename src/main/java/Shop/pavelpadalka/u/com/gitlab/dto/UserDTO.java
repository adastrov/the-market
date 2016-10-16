package Shop.pavelpadalka.u.com.gitlab.dto;

import Shop.pavelpadalka.u.com.gitlab.entity.UserSex;
import Shop.pavelpadalka.u.com.gitlab.entity.UserRole;

import java.util.Date;
import java.util.List;

public class UserDTO {

    private Integer  id;
    private String   firstName;
    private String   lastName;
    private Date     birthday;
    private String   login;
    private String   password;
    private UserSex sex;
    private String   email;
    private UserRole role;
    private List<TransactionDTO> transactionDTOList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserSex getSex() {
        return sex;
    }

    public void setSex(UserSex sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<TransactionDTO> getTransactionDTOList() {
        return transactionDTOList;
    }

    public void setTransactionDTOList(List<TransactionDTO> transactionDTOList) {
        this.transactionDTOList = transactionDTOList;
    }
}