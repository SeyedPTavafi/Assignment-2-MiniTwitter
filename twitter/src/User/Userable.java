// Seyed Tavafi
// CS3560
// miniTweeter project
package User;

import Group.Group;
import Message.Message;

interface Userable {
	
	 /**
     * This method is used to set id
     * 
     * @param id This is the first paramter
     */
    public void setId(String id);
    
    /**
     * This method is used to set group
     * 
     * @param group This is the first paramter
     */

    public void setGroup(Group group);
    
    /**
     * This method is used to set follower to follower array
     * 
     * @param follower This is the first paramter
     */

    public void setFollowers(User follower);
    
    /**
     * This method is used to set following to following array
     * 
     * @param following This is the first paramter
     */

    public void setFollowing(User following);
    
    /**
     * This method is used to set sent message to sent message array
     * 
     * @param sentMessage This is the first paramter
     */

    public void setSentMessages(Message sentMessage);
    
    /**
     * This method is used to set recived message to recived message array
     * 
     * @param recivedMessage This is the first paramter
     */

    public void setRecivedMessages(Message recivedMessage);
    
    /**
     * This method is used to get id
     * 
     * @return id This returns id.
     */

    public String getId();
    
    /**
     * This method is used to get group
     * 
     * @return group This returns group.
     */

    public Group getGroup();
    
    /**
     * This method is used to get followers
     * 
     * @return User[] This returns followers.
     */

    public User[] getFollowers();
    
    /**
     * This method is used to get followings
     * 
     * @return User[] This returns followings.
     */

    public User[] getFollowings();
    
    /**
     * This method is used to get sentMessages
     * 
     * @return Message[] This returns sentMessages.
     */

    public Message[] getSentMessages();
    
    /**
     * This method is used to get recivedMessages
     * 
     * @return Message[] This returns recivedMessages.
     */

    public Message[] getRecivedMessages();
}
