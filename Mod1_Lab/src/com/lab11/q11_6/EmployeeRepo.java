package com.lab11.q11_6;

import java.util.HashMap;
import java.util.Map;

public class EmployeeRepo implements IEmployeeRepo {

	Map<Integer,Employee> hm = new HashMap<>();
	
	public boolean save(Employee e)
	{
		if(!hm.containsKey(e.getEmpId()))
		{
		return false;
		}
		hm.put(e.getEmpId(), e);
		return true;
	}
	
	public Employee showById(int empId)
	{
		if(hm.containsKey(empId))
		{
			return hm.get(empId);
		}
		return null;
	}
}
