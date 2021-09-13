package fr.orionbs.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity(name = "bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String account;
    private String type;
    private Double bidQuantity;
    private Double askQuantity;
    private Double bid;
    private Double ask;
    private String benchmark;
    private Timestamp bidDate;
    private String commentary;
    private String security;
    private String status;
    private String trader;
    private String book;
    private String creationName;
    private Timestamp creationDate;
    private String revisionName;
    private Timestamp revisionDate;
    private String dealName;
    private String dealType;
    private String sourceListId;
    private String side;

    public Integer getId() {
        return id;
    }

    public Bid setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public Bid setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getType() {
        return type;
    }

    public Bid setType(String type) {
        this.type = type;
        return this;
    }

    public Double getBidQuantity() {
        return bidQuantity;
    }

    public Bid setBidQuantity(Double bidQuantity) {
        this.bidQuantity = bidQuantity;
        return this;
    }

    public Double getAskQuantity() {
        return askQuantity;
    }

    public Bid setAskQuantity(Double askQuantity) {
        this.askQuantity = askQuantity;
        return this;
    }

    public Double getBid() {
        return bid;
    }

    public Bid setBid(Double bid) {
        this.bid = bid;
        return this;
    }

    public Double getAsk() {
        return ask;
    }

    public Bid setAsk(Double ask) {
        this.ask = ask;
        return this;
    }

    public String getBenchmark() {
        return benchmark;
    }

    public Bid setBenchmark(String benchmark) {
        this.benchmark = benchmark;
        return this;
    }

    public Timestamp getBidDate() {
        return bidDate;
    }

    public Bid setBidDate(Timestamp bidDate) {
        this.bidDate = bidDate;
        return this;
    }

    public String getCommentary() {
        return commentary;
    }

    public Bid setCommentary(String commentary) {
        this.commentary = commentary;
        return this;
    }

    public String getSecurity() {
        return security;
    }

    public Bid setSecurity(String security) {
        this.security = security;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Bid setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getTrader() {
        return trader;
    }

    public Bid setTrader(String trader) {
        this.trader = trader;
        return this;
    }

    public String getBook() {
        return book;
    }

    public Bid setBook(String book) {
        this.book = book;
        return this;
    }

    public String getCreationName() {
        return creationName;
    }

    public Bid setCreationName(String creationName) {
        this.creationName = creationName;
        return this;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public Bid setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public String getRevisionName() {
        return revisionName;
    }

    public Bid setRevisionName(String revisionName) {
        this.revisionName = revisionName;
        return this;
    }

    public Timestamp getRevisionDate() {
        return revisionDate;
    }

    public Bid setRevisionDate(Timestamp revisionDate) {
        this.revisionDate = revisionDate;
        return this;
    }

    public String getDealName() {
        return dealName;
    }

    public Bid setDealName(String dealName) {
        this.dealName = dealName;
        return this;
    }

    public String getDealType() {
        return dealType;
    }

    public Bid setDealType(String dealType) {
        this.dealType = dealType;
        return this;
    }

    public String getSourceListId() {
        return sourceListId;
    }

    public Bid setSourceListId(String sourceListId) {
        this.sourceListId = sourceListId;
        return this;
    }

    public String getSide() {
        return side;
    }

    public Bid setSide(String side) {
        this.side = side;
        return this;
    }
}
