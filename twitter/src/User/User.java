// Seyed Tavafi
// CS3560
// miniTweeter project
package User;

import java.util.Arrays;

import Group.Group;
import Message.Message;

public class User {
    private String id;
    private Group group = null;
    private Message[] recivedMessages = {};
    private Message[] sentMessages = {};
    private User[] followers = {};
    private User[] followings = {};

    public User(String id) {
        setId(id);
    }

    /**
     * This method is used to set id
     * 
     * @param id This is the first paramter
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method is used to set group
     * 
     * @param group This is the first paramter
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * This method is used to set follower to follower array
     * 
     * @param follower This is the first paramter
     */
    public void setFollowers(User follower) {
        int n = this.followers.length;
        User[] array = new User[n + 1];
        for (int i = 0; i < n; i++)
            array[i] = followers[i];
        array[n] = follower;
        this.followers = array;
    }

    /**
     * This method is used to set following to following array
     * 
     * @param following This is the first paramter
     */
    public void setFollowing(User following) {
        int n = this.followings.length;
        User[] array = new User[n + 1];
        for (int i = 0; i < n; i++)
            array[i] = followings[i];
        array[n] = following;
        this.followings = array;
    }

    /**
     * This method is used to set sent message to sent message array
     * 
     * @param sentMessage This is the first paramter
     */
    public void setSentMessages(Message sentMessage) {
        int n = this.sentMessages.length;
        Message[] array = new Message[n + 1];
        for (int i = 0; i < n; i++)
            array[i] = sentMessages[i];
        array[n] = sentMessage;
        this.sentMessages = array;
    }

    /**
     * This method is used to set recived message to recived message array
     * 
     * @param recivedMessage This is the first paramter
     */
    public void setRecivedMessages(Message recivedMessage) {
        int n = this.recivedMessages.length;
        Message[] array = new Message[n + 1];
        for (int i = 0; i < n; i++)
            array[i] = recivedMessages[i];
        array[n] = recivedMessage;
        this.recivedMessages = array;
    }

    /**
     * This method is used to get id
     * 
     * @return id This returns id.
     */
    public String getId() {
        return id;
    }

    /**
     * This method is used to get group
     * 
     * @return group This returns group.
     */
    public Group getGroup() {
        return group;
    }

    /**
     * This method is used to get followers
     * 
     * @return User[] This returns followers.
     */
    public User[] getFollowers() {
        return followers;
    }

    /**
     * This method is used to get followings
     * 
     * @return User[] This returns followings.
     */
    public User[] getFollowings() {
        return followings;
    }

    /**
     * This method is used to get sentMessages
     * 
     * @return Message[] This returns sentMessages.
     */
    public Message[] getSentMessages() {
        return sentMessages;
    }

    /**
     * This method is used to get recivedMessages
     * 
     * @return Message[] This returns recivedMessages.
     */
    public Message[] getRecivedMessages() {
        return recivedMessages;
    }

    @Override
    public String toString() {
        return "id : " + id + "sent messages=" + Arrays.toString(sentMessages) + "recived messages="
                + Arrays.toString(recivedMessages);

    }
}
