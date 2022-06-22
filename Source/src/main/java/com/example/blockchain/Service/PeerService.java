package com.example.blockchain.Service;

import com.example.blockchain.Interface.PeerRepository;
import com.example.blockchain.Models.Peer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PeerService {
    public static boolean isUsernameExists(PeerRepository repository, Peer peer) {
        List<Peer> peers = repository.findAll();
        for (Peer peer1 : peers)
        {
            if (peer.getUsername().equals(peer1.getUsername()))
                return false;
        }
        return true;
    }
}
