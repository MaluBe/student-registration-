import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
@ManagedBean
@SessionScoped
public class Login implements Serializable {
  private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
  
  
   

    public String method1() throws SQLException, ClassNotFoundException {
        boolean num = myself(username, password);
        if (num) {
              DBConnection dbcon = new DBConnection();
              Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("select username from information where USERNAME=?");
            ps.setString(1, username);       
            ResultSet rs = ps.executeQuery();
            rs.next();
            String userType =rs.getString(1);
            if ("malu".equals(userType)) {
                return "form";
            } else {
                return "user";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            ""));
            return "admin";
        }
    }


 public static boolean myself(String name, String password) {
        boolean status = false;
        try {
            DBConnection obj = new DBConnection();
            Connection conn = obj.connMethod();
            PreparedStatement ps = conn.prepareStatement("select * from information where USERNAME=? and PASSWORD=?");
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
         
        }
        return status;
    }
}