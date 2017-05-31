package com.niit.dao;

import java.util.List;

import com.niit.domain.Friend;


public interface FriendDao {

	
public boolean insertFriend(Friend friend);
	
	public List<Friend> list();
	
	public boolean deleteFriend(String id);
	
	public Friend getFriendById(String id);
}
