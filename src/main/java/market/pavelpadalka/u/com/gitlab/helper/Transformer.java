package market.pavelpadalka.u.com.gitlab.helper;

import market.pavelpadalka.u.com.gitlab.dto.*;
import market.pavelpadalka.u.com.gitlab.entity.*;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import java.util.LinkedList;
import java.util.List;

public class Transformer {


    public static UserDTO transformUserToUserDTO(User user) {

        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

        return mapper.map(user, UserDTO.class);

    }

    public static UserRoleDTO transformUserRoleToUserRoleDTO(UserRole userRole) {

        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

        return mapper.map(userRole, UserRoleDTO.class);

    }

    public static UserRole transformUserRoleDTOToUserRole(UserRoleDTO userRoleDTO) {

        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

        return mapper.map(userRoleDTO, UserRole.class);

    }

    public static User transformUserDTOToUser(UserDTO userDTO) {

        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

        return mapper.map(userDTO, User.class);

    }


    public static List<User> transformListUserDTOToListUser(List<UserDTO> userDTOList) {

        List<User> users = new LinkedList<User>();

        for (UserDTO userDTO : userDTOList)
        {
            User user = transformUserDTOToUser(userDTO);
            users.add(user);
        }

        return users;

    }

    public static List<UserDTO> transformListUserToListUserDTO(List<User> userList) {

        List<UserDTO> usersDTO = new LinkedList<UserDTO>();

        for (User user : userList)
        {
            UserDTO userDTO = transformUserToUserDTO(user);
            usersDTO.add(userDTO);
        }

        return usersDTO;

    }

    public static ProductDTO transformProductToProductDTO(Product product) {

        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

        return mapper.map(product, ProductDTO.class);

    }

    public static Product transformProductDTOToProduct(ProductDTO productDTO) {

        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

        return mapper.map(productDTO, Product.class);

    }

    public static List<Product> transformListProductDTOToListProduct(List<ProductDTO> productDTOList) {

        List<Product> products = new LinkedList<Product>();

        for (ProductDTO productDTO : productDTOList)
        {
            Product product = transformProductDTOToProduct(productDTO);
            products.add(product);
        }

        return products;

    }

    public static List<ProductDTO> transformListProductToListProductDTO(List<Product> productList) {

        List<ProductDTO> productsDTO = new LinkedList<ProductDTO>();

        for (Product product : productList)
        {
            ProductDTO productDTO = transformProductToProductDTO(product);
            productsDTO.add(productDTO);
        }

        return productsDTO;

    }

    public static ProductGroupDTO transformProductGroupToProductGroupDTO(ProductGroup productGroup) {

        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

        return mapper.map(productGroup, ProductGroupDTO.class);

    }

    public static ProductGroup transformProductGroupDTOToProductGroup(ProductGroupDTO productGroupDTO) {

        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

        return mapper.map(productGroupDTO, ProductGroup.class);

    }

    public static List<ProductGroup> transformListProductGroupDTOToListProductGroup(List<ProductGroupDTO> productGroupDTOList) {

        List<ProductGroup> productGroups = new LinkedList<ProductGroup>();

        for (ProductGroupDTO productGroupDTO : productGroupDTOList)
        {
            ProductGroup productGroup = transformProductGroupDTOToProductGroup(productGroupDTO);
            productGroups.add(productGroup);
        }

        return productGroups;

    }

    public static List<ProductGroupDTO> transformListProductGroupToListProductGroupDTO(List<ProductGroup> productGroupList) {

        List<ProductGroupDTO> productGroupsDTO = new LinkedList<ProductGroupDTO>();

        for (ProductGroup productGroup : productGroupList)
        {
            ProductGroupDTO productGroupDTO = transformProductGroupToProductGroupDTO(productGroup);
            productGroupsDTO.add(productGroupDTO);
        }

        return productGroupsDTO;

    }

    public static HistoryDTO transformHistoryToHistoryDTO(History history) {

        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

        return mapper.map(history, HistoryDTO.class);

    }

    public static History transformHistoryDTOToHistory(HistoryDTO historyDTO) {

        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

        return mapper.map(historyDTO, History.class);

    }

    public static List<History> transformListHistoryDTOToListHistory(List<HistoryDTO> historyDTOList) {

        List<History> histories = new LinkedList<History>();

        for (HistoryDTO historyDTO : historyDTOList)
        {
            History history = transformHistoryDTOToHistory(historyDTO);
            histories.add(history);
        }

        return histories;

    }

    public static List<HistoryDTO> transformListHistoryToListHistoryDTO(List<History> historyList) {

        List<HistoryDTO> transactionsDTO = new LinkedList<HistoryDTO>();

        for (History history : historyList)
        {
            HistoryDTO historyDTO = transformHistoryToHistoryDTO(history);
            transactionsDTO.add(historyDTO);
        }

        return transactionsDTO;

    }

}
