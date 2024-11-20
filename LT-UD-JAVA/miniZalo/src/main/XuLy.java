package org.example.server;

import java.util.ArrayList;
import java.util.List;

public class XuLy {
    private List<ThreadNhapXuat> listThreadsNhapXuat;

    public XuLy(){
        listThreadsNhapXuat = new ArrayList<>();
    }

    public int getSize(){
        return listThreadsNhapXuat.size();
    }

    public void addClientThread(ThreadNhapXuat client){
        listThreadsNhapXuat.add(client);
    }

    public void removeClientThread(int userID){
        for(ThreadNhapXuat thread : listThreadsNhapXuat){
            if(thread.getUserID() == userID){
                listThreadsNhapXuat.remove(thread);
                return;
            }
        }
    }

    public void sendUserIDForClient(int userID){
        sendToPerson("userID" + "#~" + "server" + "#~" + userID + "#~" + userID, userID);
    }


    public void sendListUserOnline(){
        String st = "";
        for(ThreadNhapXuat threadNhapXuat : listThreadsNhapXuat){
            st += threadNhapXuat.getUserID() + "-";
        }
        sendToPerson("capNhapDSOnline" + "#~" + "server" + "#~" + st);
    }

    public void sendToPerson(String message) {
        for(ThreadNhapXuat threadNhapXuat : listThreadsNhapXuat){
            try {
                threadNhapXuat.export(message);
            }catch (Exception e){
                System.out.println("Error[XuLy(1)]::" + e.getMessage());
            }
        }
    }

    public void sendToPerson(String message, int userID) {
        for(ThreadNhapXuat threadNhapXuat : listThreadsNhapXuat){
            if(threadNhapXuat.getUserID() != userID){
                try {
                    threadNhapXuat.export(message);
                }catch (Exception e){
                    System.out.println("Error[XuLy(2)]::" + e.getMessage());
                }
            }
        }
    }

    private void sendToPersonIncludeMe(String message, int userID) {
        for(ThreadNhapXuat threadNhapXuat : listThreadsNhapXuat){
            if(threadNhapXuat.getUserID() == userID){
                try {
                    threadNhapXuat.export(message);
                }catch (Exception e){
                    System.out.println("Error[XuLy(2)]::" + e.getMessage());
                }
            }
        }
    }

    public void forwardMessage(String message, int userID){
        String[] splitMessage = message.split("#~");
        if(splitMessage[0].equals("guiMoiNguoi")){
            sendToPerson("guiMoiNguoi" + "#~" + splitMessage[1] + "#~" + splitMessage[2], userID);
        }
        if(splitMessage[0].equals("guiMotNguoi")){
            sendToPerson("guiMotNguoi" + "#~" + splitMessage[1] + "#~" + splitMessage[2]
                    + "#~" + splitMessage[3], Integer.parseInt(splitMessage[3]));
        }
    }




}


