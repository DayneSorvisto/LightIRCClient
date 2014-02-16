
/** Lightweight IRC Client based on PIRC API 
 * Copyright (C) 2014 Author
 * Dayne Sorvisto
 */

import javax.swing.JFrame;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;

import javax.swing.JTextField;

public class IrcBot extends PircBot {

    public ChatApp gui; // instance variable contains reference to GUI

    public String current = ""; //Stores the current channel

    public String channel = ""; //Stores the default channel

    public String nick = " "; //Enter a nickname to use on server

    public List<String> windows = new ArrayList<String>();

    /**
     * This method gets topic and passes it as a string to the GUI
     */
    @Override
    protected void onTopic(String channel, String topic, String setBy, long date, boolean changed) {

        gui.appendTopic(topic);

    }

    /**
     * This method receives the message string received from the IRC server and
     * parses various IRC commands according to RFC specification
     */
    public boolean commands(String msg) {

        if (msg.startsWith("/join")) {

            msg = msg.replaceAll("/join", "");

            channel = msg.trim();

            windows.add(channel);

            this.current = channel;

            this.joinChannel(channel);

            return true;
        } else if (msg.startsWith("/nick")) {

            msg = msg.replaceAll("/nick", "");

            nick = msg.trim();

            this.changeNick(nick);

            return true;
        } else if (msg.startsWith("/window")) {

            msg = msg.replaceAll("/window", "");

            channel = msg.trim();

            windows.add(channel);

            this.current = channel;

            this.joinChannel(channel);

            return true;
        } else if (msg.startsWith("/part")) {

            this.partChannel(this.channel);

            windows.remove(this.channel);

            return true;

        } else if (msg.startsWith("/print")) {

            for (String s : windows) {

                System.out.println(s);
            }

            return true;
        } else if (msg.startsWith("/nick")) {

            msg = msg.replaceAll("/nick", "");

            this.nick = msg.trim();

            return true;
        } else if (msg.startsWith("/users")) {

            gui.listUsers(this.getUsers(current));

            return true;

        } else {

            return false;
        }

    }

    /**
     * Receives a message from the server and passes it to the GUI
     */
    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message) {

        gui.appendMessage(sender + ": " + message);

    }

    /**
     * Public constructor for IrcBot class takes one parameter
     *
     * @Parameter gui is a reference to our GUI operating in the background
     */

    public IrcBot(ChatApp gui) {

        this.gui = gui; //we need to pass reference to our gui to this instance variable

        gui.setDisplay(true);

        gui.listen(this);

    }

}
