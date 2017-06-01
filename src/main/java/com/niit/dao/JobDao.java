package com.niit.dao;

import java.util.List;

import com.niit.domain.Job;

public interface JobDao {

	public boolean insertJob(Job job);

	public List<Job> list();

	public boolean deleteJob(String id);

	public Job getJobById(String id);

}
