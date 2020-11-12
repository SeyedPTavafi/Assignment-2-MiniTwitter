// Seyed Tavafi
// CS3560
// miniTweeter project
package Message;

import User.User;

interface Messageable {
	
	 /**
     * This method is used to set message
     * 
     * @param message This is the first paramter
     */
    public void setMessage(String message);
    
    /**
     * This method is used to get message
     * 
     * @return String This returns message.
     */
    public String getMessage();
    
    
    /**
     * This method is used to set user
     * 
     * @param user This is the first paramter
     */

    public void setUser(User user);
    
    /**
     * This method is used to get user
     * 
     * @return User This returns user.
     */

    public User getUser();
}
