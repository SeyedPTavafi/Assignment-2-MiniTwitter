// Seyed Tavafi
// CS3560
// miniTweeter project
package Message;

import User.User;

public class Message implements Messageable {

    private String message;
    private User user;

    public Message(String message) {
        setMessage(message);
    }

    /**
     * This method is used to set message
     * 
     * @param message This is the first paramter
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * This method is used to set user
     * 
     * @param user This is the first paramter
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * This method is used to get message
     * 
     * @return String This returns message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method is used to get user
     * 
     * @return User This returns user.
     */
    public User getUser() {
        return user;
    }

    public String toString() {
        return "Message{" + "message='" + message + '\'' + '}';
    }
}
