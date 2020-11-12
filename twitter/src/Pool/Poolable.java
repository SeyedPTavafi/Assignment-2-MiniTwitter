// Seyed Tavafi
// CS3560
// miniTweeter project
package Pool;

import java.util.List;

import Group.Group;
import Message.Message;
import User.User;

interface Poolable {
	
	 /**
     * This method is used to add users to users list
     *
     * @param user This is the first paramter
     */
    public void addUser(User user);
    
    /**
     * This method is used to get users list
     *
     * @return List This returns users list.
     */

    public List getUsers();
    
    /**
     * This method is used to add group to groups list
     *
     * @param group This is the first paramter
     */

    public void addGroup(Group group);
    
    /**
     * This method is used to get groups list
     *
     * @return List This returns groups list.
     */

    public List getGroups();
    
    /**
     * This method is used to add message to message list
     *
     * @param message This is the first paramter
     */

    public void addMessage(Message message);
    
    /**
     * This method is used to get messages list
     *
     * @return List This returns messages list.
     */

    public List getMessages();
}
