/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Arturo
 */
@XmlRootElement
public class Classroom {
    String name;
    int capacity;
    String teacher;
    String[] students;
    
    public Classroom(){
        name="";
        capacity = 0;
        teacher = "";
        students = new String[]{""};
    }
    
    public Classroom(String na,int cap,String tea,String[] stu){
    this.name = na;
    this.capacity=cap;
    this.students = stu;
    this.teacher = tea;
    }
    
    public int getCapacity(){return capacity;}
    
    public String getTeacher(){return teacher;}
    
    public String[] getStudents(){return students;}
    
    public String getName(){return name;}
    
    @XmlAttribute
    public void setName(String na){name= na;}
    @XmlElement
    public void setCapacity(int i){capacity = i;}
    @XmlElement
    public void setTeacher(String str){teacher = str;}
    @XmlElement
    public void setStudents(String[] stu){students = stu;}
}
