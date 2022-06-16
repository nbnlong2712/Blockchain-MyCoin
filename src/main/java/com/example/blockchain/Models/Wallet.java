package com.example.blockchain.Models;

import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "publicKey", nullable = false, unique = true, length = 2000)
    private String publicKey;

    @Column(name = "privateKey", nullable = false, unique = true, length = 2000)
    private String privateKey;

    @Column(name = "balance", nullable = false)
    private double balance;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    public Wallet() {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(1024);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            privateKey = DigestUtils.sha256Hex(keyPair.getPrivate().getEncoded());
            publicKey = DigestUtils.sha256Hex(keyPair.getPublic().getEncoded());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public Wallet(Integer id, double balance, String username, String password) {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(1024);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            privateKey = DigestUtils.sha256Hex(keyPair.getPrivate().getEncoded());
            publicKey = DigestUtils.sha256Hex(keyPair.getPublic().getEncoded());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.id = id;
        this.balance = balance;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //----------------------------------------------------------
    public String convertKeyToHex(byte[] key)
    {
        StringBuilder sb = new StringBuilder();
        for(byte b: key) {
            sb.append(String.format("%02X", b));
        }
        return String.valueOf(sb);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", publicKey='" + publicKey + '\'' +
                ", privateKey='" + privateKey + '\'' +
                ", balance=" + balance +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
