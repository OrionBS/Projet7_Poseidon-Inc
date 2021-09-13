package fr.orionbs.services;

import fr.orionbs.dtos.*;
import fr.orionbs.models.*;

import java.util.List;

public interface MapperService {

    public CredentialsDTO userToCredentialsDto(User user);

    public BidDTO bidToBidDto(Bid bid);

    public Bid bidDtoToBid(BidDTO bidDTO);

    public List<BidDTO> bidToBidDtoList(List<Bid> bidList);

    public List<Bid> bidDtoToBidList(List<BidDTO> bidDtoList);

    public CurvePointDTO curvePointToCurvePointDto(CurvePoint curvePoint);

    public CurvePoint curvePointDtoToCurvePoint(CurvePointDTO curvePointDTO);

    public List<CurvePointDTO> curvePointToCurvePointDtoList(List<CurvePoint> curvePointList);

    public List<CurvePoint> curvePointDtoToCurvePointList(List<CurvePointDTO> curvePointDTOList);

    public RatingDTO ratingToRatingDTO(Rating rating);

    public Rating ratingDtoToRating(RatingDTO ratingDTO);

    public List<RatingDTO> ratingToRatingDTOList(List<Rating> ratingList);

    public List<Rating> ratingDtoToRatingList(List<RatingDTO> ratingDTOList);

    public RuleDTO ruleToRuleDTO(Rule rule);

    public Rule ruleDtoToRule(RuleDTO ruleDTO);

    public List<RuleDTO> ruleToRuleDTOList(List<Rule> ruleList);

    public List<Rule> ruleDtoToRuleList(List<RuleDTO> ruleDTOList);

    public TradeDTO tradeToTradeDTO(Trade trade);

    public Trade tradeDtoToTrade(TradeDTO tradeDTO);

    public List<TradeDTO> tradeToTradeDTOList(List<Trade> tradeList);

    public List<Trade> tradeDtoToTradeList(List<TradeDTO> tradeDTOList);

    public UserDTO userToUserDTO(User user);

    public User userDtoToUser(UserDTO userDTO);

    public List<UserDTO> userToUserDTOList(List<User> userList);

    public List<User> userDtoToUserList(List<UserDTO> userDTOList);
}
