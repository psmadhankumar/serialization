package io.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private int personId;

    private String name;

    private Date dateOfBirth;

    private transient int age;

    private String email;

    private Long someLongNum;

    private Float someFloatNum;
    
    private Map<String, Integer> marks;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSomeLongNum() {
        return someLongNum;
    }

    public void setSomeLongNum(Long someLongNum) {
        this.someLongNum = someLongNum;
    }

    public Float getSomeFloatNum() {
        return someFloatNum;
    }

    public void setSomeFloatNum(Float someFloatNum) {
        this.someFloatNum = someFloatNum;
    }
    
	public Map<String, Integer> getMarks() {
		return marks;
	}

	public void setMarks(Map<String, Integer> marks) {
		this.marks = marks;
	}
	
    @Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", age=" + age
				+ ", email=" + email + ", someLongNum=" + someLongNum + ", someFloatNum=" + someFloatNum + ", marks="
				+ marks + "]";
	}

	public static Person getSamplePerson() {
        Person person = new Person();
        person.setPersonId(100);
        person.setName("Mark");
        
        String dateFormat = "yyyyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
			date = sdf.parse("2000-05-21");
		} catch (ParseException e) {
			date = new Date();
		}
        person.setAge(calculateAge(date, sdf));
        person.setDateOfBirth(date);
        person.setEmail("sample@sample.com");
        person.setSomeFloatNum(1000f);
        person.setSomeLongNum(2000l);
        
        Map<String, Integer> map = new HashMap<>();
        map.put("Math", 80);
        map.put("Social", 90);
        map.put("Science", 70);
        person.setMarks(map);
        
        return person;
    }

	private static int calculateAge(Date birthdate, SimpleDateFormat sdf) {
	    int d1 = Integer.parseInt(sdf.format(birthdate));                            
	    int d2 = Integer.parseInt(sdf.format(new Date()));                          
	    int age = (d2 - d1) / 10000;                                                       
	    return age;    
	}
    
}
