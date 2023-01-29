/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author malu
 */
@ManagedBean
@RequestScoped
public class Register {
private String fullName;
private BufferedImage b;

    public BufferedImage getB() {
        return b;
    }

    public void setB(BufferedImage b) {
        this.b = b;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
private String dateOfBirth;
private String college;
private String year;
private String department;
private String address;
private String id;
private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    
    
     public void malu() {
         try{
  Register reg = new Register();
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "insert into STUDENTS(FULLNAME,DATEOFBIRTH,COLLEGE,YEAR,DEPARTMENT,ADDRESS,GENDER,ID) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setString(8, id);
            ps.setString(1, fullName);  
            ps.setString(2, dateOfBirth);
            ps.setString(3, college);
            ps.setString(4, year);
            ps.setString(5, department);
            ps.setString(6, address);
            ps.setString(7,gender);
             // ps.setBlob(8, (Blob) b);
            ps.executeUpdate();
            } catch (Exception e){
             System.out.println("there is aproblem");     
}
}
}