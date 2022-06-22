package com.example.blockchain.Interface;

import com.example.blockchain.Models.Peer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeerRepository extends JpaRepository<Peer, Integer> {
}
