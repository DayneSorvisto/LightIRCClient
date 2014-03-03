import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.event.*;
import org.jibble.pircbot.*;
import java.util.*;
/** This is our GUI class */ public class ChatApp implements ActionListener
{
    private JTextArea textArea;
    private JTextField textData;
    private JFrame frame;
    private IrcBot bot;
    public ChatApp()
    {
        textArea = new JTextArea();
        textArea.setEditable(false);
        textData = new JTextField();
        textData.addActionListener(this);
        frame = new JFrame("LightIRC Client");
        //Set name of IRC Client         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
        frame.add(textData, BorderLayout.SOUTH);
        frame.setMinimumSize(new Dimension(485, 300));
        frame.setLocationRelativeTo(null);
        textData.grabFocus();
    }
    public void listen(IrcBot bot)
    {
        this.bot = bot;
    }
    public void actionPerformed(ActionEvent e)
    {
        String data = textData.getText() + "\n";
        textArea.append(bot.nick + " " + data);
        textData.setText("");
        if (!bot.commands(data))
        {
            bot.sendMessage(bot.current, data);
        }
    }
    public void listUsers(User array[])
    {
        final User users[] = array;
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                for (User u : users)
                {
                    textArea.append(u.toString() + "\n");
                }
            }
        }
        );
    }
    public void appendTopic(String topic)
    {
        final String top = topic;
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                textArea.append(top + "\n");
            }
        }
        );
    }
    public void appendMessage(String message)
    {
        final String msg = message;
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                textArea.append(msg + "\n");
            }
        }
        );
    }
    public void setDisplay(boolean b)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                frame.setVisible(true);
            }
        }
        );
    }
} 
