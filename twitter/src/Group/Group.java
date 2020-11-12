// Seyed Tavafi
// CS3560
// miniTweeter project
package Group;

import User.User;
import Message.Message;

import java.util.Arrays;

public class Group implements Groupable{
    private String id;
    private User[] users = {};
    private Message[] messages = {};
    private Group superGroup = null;
    private Group[] subgroups = {};

    public Group(String id) {
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
     * This method is used to add user to users array
     * 
     * @param user This is the first paramter
     */
    public void setUsers(User user) {
        int n = this.users.length;
        User[] array = new User[n + 1];
        for (int i = 0; i < n; i++)
            array[i] = users[i];
        array[n] = user;
        this.users = array;
    }

    /**
     * This method is used to add sub group to sub group array
     * 
     * @param group This is the first paramter
     */
    public void setSubgroups(Group group) {
        int n = this.subgroups.length;
        Group[] array = new Group[n + 1];
        for (int i = 0; i < n; i++)
            array[i] = subgroups[i];
        array[n] = group;
        this.subgroups = array;
    }

    /**
     * This method is used to remove user from users array
     * 
     * @param user This is the first paramter
     */
    public void deleteUser(User user) {
        if (users.length == 0) {
            return;
        }
        User[] anotherArray = new User[users.length - 1];
        for (int i = 0, k = 0; i < users.length; i++) {
            if (users[i].getId() == user.getId()) {
                continue;
            }
            anotherArray[k++] = users[i];
        }
        users = anotherArray;
    }

    /**
     * This method is used to remove sub group from sub group array
     * 
     * @param group This is the first paramter
     */
    public void deleteSubGroups(Group group) {
        if (subgroups.length == 0) {
            return;
        }
        Group[] anotherArray = new Group[subgroups.length - 1];
        for (int i = 0, k = 0; i < subgroups.length; i++) {
            if (subgroups[i].getId() == group.getId()) {
                continue;
            }
            anotherArray[k++] = subgroups[i];
        }
        subgroups = anotherArray;
    }

    /**
     * This method is used to set message
     * 
     * @param messages This is the first paramter
     */
    public void setMessages(Message[] messages) {
        this.messages = messages;
    }

    /**
     * This method is used to get id
     * 
     * @return String This returns id.
     */
    public String getId() {
        return id;
    }

    /**
     * This method is used to get users
     * 
     * @return String This returns users.
     */
    public User[] getUsers() {
        return users;
    }

    /**
     * This method is used to get messages
     * 
     * @return String This returns messages.
     */
    public Message[] getMessages() {
        return messages;
    }

    /**
     * This method is used to set super group
     * 
     * @param group This is the first paramter
     */
    public void setSuperGroup(Group group) {
        superGroup = group;
    }

    /**
     * This method is used to get super group
     * 
     * @return String This returns super group.
     */
    public Group getSuperGroup() {
        return superGroup;
    }

    /**
     * This method is used to get sub group
     * 
     * @return String This returns sub group.
     */
    public Group[] getSubgroups() {
        return subgroups;
    }

    @Override
    public String toString() {
        return "Group{" + "id='" + id + '\'' + ", users=" + Arrays.toString(users) + ", messages="
                + Arrays.toString(messages) + ", superGroup=" + superGroup +
                // ", subgroups=" + Arrays.toString(subgroups) +
                '}';
    }
}
