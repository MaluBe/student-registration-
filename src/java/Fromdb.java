
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Fromdb {
    
    public List<Register> getUserList() {
        List<Register> list = new ArrayList<>();
        try {
       
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from Students");
            while (rs.next()) {
                Register std = new Register();
                
                std.setFullName(rs.getString("FULLNAME"));
                std.setDateOfBirth(rs.getString("DATEOFBIRTH"));
                std.setCollege(rs.getString("COLLEGE"));
                std.setYear(rs.getString("YEAR"));
                std.setDepartment(rs.getString("DEPARTMENT"));
                std.setAddress(rs.getString("ADDRESS"));
                std.setGender(rs.getString("GENDER"));
                std.setId(rs.getString("ID"));
                //course[1]=rs.getString("COURSE");
                //usr.setCourse(course);
                list.add(std);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("here is the proplem");
                
        }
        return list;
    }

    
}
