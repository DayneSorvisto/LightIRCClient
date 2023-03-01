
# Light IRC Client

LightIRCClient is a graphical lightweight cross platform IRC Client based on the pIRC API.


1. Download the Jibble pIRC API from http://www.jibble.org/pircbot.php

2. On GNU/Linux, open the terminal. Compile with javac -cp pircbot.jar:. IrcClientMain.java 

3. Enter java -cp pircbot.jar:. IrcCLientMain to launch LightIRCClient

The default IRC node is: irc.freenode.org and the default channel is #Test. If you wish to use different ones, please pass:

"-serverName <the desired IRC server>" and "-channel <the desired channel>"(without the quotes).

in the command above, in step 3.

Basic Functions: 

/join #channel to join channel

/users to display a list of users in current channel

/window to navigate channel windows

/nick to change nickname when connected to server


## Badges

Add badges from somewhere like: [shields.io](https://shields.io/)

[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)


## Roadmap

- Port to Python.



## Contributing

Contributions are always welcome! Submit a PR.



## Installation


1. Download the Jibble pIRC API from http://www.jibble.org/pircbot.php

2. On GNU/Linux, open the terminal. Compile with javac -cp pircbot.jar:. IrcClientMain.java 

3. Enter java -cp pircbot.jar:. IrcCLientMain to launch LightIRCClient

The default IRC node is: irc.freenode.org and the default channel is #Test. If you wish to use different ones, please pass:
## API Reference

#### Get all items

```http
   Examples
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `/nick` | `string` |  Change Nick |

#### Other commands

/join #channel to join channel

/users to display a list of users in current channel

/window to navigate channel windows

