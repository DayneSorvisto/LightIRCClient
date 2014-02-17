/**
 * Lightweight IRC Client based on PIRC API Copyright (C) 2014 Author Dayne
 * Sorvisto
 */
import org.jibble.pircbot.*;

import java.util.*;

import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;

import javax.swing.JTextField;

public class IrcClientMain {

    private static ChatApp gui = new ChatApp();

    public static void main(String[] args) throws Exception {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                ChatApp gui = new ChatApp();

            }

        });

        IrcBot temp = new IrcBot(gui); //This is our IRC Client

        temp.connect("irc.freenode.org"); //Connects to irc.freenode.org

        temp.joinChannel("#Test"); //Connects to default channel 

    }

}
