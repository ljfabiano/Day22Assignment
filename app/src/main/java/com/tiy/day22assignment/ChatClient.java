package com.tiy.day22assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by jfabiano on 9/7/2016.
 */
//my IP address: 10.0.0.127
public class ChatClient {

    final String HOST_ADDRESS = "10.0.0.127";
    final int PORT_NUMBER = 8005;
    PrintWriter outToServer;
    Socket clientConnection;
    BufferedReader inFromServer;
    String input;

//    public static void main(String[] args) {
//        //new MainActivity
//        //ChatClient myClient = new ChatClient();
//        //myClient.runClient();
//        //new ChatClient().runClient();
//    }

    public void runClient() {
        try {
            //System.out.println("Connecting to " + HOST_ADDRESS + " on port " + PORT_NUMBER + " ...");
            clientConnection = new Socket(HOST_ADDRESS, PORT_NUMBER);

            //System.out.println("Connected!");

            // once we connect to the server, we also have an input and output stream
            outToServer = new PrintWriter(clientConnection.getOutputStream(), true);
            inFromServer = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
            //System.out.println("Input and Output Streams initialized");

            // we could replace this with a name we get from the user
            outToServer.println("name=" + "client-baseline");
            // make sure we capture the response coming back from the server
            //String serverResponse = inFromServer.readLine();
            //System.out.println("Server says: " + serverResponse);

            // now get into a loop to:
            // 1. ask for user input
            // 2. send user input to the server
            // 3. read the response from the server
            // 4. print the response out to screen
            //Scanner inputScanner = new Scanner(System.in);

            //while (input != "exit") {
                //System.out.println("Enter your message to send: " );
                //String userMessage = inputScanner.nextLine();

                //if (userMessage.equalsIgnoreCase("exit")) {
                //    break;
                //}

                //outToServer.println(userMessage);
                //serverResponse = inFromServer.readLine();
                //System.out.println("Server says: " + serverResponse);
            //}

            // these should be in a finally block, but keeping here for simplicity
            //inFromServer.close();
            //outToServer.close();
            //clientConnection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void sendMessage(String uMessage)
    {
        input = uMessage;

        //System.out.println("user message = " + uMessage);
        //System.out.println("Enter your message to send: " );
        try {
            //change to the input

            if (uMessage.equalsIgnoreCase("exit")) {

                inFromServer.close();
                outToServer.close();
                clientConnection.close();
            }

            outToServer.println(input);
        }catch(IOException ex)
        {

        }
        //serverResponse = inFromServer.readLine();
        //System.out.println("Server says: " + serverResponse);
    }

}
