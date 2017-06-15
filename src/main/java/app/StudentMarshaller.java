package app;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import trng.imcs.jaxb.Address;
import trng.imcs.jaxb.Address;
import trng.imcs.jaxb.Marks;
import trng.imcs.jaxb.Student;

public class StudentMarshaller {

	public static void main(String[] args) throws DatatypeConfigurationException {
		try {

			// File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// StringWriter stringWriter = new StringWriter();
			// jaxbMarshaller.marshal(getEmployee(), stringWriter);
			jaxbMarshaller.marshal(getStudent(), System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	private static Student getStudent() throws DatatypeConfigurationException {

		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar joinDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

		Student student = new Student();
		Address address = new Address(); 
		Marks marks = new Marks();
		
		student.setStudentId(1001);
		student.setFirstName("Dinesh");
		student.setLastName("Kumar");
		
		address.setAddressLine("glenn crossett ct");
		address.setCity("Dallas");
		address.setState("TX");
		address.setZipcode(76013);
		address.setAddressType("COMM");
		
		marks.setSubjects("MATH");
		marks.setMarks("50.00");
		
		student.getAddress().add(address );
		return student;
	}

}
