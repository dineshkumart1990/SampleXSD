package app;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import trng.imcs.jaxb.Marks;
import trng.imcs.jaxb.Address;
import trng.imcs.jaxb.Student;

public class StudentUnMarshaller {

	public static void main(String[] args) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Student student = (Student) jaxbUnmarshaller.unmarshal(new File("C:/TEMP/emp/Employee.xml"));
			System.out.println(student.getStudentId());
			System.out.println(student.getFirstName());
			System.out.println(student.getLastName());
			List<Address> address = student.getAddress();
			System.out.println(address.get(0).getAddressLine());
			System.out.println(address.get(0).getCity());
			System.out.println(address.get(0).getState());
			System.out.println(address.get(0).getZipcode());
			        
			   
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}

}
