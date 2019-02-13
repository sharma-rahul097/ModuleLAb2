package com.lab10.q10_2.bean;

public class Employee {
	
	private int id;
	private String name;
	private double salary;
	private String inScheme;
	public enum Designation{
		Clerk, Manager, System_Associate, Programmer
	};
	Designation deg;
	

	public Employee(int id, String name, double salary, Designation designation) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.deg = designation;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getInScheme() {
		return inScheme;
	}

	public void setInScheme(String inScheme) {
		this.inScheme = inScheme;
	}
	public Designation getDeg() {
		return deg;
	}

	public void setDeg(Designation deg) {
		this.deg = deg;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", inScheme=" + inScheme + ", deg="
				+ deg + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deg == null) ? 0 : deg.hashCode());
		result = prime * result + id;
		result = prime * result + ((inScheme == null) ? 0 : inScheme.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (deg != other.deg)
			return false;
		if (id != other.id)
			return false;
		if (inScheme == null) {
			if (other.inScheme != null)
				return false;
		} else if (!inScheme.equals(other.inScheme))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

}
