package com.goodness.tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goodness.tracker.entities.Tracker;
import com.goodness.tracker.repos.TrackerRepository;

@RestController
public class TrackerController {

	@Autowired
	TrackerRepository repository;

	//Returns all expenses
	@RequestMapping(value = "/expenses/", method = RequestMethod.GET)
	public List<Tracker> checkExpense() {
		return repository.findAll();
	}

	//Returns a single expense
	@RequestMapping(value = "/expenses/{id}", method = RequestMethod.GET)
	public Tracker checkExpense(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}

	//To add an expense
	@RequestMapping(value = "/expenses/", method = RequestMethod.PUT)
	public Tracker addExpense(Tracker tracker) {
		return repository.save(tracker);
	}
	
	//update an expense
	@RequestMapping(value = "/expenses/", method = RequestMethod.POST)
	public Tracker updateExpense(Tracker tracker) {
		return repository.save(tracker);
	}

	//Delete an Expense
	@RequestMapping(value = "/expenses/{id}", method = RequestMethod.DELETE)
	public void deleteExpense(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

}
