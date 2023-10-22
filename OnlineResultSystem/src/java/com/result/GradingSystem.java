/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped


public class GradingSystem {
    ArrayList<GradingSystem> list;

    
    int roll;
    int reg;
    String name;
    int attendence;
    String status;
    int bangla;
    int english;
    int math;
    int physics;
    int chemistry;
    int biology;
    int total;
    int avergage;
    double gpa;
    String letter;

    public GradingSystem() {
    }

    public GradingSystem(ArrayList<GradingSystem> list, int roll, int reg, String name, int attendence, String status, int bangla, int english, int math, int physics, int chemistry, int biology, int total, int avergage, double gpa, String letter) {
        this.list = list;
        this.roll = roll;
        this.reg = reg;
        this.name = name;
        this.attendence = attendence;
        this.status = status;
        this.bangla = bangla;
        this.english = english;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        this.biology = biology;
        this.total = total;
        this.avergage = avergage;
        this.gpa = gpa;
        this.letter = letter;
    }

   

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getReg() {
        return reg;
    }

    public void setReg(int reg) {
        this.reg = reg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttendence() {
        return attendence;
    }

    public void setAttendence(int attendence) {
        this.attendence = attendence;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBangla() {
        return bangla;
    }

    public void setBangla(int bangla) {
        this.bangla = bangla;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getBiology() {
        return biology;
    }

    public void setBiology(int biology) {
        this.biology = biology;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAvergage() {
        return avergage;
    }

    public void setAvergage(int avergage) {
        this.avergage = avergage;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
    public ArrayList<GradingSystem> getList() {
        return list;
    }

    public void setList(ArrayList<GradingSystem> list) {
        this.list = list;
    }
    public void total(){
        total= (bangla+english+math+physics+chemistry+biology);
    }
    
    public void average(){
        avergage = (bangla+english+math+physics+chemistry+biology)/6;
    }
    
    public void percentage(){
        if(attendence>=30){
            status= "95%";
        }
        else if(attendence>=25){
            status="85%";
        }
        else if(attendence>=20){
            status="75%";
        }
        else if(attendence>=18){
            status="60%";
        }
        else{
            status="Unable to Attend Exam";
        }  
    }
    public void gpa(){
        if(avergage>=80){
            letter="A+";
        }
        else if(avergage>=75){
            letter="A";
        }
        else if(avergage>=70){
            letter="A-";
        }
       
        
        else if(avergage>=60){
            letter="B";
        }
        else if(avergage>=50){
            letter="C";
        }
        
        else if(avergage>=33){
           letter="D";
        }
        else{
           letter="F";
        }
        
    }
    public void letter(){
        if(avergage>=80){
            gpa=5.00;
        }
        else if(avergage>=75){
            gpa=4.50;
        }
        else if(avergage>=70){
            gpa=4.00;
        }
        else if(avergage>=65){
            gpa=3.50;
        }
        else if(avergage>=60){
            gpa=3.00;
        }
        else if(avergage>=50){
            gpa=2.50;
        }
        else if(avergage>=40){
            gpa=2.00;
        }else if(avergage>=33){
           letter="D";
        }
        else{
            letter="F";
        }
    }
    public void save(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "Rohan@2008oxford");
            PreparedStatement ps = c.prepareStatement("INSERT into student VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, roll);
            ps.setInt(2, reg);
            ps.setString(3, name);
            ps.setInt(4, attendence);
            ps.setInt(5, bangla);
            ps.setInt(6, english);
            ps.setInt(7, math);
            ps.setInt(8, physics);
            ps.setInt(9, chemistry);
            ps.setInt(10, biology);
            ps.setInt(11, total);
            ps.setInt(12, avergage);
            ps.setDouble(13, gpa);
            ps.setString(14, letter);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    
    
    public String show(){
        percentage();
        total();
        average();
        gpa();
        letter();
        save();
        
        return "Show.xhtml";
    }
    
    
    public String display(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "Rohan@2008oxford");
            PreparedStatement pst = con.prepareStatement("Select * From student");
            GradingSystem gr;
            ResultSet rs = pst.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                gr = new GradingSystem();
                gr.setRoll(rs.getInt(1));
                gr.setReg(rs.getInt(2));
                gr.setName(rs.getString(3));
                gr.setAttendence(rs.getInt(4));
                gr.setBangla(rs.getInt(5));
                gr.setEnglish(rs.getInt(6));
                gr.setMath(rs.getInt(7));
                gr.setPhysics(rs.getInt(8));
                gr.setChemistry(rs.getInt(9));
                gr.setBiology(rs.getInt(10));
                gr.setTotal(rs.getInt(11));
                gr.setAvergage(rs.getInt(12));
                gr.setGpa(rs.getDouble(13));
                gr.setLetter(rs.getString(14));
                
                list.add(gr);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
     

        return "Display.xhtml";
    }
    
    public String result() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "nh123456");
            PreparedStatement pst = con.prepareStatement("Select * From student where roll=? AND reg=?");
            pst.setInt(1, roll);
            pst.setInt(2, reg);
            GradingSystem gs;
            ResultSet rs = pst.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                gs = new GradingSystem();
                gs.setRoll(rs.getInt(1));
                gs.setReg(rs.getInt(2));
                gs.setName(rs.getString(3));
                gs.setAttendence(rs.getInt(4));
                gs.setBangla(rs.getInt(5));
                gs.setEnglish(rs.getInt(6));
                gs.setMath(rs.getInt(7));
                gs.setPhysics(rs.getInt(8));
                gs.setChemistry(rs.getInt(9));
                gs.setBiology(rs.getInt(10));
                gs.setTotal(rs.getInt(11));
                gs.setAvergage(rs.getInt(12));
                gs.setGpa(rs.getDouble(13));
                gs.setLetter(rs.getString(14));
                list.add(gs);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return "Result.xhtml";
    }


    
    
    
}
