package comdxc.services;

import java.util.ArrayList;
import java.util.List;

import com.dxc.entity.Student;

public class StudentRegistrationService {
	    private List<Student> studentRecords;
	    private static StudentRegistrationService stdregd = null;
	    private StudentRegistrationService(){
	    studentRecords = new ArrayList<Student>();
	    }
	    public static StudentRegistrationService getInstance() {
	        if(stdregd == null) {
	              stdregd = new StudentRegistrationService();
	              return stdregd;
	            }
	            else {
	                return stdregd;
	            }
	    }
	    public void add(Student std) {
	    studentRecords.add(std);
	    }
	public String upDateStudent(Student std) {
	for(int i=0; i<studentRecords.size(); i++)
	        {
	            Student stdn = studentRecords.get(i);
	            if(stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
	              studentRecords.set(i, std);//update the new record
	              return "Update successful";
	            }
	        }
	return "Update un-successful";
	}
	public String deleteStudent(String registrationNumber) {
	for(int i=0; i<studentRecords.size(); i++)
	        {
	            Student stdn = studentRecords.get(i);
	            if(stdn.getRegistrationNumber().equals(registrationNumber)){
	              studentRecords.remove(i);//update the new record
	              return "Delete successful";
	            }
	        }
	return "Delete un-successful";
	}
	    public List<Student> getStudentRecords() {
	    return studentRecords;
	    }
	}
