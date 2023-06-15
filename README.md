# Multiuser_Chat_Application







![images](https://github.com/radhika3131/Multiuser_Chat_Application/assets/102825662/e812f2a3-2869-4b46-8d1b-adf1ec753f9a)








This is a multi-user chat application implemented in Java, featuring a user login and register page, a dashboard screen, a chat interface, and various other functionalities. The application utilizes SQL database for user data storage, socket programming with server socket for communication, handshaking process for establishing connections, multithreading for handling multiple clients, message broadcasting, error and exception handling, reading/writing data on stream, private messaging, and password hashing for enhanced security.



## Features

### User Registration
New users can create an account by providing a unique username, password, and other required information.

### Login
Registered users can securely log in using their credentials.

### Dashboard
Upon successful login, users are directed to a dashboard screen displaying chat rooms.

### Chat Interface
Users can join chat rooms and communicate with other users in real-time using a user-friendly chat interface.

### SQL Database Integration
User data, including usernames, passwords, and other details, are stored securely in an SQL database.

### Socket Programming and Server Socket
The application utilizes socket programming and server socket for establishing connections and enabling communication between clients and the server.

### Handshaking Process
A handshaking process is implemented for establishing secure connections between clients and the server.

### Multithreading
The server employs multithreading to handle multiple client connections concurrently.

### Message Broadcasting
Messages sent by users are broadcasted to all participants in the respective chat room.

### Error and Exception Handling
The application includes robust error and exception handling mechanisms to handle unexpected situations gracefully.

### Stream I/O
The application implements read/write operations on streams to transmit messages between clients and the server.

### Private Messaging
Users can send private messages to specific users within the same chat room for more personalized communication.

### Password Hashing
User passwords are hashed and securely stored in the database to protect sensitive information.




## Dependencies

The project has the following dependencies:

Java 8 or above
JDBC (Java Database Connectivity) library
GUI library (e.g. Swing)




## Usage

Launch the application by running the Server class to start the server.

Clients can run the Client class to connect to the server.

Register a new account if you are a new user. Otherwise, log in using your existing credentials.



## Registeration Page

![Registeration Page](https://github.com/radhika3131/Multiuser_Chat_Application/assets/102825662/123a2b41-e474-413e-bbcf-88eece6c29cd)


## Login Page

![loginPage](https://github.com/radhika3131/Multiuser_Chat_Application/assets/102825662/6168880f-72fd-41fe-b8c7-972f046bbf97)


## DashBoard

![Screenshot (9)](https://github.com/radhika3131/Multiuser_Chat_Application/assets/102825662/bc28bc48-9254-4eaa-b918-ccf8e98ab3d6)


## Chatting Screen

![chat](https://github.com/radhika3131/Multiuser_Chat_Application/assets/102825662/e36d6168-4ffd-4c9c-aa22-d5fffa7a0cda)





