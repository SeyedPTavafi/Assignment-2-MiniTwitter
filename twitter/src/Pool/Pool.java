// Seyed Tavafi
// CS3560
// miniTweeter project
package Pool;

import Group.Group;
import Message.Message;
import User.User;

import java.util.ArrayList;
import java.util.List;

public class Pool {

    private List users;
    private List groups;
    private List messages;

    public Pool() {
        users = new ArrayList();
        groups = new ArrayList();
        messages = new ArrayList();
    }

    /**
     * This method is used to add users to users list
     *
     * @param user This is the first paramter
     */
    public void addUser(User user) {
        this.users.add(user);
    }

    /**
     * This method is used to get users list
     *
     * @return List This returns users list.
     */
    public List getUsers() {
        return this.users;
    }

    /**
     * This method is used to add group to groups list
     *
     * @param group This is the first paramter
     */
    public void addGroup(Group group) {
        this.groups.add(group);
    }

    /**
     * This method is used to get groups list
     *
     * @return List This returns groups list.
     */
    public List getGroups() {
        return this.groups;
    }

    /**
     * This method is used to add message to message list
     *
     * @param message This is the first paramter
     */
    public void addMessage(Message message) {
        this.messages.add(message);
    }

    /**
     * This method is used to get messages list
     *
     * @return List This returns messages list.
     */
    public List getMessages() {
        return this.messages;
    }

    public String toString() {
        return "Pool{" + "users=" + users + ", groups=" + groups + ", messages=" + messages + '}';
    }

    /**
     * This method is used to search user in users list
     *
     * @param id    This is the first paramter
     * @param users This is the second paramter
     * @return User This returns user.
     */
    public static User searchUser(String id, List users) {
        User user = null;
        for (int i = 0; i < users.toArray().length; i++) {
            User u = (User) users.get(i);
            if (u.getId().equals(id)) {
                user = u;
            }
        }
        return user;
    }

    /**
     * This method is used to search group in groups list
     *
     * @param id     This is the first paramter
     * @param groups This is the second paramter
     * @return Group This returns group.
     */
    public static Group searchGroup(String id, List groups) {
        Group group = null;
        for (int i = 0; i < groups.toArray().length; i++) {
            Group g = (Group) groups.get(i);
            if (g.getId().equals(id)) {
                group = g;
            }
        }
        return group;
    }

    /**
     * This method is used to calculate percentage words
     *
     * @param word This is the first paramter
     * @return double This returns find word count.
     */
    public double calculatePercentageWords(String word) {
        double findWordCount = 0;
        if (messages.toArray().length != 0) {
            for (int i = 0; i < messages.toArray().length; i++) {
                Message msg = (Message) messages.toArray()[i];
                findWordCount = findWordCount + countOccurences(msg.getMessage(), word);
            }
            return Math.round((findWordCount / messages.toArray().length) * 100);
        }
        return findWordCount;
    }

    /**
     * This method is used to delete group in groups list when user change group
     *
     * @param groups This is the first paramter
     * @param group  This is the second paramter
     * @return list This returns group.
     */
    public static List deleteGroup(List groups, Group group) {
        if (groups.toArray().length == 0) {
            return groups;
        }
        List list = new ArrayList();
        for (int i = 0, k = 0; i < groups.toArray().length; i++) {
            Group g = (Group) groups.get(i);
            if (g.getId() == group.getId()) {
                continue;
            }
            list.add(g);
        }
        return list;
    }

    static int countOccurences(String str, String word) {
        String messageArray[] = str.split(" ");
        int count = 0;
        for (int i = 0; i < messageArray.length; i++) {
            if (word.equals(messageArray[i]))
                count++;
        }

        return count;
    }
}