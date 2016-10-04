package com.example.outgoing.Controller;

import com.example.outgoing.Entity.User;
import com.example.outgoing.Service.UserService;
import com.example.outgoing.Utility.ApplicationHelpers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

//@Getter
//@Setter
@ManagedBean
@ViewScoped
public class UserController implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{userService}")
    UserService userService;

    private User user = new User();
    private List<User> users;
    private String currentPassword;

    public String register(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userService.save(user);
        return "login.xhtml?faces-redirect=true";
    }

    public List<User> findAllUsers() {
        users = userService.findAll();
        return users;
    }

    public User userProfile(){
        String username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        user = userService.findByUsername(username);
        return user;
    }

    public String changePassword(){
        FacesContext fc = FacesContext.getCurrentInstance();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        User currentUser = userService.findByUsername(username);

        if( passwordEncoder.matches(getCurrentPassword(), currentUser.getPassword())){
            try {
                String newHashedPassword = passwordEncoder.encode(user.getPassword());
                currentUser.setPassword(newHashedPassword);
                userService.save(currentUser);
                ApplicationHelpers.setSuccessMessage("Password changed successfully", null);
            }
            catch (Exception e) {
                ApplicationHelpers.setErrorMessage("There was an error, please try again!", null);
            }
        } else {
            ApplicationHelpers.setErrorMessage("Current password is not correct!", "currentPassword");
        }
        fc.renderResponse();
        return "/";
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }
}
