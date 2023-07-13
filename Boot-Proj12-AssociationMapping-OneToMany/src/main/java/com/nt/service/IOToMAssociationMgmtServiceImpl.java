package com.nt.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumberRepository;

@Service("OToMService")
public class IOToMAssociationMgmtServiceImpl implements IOToMAssociationMgmtService {

	@Autowired
	private IPersonRepository personRepo;
	@Autowired
	private IPhoneNumberRepository phoneNumberRepo;
	@Override
	public void saveDataUsingParent() {
		//create parent object
		Person per=new Person("raja", "hyd");
		//create child objects
		PhoneNumber ph1=new PhoneNumber(99999999L, "airtel", "personal");
		PhoneNumber ph2=new PhoneNumber(88888888L, "jio", "office");
   
		//add parent to child
		ph1.setPersonInfo(per);
		ph2.setPersonInfo(per);
		
		//add childs to parent
		Set<PhoneNumber> phoneset=new HashSet();
		phoneset.add(ph1);phoneset.add(ph2);
		per.setContactDetails(phoneset);
		
		//save the parent object
		personRepo.save(per);
		System.out.println("Person and his associated  phoneNumbers are Saved(Parent to child)");

	}
	@Override
	public void saveDataUsingChild() {
		//create parent object
				Person per=new Person("ashok", "chennai");
				//create child objects
				PhoneNumber ph1=new PhoneNumber(99999999L, "vodafone", "personal");
				PhoneNumber ph2=new PhoneNumber(88888888L, "idea", "office");
		   
				//add parent to child
				ph1.setPersonInfo(per);ph2.setPersonInfo(per);
				
				//add childs to parent
				Set<PhoneNumber> phoneset=new HashSet();
				phoneset.add(ph1);phoneset.add(ph2);
				per.setContactDetails(phoneset);
				
				//save the child object
				phoneNumberRepo.save(ph1);
				phoneNumberRepo.save(ph2);
				System.out.println("Person and his associated  phoneNumbers are Saved(Child to Parent)");

		
	}
	@Override
	public void loadDataUsingParent() {
		Iterable<Person> it=personRepo.findAll();
		it.forEach(per->{
			System.out.println("Parent::"+per);
			//get childs of each parent
			Set<PhoneNumber> childs=per.getContactDetails();
			System.out.println("Childs count::"+childs.size());
			childs.forEach(ph->{
				System.out.println("child::"+ph);
			});
		});
		
	}
	@Override
	public void deleteDataUsingParentById(int id) {
		//load parent object by id
		Optional<Person> opt=personRepo.findById(id);
		if(opt.isPresent()) {
			Person per=opt.get();
			personRepo.delete(per);
			System.out.println("Parent and the associated child objects are deleted");
		}
		else {
			System.out.println(id+" Person not found for deletion");
		}
		
	}
	@Override
	public void deleteAllChildsOfAParentById(int id) {
		Optional<Person> opt=personRepo.findById(id);
		if(opt.isPresent()) {
			Person per=opt.get();
			
			//get all childs of a person
			Set<PhoneNumber> childs=per.getContactDetails();
			//remove parent link from childs
			childs.forEach(ph->{
				ph.setPersonInfo(null);
			});
			//delete all child objects
			phoneNumberRepo.deleteAll(childs);
			System.out.println("Only the child of a parent are deleted");
		}
		else {
			System.out.println(id+" Person not found for deletion");
		}
		
	}
	@Override
	public void addNewChildToAParentById(int id) {
		//Load parent object
		Optional<Person> opt=personRepo.findById(id);
		if(opt.isPresent()) {
			Person per=opt.get();
			//get childs of a parent
			Set<PhoneNumber> childs=per.getContactDetails();
			childs.add(null);
			
			//create the new child object
			PhoneNumber ph=new PhoneNumber(777777L,"vodafone","Personal");
			//link child to parent
			ph.setPersonInfo(per);
			childs.add(ph);
			phoneNumberRepo.save(ph);
			System.out.println("New child is added to  the existing of a parent id");
		}
		else {
			System.out.println(id+" Person not found for operation");
		}
		
	}

}
