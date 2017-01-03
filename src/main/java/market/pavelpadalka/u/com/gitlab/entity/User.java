package market.pavelpadalka.u.com.gitlab.entity;

import market.pavelpadalka.u.com.gitlab.dto.UserRoleDTO;

import java.sql.Date;
import java.util.List;

public class User {

    private Integer  id;
    private String   firstName;
    private String   lastName;
    private Date     birthday;
    private String   login;
    private String   password;
    private UserSex  sex;
    private String   email;
    private UserRoleDTO role;
    private List<History> histories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
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

    public UserRoleDTO getRole() {
        return role;
    }

    public void setRole(UserRoleDTO role) {
        this.role = role;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!birthday.equals(user.birthday)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (sex != user.sex) return false;
        if (!email.equals(user.email)) return false;
        return role.equals(user.role);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + sex.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

}


