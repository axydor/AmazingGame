package main.com.ceng453.game_server;

import main.com.ceng453.ApplicationConstants;

import java.io.*;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class NewConnectionHandler extends Thread {

    private ServerSocket connectionHandlerSocket;
    private List<GameInstance> activeGames;
    private Queue<GameClient> matchmakingQueue;

    public NewConnectionHandler()
    {
        super();
        try {
            connectionHandlerSocket = new ServerSocket(ApplicationConstants.GameServerPort); // TODO no binding ok?
            activeGames = new LinkedList<>();
            matchmakingQueue = new LinkedBlockingQueue<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                GameClient newClient = new GameClient(connectionHandlerSocket.accept());
                matchmakingQueue.add( newClient );
                handleMatchMaking();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private void handleMatchMaking() {
        while( matchmakingQueue.size() > 1 )
        {
            GameClient c1 = matchmakingQueue.poll();
            GameClient c2 = matchmakingQueue.poll();

            GameInstance newGame = new GameInstance(c1, c2);
            activeGames.add(newGame);
            newGame.start();

        }
    }
}
