package market.pavelpadalka.u.com.gitlab.dto;

import market.pavelpadalka.u.com.gitlab.entity.UserSex;
import market.pavelpadalka.u.com.gitlab.entity.UserRole;

import java.sql.Date;
import java.util.List;

public class UserDTO {

    private Integer  id;
    private String   firstName;
    private String   lastName;
    private Date     birthday;
    private String   login;
    private String   password;
    private UserSex  sex;
    private String   email;
    private UserRoleDTO role;
    private List<HistoryDTO> historyDTOList;


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

    public UserRoleDTO getRole() {
        return role;
    }

    public void setRole(UserRoleDTO role) {
        this.role = role;
    }

    public List<HistoryDTO> getHistoryDTOList() {
        return historyDTOList;
    }

    public void setHistoryDTOList(List<HistoryDTO> historyDTOList) {
        this.historyDTOList = historyDTOList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (!id.equals(userDTO.id)) return false;
        if (!firstName.equals(userDTO.firstName)) return false;
        if (!lastName.equals(userDTO.lastName)) return false;
        if (!birthday.equals(userDTO.birthday)) return false;
        if (!login.equals(userDTO.login)) return false;
        if (!password.equals(userDTO.password)) return false;
        if (sex != userDTO.sex) return false;
        if (!email.equals(userDTO.email)) return false;
        return role.equals(userDTO.role);

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
        result = 31 * result + role.hashCode();
        return result;
    }

}
