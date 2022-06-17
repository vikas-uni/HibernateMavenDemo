package hibernate_example.locking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "EmployeeLocking")
public class EmployeeLocking {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	  private Integer id;
	  @Version
	  private long version;
	  @Column(name = "NAME")
	  private String name;
	  @Column(name = "DEPARTMENT")
	  private String department;
	public EmployeeLocking(String string, String string2) {
		// TODO Auto-generated constructor stub
		this.name = string;
		this.department = string2;
	}
	
	
	public EmployeeLocking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "EmployeeLocking [id=" + id + ", version=" + version + ", name="
				+ name + ", department=" + department + "]";
	}
	
}
