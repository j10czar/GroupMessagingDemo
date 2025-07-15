# Group Messaging Demo

This project is a simple client/server messaging application built with Java and Swing. It was originally created as a learning project and demonstrates a minimal chat server and graphical clients.

## Project Layout

```
Resources/           Text resources used by the application
src/
  ClientSide/        Client GUI and networking code
  ServerSide/        Server implementation and utilities
```

The `src` folder contains two packages, `ClientSide` and `ServerSide`, each with its respective Java classes and icons.

## Building

The project does not use a build system. To compile it from the command line, run:

```bash
javac src/ClientSide/*.java src/ServerSide/*.java
```

This compiles the classes in place. Ensure a modern Java SDK (8 or newer) is installed.

## Running

Start the server by executing the `Server` class:

```bash
java ServerSide.Server
```

Clients can be launched using the `LoginGUI` class:

```bash
java ClientSide.LoginGUI
```

Multiple clients can connect to the server simultaneously. For help within the application, use the `/help` command in either the server or client window.

## Notes

These sources were originally created for experimentation and have since been reorganized so that resources and source files live at the repository root.
