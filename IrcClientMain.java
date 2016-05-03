/**
 * Lightweight IRC Client based on PIRC API
 * Copyright (C) 2014
 * Author Dayne Sorvisto
 */

import java.awt.*;
public class IrcClientMain
{
    private static ChatApp gui = new ChatApp();
    private static String channel = "#Test";
    private static String serverName = "irc.freenode.org";

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
                                   public void run() {
                                       ChatApp gui = new ChatApp();
                                   }
                               }
        );

        /**
         * By parsing the command line arguments, we expect to have potential different values for the
         * server name and the channel for the IRC
         */
        parseCommandLineArgs(args);

        //This is our IRC Client
        IrcBot temp = new IrcBot(gui);
        //Connects to  the channel passed from the command line or irc.freenode.org if this is empty
        temp.connect(serverName);
        //Connects to default channel
        temp.joinChannel(channel);

    }

    /**
     * Parse the launch arguments provided when the program started.
     * The input format will be "-arg_type value".
     * There is no restriction in the name of the command line
     * argument, apart from the fact that only specific
     * names are accepted.
     * Also, there is no special check for the values passed.
     * @param args
     */
    private static void parseCommandLineArgs(String[] args) {

        if(args.length % 2 != 0) {
            System.err.println("The args' count has to be of even");
            return;
        }

        /**
         * Parse the array. If the arguments in the first, third etc position
         * of the array(or in the even-th indices) dont start with "-",
         * then the input is invalid.
         */
        for (int i = 0; i <args.length; i++) {
            if (i % 2 == 0) {
                if (!args[i].startsWith("-")) {
                    return;
                } else if (args[i].equals("-serverName")) {
                    serverName = args[i+1];
                } else if (args[i].equals("-channel")) {
                    channel = args[i+1];
                }
            }
        }
    }
}

	 
