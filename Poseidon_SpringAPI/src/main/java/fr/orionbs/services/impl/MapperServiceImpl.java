package fr.orionbs.services.impl;

import fr.orionbs.dtos.*;
import fr.orionbs.models.*;
import fr.orionbs.services.MapperService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapperServiceImpl implements MapperService {
    @Override
    public CredentialsDTO userToCredentialsDto(User user) {
        return new CredentialsDTO(user.getUsername(), user.getPassword());
    }

    @Override
    public BidDTO bidToBidDto(Bid bid) {
        return new BidDTO(bid.getId(), bid.getAccount(), bid.getType(), bid.getBidQuantity());
    }

    @Override
    public Bid bidDtoToBid(BidDTO bidDTO) {
        return new Bid().setId(bidDTO.getId()).setAccount(bidDTO.getAccount()).setType(bidDTO.getType()).setBidQuantity(bidDTO.getBidQuantity());
    }

    @Override
    public List<BidDTO> bidToBidDtoList(List<Bid> bidList) {
        List<BidDTO> bidDTOList = new ArrayList<>();
        for (Bid bid : bidList) {
            BidDTO bidDTO = new BidDTO(bid.getId(), bid.getAccount(), bid.getType(), bid.getBidQuantity());
            bidDTOList.add(bidDTO);
        }
        return bidDTOList;
    }

    @Override
    public List<Bid> bidDtoToBidList(List<BidDTO> bidDtoList) {
        List<Bid> bidList = new ArrayList<>();
        for (BidDTO bidDto : bidDtoList) {
            Bid bid = new Bid().setId(bidDto.getId()).setAccount(bidDto.getAccount()).setType(bidDto.getType()).setBidQuantity(bidDto.getBidQuantity());
            bidList.add(bid);
        }
        return bidList;
    }

    @Override
    public CurvePointDTO curvePointToCurvePointDto(CurvePoint curvePoint) {
        return new CurvePointDTO(curvePoint.getId(), curvePoint.getCurveId(), curvePoint.getTerm(), curvePoint.getValue());
    }

    @Override
    public CurvePoint curvePointDtoToCurvePoint(CurvePointDTO curvePointDTO) {
        return CurvePoint.builder().curveId(curvePointDTO.getCurveId()).term(curvePointDTO.getTerm()).value(curvePointDTO.getValue()).build();
    }

    @Override
    public List<CurvePointDTO> curvePointToCurvePointDtoList(List<CurvePoint> curvePointList) {
        List<CurvePointDTO> curvePointDTOList = new ArrayList<>();
        for (CurvePoint curvePoint : curvePointList) {
            CurvePointDTO curvePointDTO = new CurvePointDTO(curvePoint.getId(), curvePoint.getCurveId(), curvePoint.getTerm(), curvePoint.getValue());
            curvePointDTOList.add(curvePointDTO);
        }
        return curvePointDTOList;
    }

    @Override
    public List<CurvePoint> curvePointDtoToCurvePointList(List<CurvePointDTO> curvePointDTOList) {
        List<CurvePoint> curvePointList = new ArrayList<>();
        for (CurvePointDTO curvePointDTO : curvePointDTOList) {
            CurvePoint curvePoint = CurvePoint.builder().id(curvePointDTO.getId()).curveId(curvePointDTO.getCurveId()).term(curvePointDTO.getTerm()).value(curvePointDTO.getValue()).build();
            curvePointList.add(curvePoint);
        }
        return curvePointList;
    }

    @Override
    public RatingDTO ratingToRatingDTO(Rating rating) {
        return new RatingDTO(rating.getId(), rating.getMoodysRating(), rating.getSAndPRating(), rating.getFitchRating(), rating.getOrderNumber());
    }

    @Override
    public Rating ratingDtoToRating(RatingDTO ratingDTO) {
        return Rating.builder().id(ratingDTO.getId()).moodysRating(ratingDTO.getMoodysRating()).sAndPRating(ratingDTO.getSAndPRating()).fitchRating(ratingDTO.getFitchRating()).orderNumber(ratingDTO.getOrderNumber()).build();
    }

    @Override
    public List<RatingDTO> ratingToRatingDTOList(List<Rating> ratingList) {
        List<RatingDTO> ratingDTOList = new ArrayList<>();
        for (Rating rating : ratingList) {
            RatingDTO ratingDTO = new RatingDTO(rating.getId(), rating.getMoodysRating(), rating.getSAndPRating(), rating.getFitchRating(), rating.getOrderNumber());
            ratingDTOList.add(ratingDTO);
        }
        return ratingDTOList;
    }

    @Override
    public List<Rating> ratingDtoToRatingList(List<RatingDTO> ratingDTOList) {
        List<Rating> ratingList = new ArrayList<>();
        for (RatingDTO ratingDTO : ratingDTOList) {
            Rating rating = Rating.builder().id(ratingDTO.getId()).moodysRating(ratingDTO.getMoodysRating()).sAndPRating(ratingDTO.getSAndPRating()).fitchRating(ratingDTO.getFitchRating()).orderNumber(ratingDTO.getOrderNumber()).build();
            ratingList.add(rating);
        }
        return ratingList;
    }

    @Override
    public RuleDTO ruleToRuleDTO(Rule rule) {
        return new RuleDTO(rule.getId(), rule.getName(), rule.getDescription(), rule.getJson(), rule.getTemplate(), rule.getSqlStr(), rule.getSqlPart());
    }

    @Override
    public Rule ruleDtoToRule(RuleDTO ruleDTO) {
        return Rule.builder().id(ruleDTO.getId()).name(ruleDTO.getName()).description(ruleDTO.getDescription()).json(ruleDTO.getJson()).template(ruleDTO.getTemplate()).sqlStr(ruleDTO.getSqlStr()).sqlPart(ruleDTO.getSqlPart()).build();
    }

    @Override
    public List<RuleDTO> ruleToRuleDTOList(List<Rule> ruleList) {
        List<RuleDTO> ruleDTOList = new ArrayList<>();
        for (Rule rule : ruleList) {
            RuleDTO ruleDTO = new RuleDTO(rule.getId(), rule.getName(), rule.getDescription(), rule.getJson(), rule.getTemplate(), rule.getSqlStr(), rule.getSqlPart());
            ruleDTOList.add(ruleDTO);
        }
        return ruleDTOList;
    }

    @Override
    public List<Rule> ruleDtoToRuleList(List<RuleDTO> ruleDTOList) {
        List<Rule> ruleList = new ArrayList<>();
        for (RuleDTO ruleDTO : ruleDTOList) {
            Rule rule = Rule.builder().id(ruleDTO.getId()).name(ruleDTO.getName()).description(ruleDTO.getDescription()).json(ruleDTO.getJson()).template(ruleDTO.getTemplate()).sqlStr(ruleDTO.getSqlStr()).sqlPart(ruleDTO.getSqlPart()).build();
            ruleList.add(rule);
        }
        return ruleList;
    }

    @Override
    public TradeDTO tradeToTradeDTO(Trade trade) {
        return new TradeDTO(trade.getId(), trade.getAccount(), trade.getType(), trade.getBuyQuantity());
    }

    @Override
    public Trade tradeDtoToTrade(TradeDTO tradeDTO) {
        return Trade.builder().id(tradeDTO.getId()).account(tradeDTO.getAccount()).type(tradeDTO.getType()).buyQuantity(tradeDTO.getBuyQuantity()).build();
    }

    @Override
    public List<TradeDTO> tradeToTradeDTOList(List<Trade> tradeList) {
        List<TradeDTO> tradeDTOList = new ArrayList<>();
        for (Trade trade : tradeList) {
            TradeDTO tradeDTO = new TradeDTO(trade.getId(), trade.getAccount(), trade.getType(), trade.getBuyQuantity());
            tradeDTOList.add(tradeDTO);
        }
        return tradeDTOList;
    }

    @Override
    public List<Trade> tradeDtoToTradeList(List<TradeDTO> tradeDTOList) {
        List<Trade> tradeList = new ArrayList<>();
        for (TradeDTO tradeDTO : tradeDTOList) {
            Trade trade = Trade.builder().id(tradeDTO.getId()).account(tradeDTO.getAccount()).type(tradeDTO.getType()).buyQuantity(tradeDTO.getBuyQuantity()).build();
            tradeList.add(trade);
        }
        return tradeList;
    }

    @Override
    public UserDTO userToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getFullName(), user.getRole());
    }

    @Override
    public User userDtoToUser(UserDTO userDTO) {
        return User.builder().id(userDTO.getId()).username(userDTO.getUserName()).fullName(userDTO.getFullName()).role(userDTO.getRole()).build();
    }

    @Override
    public List<UserDTO> userToUserDTOList(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getFullName(), user.getRole());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public List<User> userDtoToUserList(List<UserDTO> userDTOList) {
        List<User> userList = new ArrayList<>();
        for (UserDTO userDTO : userDTOList) {
            User user = User.builder().id(userDTO.getId()).username(userDTO.getUserName()).fullName(userDTO.getFullName()).role(userDTO.getRole()).build();
            userList.add(user);
        }
        return userList;
    }
}
