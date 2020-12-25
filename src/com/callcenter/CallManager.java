package com.callcenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CallManager {
	private static int level = 3;
	private List<Employee>[] employees;
	private Queue<Call> callQueue;

	@SuppressWarnings("unchecked")
	public CallManager(int noOfRespondents, int noOfManager) {
		this.employees = new ArrayList[level];
		this.callQueue = new LinkedList<>();

		/*** Add Respondents ***/
		List<Employee> respondents = new ArrayList<Employee>();
		for (int i = 0; i < noOfRespondents; i++) {
			Employee emp = new Respondent("Respondent-" + i, true, this);
			respondents.add(emp);
		}
		employees[0] = respondents;

		/*** Add Managers ***/
		List<Employee> managers = new ArrayList<Employee>();
		for (int i = 0; i < noOfManager; i++) {
			Employee emp = new Manager("Manager-" + i, true, this);
			managers.add(emp);
		}
		employees[1] = managers;

		/*** Add only one Director ***/
		List<Employee> directors = new ArrayList<Employee>();
		directors.add(new Director("Director-1", true, this));
		employees[2] = directors;

	}

	public Employee getAvailableEmployee(int rank) {
		if (rank < 0 || rank > level) {
			throw new RankNotFoundException("Invalid rank should be 0-" + level);
		}
		int tempRank = rank;
		while (tempRank <= level) {
			List<Employee> emps = employees[tempRank++];
			for (Employee emp : emps) {
				if (emp.isFree)
					return emp;
			}
			System.out.println("Call is escalated to level " + tempRank);

		}

		return null;
	}

	public void callHandler(Call call) {
		Employee availEmp = getAvailableEmployee(call.getRank());
		if (availEmp != null) {
			call.setRank(availEmp.getRank());
			availEmp.recieveCall(call);
		} else {
			callQueue.add(call);
		}
	}

	/*** Here we can set scheduler of gap 5-10 minutes ***/
	public void handleCallFromQueue() {
		if (callQueue.size() > 0) {
			Call call = callQueue.peek();
			int rank = call.getRank();
			Employee emp = getAvailableEmployee(rank);
			if (emp != null) {
				emp.recieveCall(call);
				callQueue.remove();
			}

		}
	}

}
