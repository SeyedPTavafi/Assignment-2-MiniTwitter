// Seyed Tavafi
// CS3560
// miniTweeter project
package Group;

import Message.Message;
import User.User;

interface Groupable {
	
	/**
     * This method is used to set id
     * 
     * @param id This is the first paramter
     */

    public void setId(String id);
    
    
    /**
     * This method is used to add user to users array
     * 
     * @param user This is the first paramter
     */

    public void setUsers(User user);
    
    
    /**
     * This method is used to add sub group to sub group array
     * 
     * @param group This is the first paramter
     */

    public void setSubgroups(Group group);
    
    /**
     * This method is used to remove user from users array
     * 
     * @param user This is the first paramter
     */

    public void deleteUser(User user);
    
    /**
     * This method is used to remove sub group from sub group array
     * 
     * @param group This is the first paramter
     */

    public void deleteSubGroups(Group group);
    
    /**
     * This method is used to set message
     * 
     * @param messages This is the first paramter
     */

    public void setMessages(Message[] messages);
    
    /**
     * This method is used to get id
     * 
     * @return String This returns id.
     */

    public String getId();

    
    /**
     * This method is used to get users
     * 
     * @return String This returns users.
     */
    public User[] getUsers();
    
    /**
     * This method is used to get messages
     * 
     * @return String This returns messages.
     */

    public Message[] getMessages();
    
    /**
     * This method is used to set super group
     * 
     * @param group This is the first paramter
     */

    public void setSuperGroup(Group group);
    
    /**
     * This method is used to get super group
     * 
     * @return String This returns super group.
     */

    public Group getSuperGroup();
    
    /**
     * This method is used to get sub group
     * 
     * @return String This returns sub group.
     */

    public Group[] getSubgroups();

}