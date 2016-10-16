package Shop.pavelpadalka.u.com.gitlab;

import Shop.pavelpadalka.u.com.gitlab.dao.api.UserDAO;
import Shop.pavelpadalka.u.com.gitlab.dao.impl.UserDAOImpl;
import Shop.pavelpadalka.u.com.gitlab.entity.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        UserDAO userDAO = new UserDAOImpl();

        userDAO.create()

        List<User> contactList = UserDAO.findAll();

        List<ContactDTO> contactsDTOList = Transformer.transformContactListToContactDTOList(contactList);


    }

}
