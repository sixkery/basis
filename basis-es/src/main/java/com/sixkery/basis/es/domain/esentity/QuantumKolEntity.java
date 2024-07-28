package com.sixkery.basis.es.domain.esentity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * kol 达人库 es 字段映射
 * @author sixkery
 * @since 2023/9/4
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuantumKolEntity {

    @JsonProperty("kw_fansCity")
    private String kwFansCity;

    @JsonProperty("object_n30dStar")
    private ObjectN30dStarDTO objectN30dStar;

    @JsonProperty("kw_gender")
    private String kwGender;

    @JsonProperty("kw_province")
    private String kwProvince;

    @JsonProperty("date_userUpdateTime")
    private String dateUserUpdateTime;

    @JsonProperty("tkw_platformUserId")
    private String tkwPlatformUserId;

    @JsonProperty("kw_url")
    private String kwUrl;

    @ApiModelProperty("是否限流")
    @JsonProperty("bool_controlStatus")
    private Boolean boolControlStatus;

    @ApiModelProperty("限流原因")
    @JsonProperty("kw_controlReason")
    private String kwControlReason;

    @ApiModelProperty("限流时间")
    @JsonProperty("kw_controlReleaseTime")
    private String kwControlReleaseTime;

    @ApiModelProperty("是否认证")
    @JsonProperty("bool_verified")
    private Boolean boolVerified;

    @ApiModelProperty("认证原因")
    @JsonProperty("tkw_verifiedReason")
    private String tkwVerifiedReason;

    @ApiModelProperty("是否是达人")
    @JsonProperty("bool_isStar")
    private Boolean boolIsStar;

    @ApiModelProperty("社会关系")
    @JsonProperty("kw_socialStatusTag")
    private List<String> kwSocialStatusTag;

    @ApiModelProperty("社会身份")
    @JsonProperty("kw_socialNetworkTag")
    private List<String> kwSocialNetworkTag;


    @JsonProperty("tx_description")
    private String txDescription;

    @JsonProperty("double_searchAfterView")
    private Double doubleSearchAfterView;

    @JsonProperty("kw_expectedCPA3Level")
    private Long kwExpectedCPA3Level;

    @JsonProperty("kw_tags")
    private List<String> kwTags;

    @JsonProperty("kw_fansAge")
    private String kwFansAge;

    @ApiModelProperty("八大人群")
    @JsonProperty("kw_fansTarget")
    private String kwFansTarget;

    @JsonProperty("long_followersCount")
    private Long longFollowersCount;

    @ApiModelProperty("月深度用户数")
    @JsonProperty("long_inter")
    private Long longInter;

    @ApiModelProperty("月连接用户数")
    @JsonProperty("long_cover")
    private Long longCover;


    @JsonProperty("kw_avatar")
    private String kwAvatar;

    @JsonProperty("object_n90dStar")
    private ObjectN90dStarDTO objectN90dStar;

    @JsonProperty("kw_kolId")
    private String kwKolId;

    @JsonProperty("object_n90dPerson")
    private ObjectN90dPersonDTO objectN90dPerson;

    @JsonProperty("kw_city")
    private String kwCity;

    @JsonProperty("kw_fansGender")
    private String kwFansGender;

    @JsonProperty("object_n30dPerson")
    private ObjectN30dPersonDTO objectN30dPerson;

    @JsonProperty("object_fansAgeDetail")
    private List<ObjectFansAgeDetailDTO> objectFansAgeDetail;

    @JsonProperty("date_createTime")
    private String dateCreateTime;

    @JsonProperty("kw_Id")
    private String kwId;

    @JsonProperty("kw_userId")
    private String kwUserId;

    @JsonProperty("tkw_nickname")
    private String tkwNickname;

    @JsonProperty("kw_quantumId")
    private String kwQuantumId;

    @JsonProperty("kw_platform")
    private String kwPlatform;

    @JsonProperty("double_activeFansRate")
    private Double doubleActiveFansRate;

    @JsonProperty("double_fansIncrementRate")
    private Double doubleFansIncrementRate;

    @JsonProperty("kw_location")
    private String kwLocation;

    @JsonProperty("long_fansIncrement")
    private Long longFansIncrement;


    @JsonProperty("long_interaction")
    private Long longInteraction;

    @JsonProperty("long_interaction90d")
    private Long longInteraction90d;

    @JsonProperty("double_interactionAvg")
    private Double doubleInteractionAvg;

    @JsonProperty("double_interactionMedian")
    private Double doubleInteractionMedian;

    @JsonProperty("double_interactionMedian90d")
    private Double doubleInteractionMedian90d;

    @JsonProperty("double_explosiveTextRate")
    private Double doubleExplosiveTextRate;

    @ApiModelProperty("30d帖子数量")
    @JsonProperty("long_postCount30d")
    private Long longPostCount30d;

    @ApiModelProperty("90d帖子数量")
    @JsonProperty("long_postCount90d")
    private Long longPostCount90d;

    @ApiModelProperty("30d帖子阅读中位数")
    @JsonProperty("double_readCountMedian")
    private Double doubleReadCountMedian;

    @ApiModelProperty("90d帖子阅读中位数")
    @JsonProperty("double_readCountMedian90d")
    private Double doubleReadCountMedian90d;


    @JsonProperty("object_fansTargetDetail")
    private List<ObjectFansTargetDetailDTO> objectFansTargetDetail;

    @JsonProperty("double_interateRate")
    private Double doubleInterateRate;

    @JsonProperty("double_playOverRate")
    private Double doublePlayOverRate;

    @JsonProperty("object_fansGenderDetail")
    private List<ObjectFansGenderDetailDTO> objectFansGenderDetail;

    @JsonProperty("object_fansCityDetail")
    private List<ObjectFansCityDetailDTO> objectFansCityDetail;

    @JsonProperty("object_priceInfos")
    private ObjectPriceInfosDTO objectPriceInfos;

    @JsonProperty("object_lastPost")
    private LastPostObject lastPostObject;

    @JsonProperty("object_QI")
    private ObjectQI objectQi;

    @JsonProperty("object_cpe")
    private CpeObject cpeObject;

    @JsonProperty("object_cpm")
    private CpmObject cpmObject;

    @JsonProperty("kw_mcnName")
    private String kwMcnName;

    @JsonProperty("long_rank")
    private Long longRank;

    @JsonProperty("bool_isOfficialQuantum")
    private Boolean boolIsOfficialQuantum;

    @JsonProperty("bool_isCelebrity")
    private Boolean boolIsCelebrityQuantum;

    @JsonProperty("double_blackHorseIndex")
    private Double doubleBlackHorseIndex;

    @JsonProperty("long_blackHorseRank")
    private Long longBlackHorseRank;

    @ApiModelProperty("30天帖子计算的数据")
    @JsonProperty("object_postIndex30d")
    private ObjectPostIndex objectPostIndex30d;

    @ApiModelProperty("90天帖子计算的数据")
    @JsonProperty("object_postIndex90d")
    private ObjectPostIndex objectPostIndex90d;


    @ApiModelProperty("30天商单帖子计算的数据")
    @JsonProperty("object_postStar30d")
    private ObjectPost30d objectPostStar30d;


    @ApiModelProperty("30天非商单帖子计算的数据")
    @JsonProperty("object_postPerson30d")
    private ObjectPost30d objectPostPerson30d;

    @JsonProperty("kw_secUid")
    @ApiModelProperty("抖音达人主页的 id")
    private String kwSecUid;

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectPost30d {

        @ApiModelProperty("互动中位数")
        @JsonProperty("long_interactionMedian")
        private Long longInteractionMedian;

        @ApiModelProperty("互动平均数")
        @JsonProperty("Long_interactionAvg")
        private Long longInteractionAvg;

        @ApiModelProperty("互动数")
        @JsonProperty("long_interaction")
        private Long longInteraction;

        @ApiModelProperty("帖子数")
        @JsonProperty("long_postCount")
        private Long longPostCount;

        @ApiModelProperty("曝文率")
        @JsonProperty("double_explosiveTextRate")
        private Double doubleExplosiveTextRate;

        @ApiModelProperty("点赞中位数")
        @JsonProperty("long_likeMedian")
        private Long longLikeMedian;

        @ApiModelProperty("评论中位数")
        @JsonProperty("long_commentMedian")
        private Long longCommentMedian;

        @ApiModelProperty("分享中位数")
        @JsonProperty("long_shareMedian")
        private Long longShareMedian;

        @ApiModelProperty("阅读中位数")
        @JsonProperty("long_readMedian")
        private Long longReadMedian;

        @ApiModelProperty("收藏中位数")
        @JsonProperty("long_collectMedian")
        private Long longCollectMedian;

        @ApiModelProperty("投币中位数")
        @JsonProperty("long_coinCountMedian")
        private Long longCoinCountMedian;

        @ApiModelProperty("弹幕中位数")
        @JsonProperty("long_danmuCountMedian")
        private Long longDanmuCountMedian;

        @ApiModelProperty("曝光中位数")
        @JsonProperty("long_impMedian")
        private Long longImpMedian;

        @ApiModelProperty("曝光平均数")
        @JsonProperty("long_impAvg")
        private Long longImpAvg;

        @ApiModelProperty("点赞平均数")
        @JsonProperty("long_likeAvg")
        private Long longLikeAvg;

        @ApiModelProperty("评论平均数")
        @JsonProperty("long_commentAvg")
        private Long longCommentAvg;

        @ApiModelProperty("分享平均数")
        @JsonProperty("long_shareAvg")
        private Long longShareAvg;

        @ApiModelProperty("阅读平均数")
        @JsonProperty("long_readAvg")
        private Long longReadAvg;

        @ApiModelProperty("收藏平均数")
        @JsonProperty("long_collectAvg")
        private Long longCollectAvg;

        @ApiModelProperty("投币平均数")
        @JsonProperty("long_coinCountAvg")
        private Long longCoinCountAvg;

        @ApiModelProperty("弹幕平均数")
        @JsonProperty("long_danmuCountAvg")
        private Long longDanmuCountAvg;

        @JsonProperty("double_interactionRate")
        private Double doubleInteractionRate;
        @JsonProperty("double_playOverRate")
        private Double doublePlayOverRate;


        @JsonProperty("double_thousandLikesRate")
        private Double doubleThousandLikesRate;
    }


    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectN30dStarDTO {
        @JsonProperty("long_readMedian")
        private Double longReadMedian;
        @JsonProperty("double_interactionRate")
        private Double doubleInteractionRate;
        @JsonProperty("double_playOverRate")
        private Double doublePlayOverRate;
        @JsonProperty("long_impMedian")
        private Double longImpMedian;
        @JsonProperty("long_commentMedian")
        private Double longCommentMedian;
        @JsonProperty("long_likeMedian")
        private Double longLikeMedian;
        @JsonProperty("double_thousandLikePercent")
        private Double doubleThousandLikePercent;
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectN90dStarDTO {
        @JsonProperty("long_readMedian")
        private Double longReadMedian;
        @JsonProperty("double_interactionRate")
        private Double doubleInteractionRate;
        @JsonProperty("double_playOverRate")
        private Double doublePlayOverRate;
        @JsonProperty("long_impMedian")
        private Double longImpMedian;
        @JsonProperty("long_commentMedian")
        private Double longCommentMedian;
        @JsonProperty("long_likeMedian")
        private Double longLikeMedian;
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectN90dPersonDTO {
        @JsonProperty("long_readMedian")
        private Long longReadMedian;
        @JsonProperty("double_interactionRate")
        private Double doubleInteractionRate;
        @JsonProperty("double_playOverRate")
        private Double doublePlayOverRate;
        @JsonProperty("long_impMedian")
        private Long longImpMedian;
        @JsonProperty("long_commentMedian")
        private Long longCommentMedian;
        @JsonProperty("long_likeMedian")
        private Long longLikeMedian;
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectN30dPersonDTO {
        @JsonProperty("long_readMedian")
        private Long longReadMedian;
        @JsonProperty("double_interactionRate")
        private Double doubleInteractionRate;
        @JsonProperty("double_playOverRate")
        private Double doublePlayOverRate;
        @JsonProperty("long_impMedian")
        private Long longImpMedian;
        @JsonProperty("long_commentMedian")
        private Long longCommentMedian;
        @JsonProperty("long_likeMedian")
        private Long longLikeMedian;
        @JsonProperty("double_thousandLikePercent")
        private Double doubleThousandLikePercent;

    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectFansAgeDetailDTO {
        @JsonProperty("kw_key")
        private String kwKey;
        @JsonProperty("double_value")
        private Double doubleValue;
        @JsonProperty("long_value")
        private Integer longValue;
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectFansTargetDetailDTO {
        @JsonProperty("kw_key")
        private String kwKey;
        @JsonProperty("double_value")
        private Double doubleValue;
        @JsonProperty("long_value")
        private Integer longValue;
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectFansGenderDetailDTO {
        @JsonProperty("kw_key")
        private String kwKey;
        @JsonProperty("double_value")
        private Double doubleValue;
        @JsonProperty("long_value")
        private Integer longValue;
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectFansCityDetailDTO {
        @JsonProperty("kw_key")
        private String kwKey;
        @JsonProperty("double_value")
        private Double doubleValue;
        @JsonProperty("long_value")
        private Integer longValue;
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CpeObject {
        @JsonProperty("double_cpe_21_60")
        private Double doubleCpe2160;

        @JsonProperty("double_cpe_1_20")
        private Double doubleCpe120;

        @JsonProperty("double_cpe_60")
        private Double doubleCpe60;
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CpmObject {
        @JsonProperty("double_cpm_21_60")
        private Double doubleCpm2160;

        @JsonProperty("double_cpm_1_20")
        private Double doubleCpm120;

        @JsonProperty("double_cpm_60")
        private Double doubleCpm60;
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectPriceInfosDTO {
        @JsonProperty("long_price1_20")
        private Double longPrice120;

        @JsonProperty("long_price20_60")
        private Double longPrice2060;

        @JsonProperty("long_price60")
        private Double longPrice60;

        @JsonProperty("long_priceImageArticle")
        private Double longPriceImageArticle;

        @JsonProperty("long_priceVideoTask")
        private Double longPriceVideoTask;

        @JsonProperty("long_priceCooperateSlave")
        private Double longPriceCooperateSlave;

        @JsonProperty("long_priceSingle")
        private Double longPriceSingle;

        @JsonProperty("long_priceDownload")
        private Double longPriceDownload;

        @JsonProperty("long_priceCooperateMaste")
        private Double longPriceCooperateMaste;

        @JsonProperty("long_priceMutil")
        private Double longPriceMutil;

        @JsonProperty("long_pricePost")
        private Double longPricePost;

        @JsonProperty("long_priceForward")
        private Double longPriceForward;

        @JsonProperty("long_priceEmbedding")
        private Double longPriceEmbedding;

        @JsonProperty("long_priceCustomer")
        private Double longPriceCustomer;
        @JsonProperty("long_specified1")
        private Double longSpecified1;
        @JsonProperty("long_specified2")
        private Double longSpecified2;
        @JsonProperty("long_specified3")
        private Double longSpecified3;
        @JsonProperty("long_specified4")
        private Double longSpecified4;
        @JsonProperty("long_specified5")
        private Double longSpecified5;
        @JsonProperty("long_specified6")
        private Double longSpecified6;
        @JsonProperty("long_specified7")
        private Double longSpecified7;
        @JsonProperty("long_specified8")
        private Double longSpecified8;

        @JsonProperty("long_advertorial1")
        private Double longAdvertorial1;
        @JsonProperty("long_advertorial2")
        private Double longAdvertorial2;
        @JsonProperty("long_advertorial3")
        private Double longAdvertorial3;
        @JsonProperty("long_advertorial4")
        private Double longAdvertorial4;
        @JsonProperty("long_advertorial5")
        private Double longAdvertorial5;
        @JsonProperty("long_advertorial6")
        private Double longAdvertorial6;
        @JsonProperty("long_advertorial7")
        private Double longAdvertorial7;
        @JsonProperty("long_advertorial8")
        private Double longAdvertorial8;

        @JsonProperty("long_collection1")
        private Double longCollection1;
        @JsonProperty("long_collection2")
        private Double longCollection2;
        @JsonProperty("long_collection3")
        private Double longCollection3;
        @JsonProperty("long_collection4")
        private Double longCollection4;
        @JsonProperty("long_collection5")
        private Double longCollection5;
        @JsonProperty("long_collection6")
        private Double longCollection6;
        @JsonProperty("long_collection7")
        private Double longCollection7;

    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LastPostObject {
        @JsonProperty("kw_contentType")
        private List<String> kwContentType;

        @JsonProperty("kw_postId")
        private String kwPostId;

        @JsonProperty("date_publishedAt")
        private String datePublishedAt;

        @JsonProperty("long_interaction")
        private long longInteraction;

        @JsonProperty("tx_title")
        private String txTitle;

        @JsonProperty("tx_content")
        private String txContent;

        @JsonProperty("kw_url")
        private String kwUrl;

        @JsonProperty("kw_coverUrl")
        private String kwCoverUrl;
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectQI {
        @JsonProperty("double_qi")
        private Double doubleQi;

        @JsonProperty("double_brandStarIndex")
        private Double doubleBrandStarIndex;

        @JsonProperty("double_brandShoppingIndex")
        private Double doubleBrandShoppingIndex;

        @JsonProperty("double_brandConvertIndex")
        private Double doubleBrandConvertIndex;

        @JsonProperty("double_brandCpIndex")
        private Double doubleBrandCpIndex;

        @JsonProperty("double_cooperate")
        private Double doubleCooperate;
        /**
         * 计算后的值
         */
        @JsonProperty("object_processValue")
        private ObjectProcessValue objectProcessValue;

        /**
         * 计算后的指标
         */
        @JsonProperty("object_processIndex")
        private ObjectProcessIndex objectProcessIndex;
    }

    /**
     * QI 原始值 index之前的值
     */
    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectProcessValue {
        @JsonProperty("double_interaction")
        private Double doubleInteraction;

        @JsonProperty("double_convertValue")
        private Double doubleConvertValue;

        @JsonProperty("double_cpe")
        private Double doubleCpe;

        @JsonProperty("double_starValue")
        private Double doubleStarValue;

        @JsonProperty("double_searchAfterView")
        private Double doubleSearchAfterView;

        @JsonProperty("date_lastPostAt")
        private String dateLastPostAt;

        @JsonProperty("double_shoppingValue")
        private Double doubleShoppingValue;

        @JsonProperty("double_expectedCPA3Level")
        private Double doubleExpectedCPA3Level;

        @JsonProperty("double_cpValue")
        private Double doubleCpValue;

        @JsonProperty("double_followersQuantity")
        private Double doubleFollowersQuantity;

        @JsonProperty("double_cpm")
        private Double doubleCpm;

        @JsonProperty("double_commentValue")
        private Double doubleCommentValue;

        @JsonProperty("long_followersCount")
        private Long longFollowersCount;

        @JsonProperty("double_spreadValue")
        private Double doubleSpreadValue;

        @JsonProperty("double_likeValue")
        private Double doubleLikeValue;

        @JsonProperty("double_readValue")
        private Long doubleReadValue;

        @JsonProperty("double_interateRate")
        private Double doubleInterateRate;

        @JsonProperty("double_brandMentionRate")
        private Double doubleBrandMentionRate;

        @JsonProperty("double_interactionQuality")
        private Double doubleInteractionQuality;

        @JsonProperty("double_shareValue")
        private Double doubleShareValue;

        @JsonProperty("double_playOverRate")
        private Double doublePlayOverRate;

        @JsonProperty("double_cooperateValue")
        private Double doubleCooperateValue;

        @JsonProperty("double_expectedNaturalPlayValue")
        private Double doubleExpectedNaturalPlayValue;

        @JsonProperty("double_nsr")
        private Double doubleNsr;

        @JsonProperty("double_fansIncrementRate")
        private Double doubleFansIncrementRate;

        @JsonProperty("double_explosionRate")
        private Double doubleExplosionRate;

        @JsonProperty("long_followersCover")
        private Long longFollowersCover;

        @JsonProperty("double_responseRate")
        private Double doubleResponseRate;

        @JsonProperty("double_personThousandLikePercent")
        private Double doublePersonThousandLikePercent;
    }

    /**
     * QI 计算后的指标
     */
    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectProcessIndex {
        @JsonProperty("double_starIndex")
        private Double doubleStarIndex;

        @JsonProperty("double_fansIncrementRateIndex")
        private Double doubleFansIncrementRateIndex;

        @JsonProperty("double_playOverRateIndex")
        private Double doublePlayOverRateIndex;

        @JsonProperty("double_cpmIndex")
        private Double doubleCpmIndex;

        @JsonProperty("double_expectedCPA3LevelIndex")
        private Double doubleExpectedCPA3LevelIndex;

        @JsonProperty("double_coinCountIndex")
        private Double doubleCoinCountIndex;

        @JsonProperty("double_shoppingIndex")
        private Double doubleShoppingIndex;

        @JsonProperty("double_interactionIndex")
        private Double doubleInteractionIndex;

        @JsonProperty("double_cpIndex")
        private Double doubleCpIndex;

        @JsonProperty("double_commentIndex")
        private Double doubleCommentIndex;

        @JsonProperty("double_cooperateIndex")
        private Double doubleCooperateIndex;

        @JsonProperty("double_spreadIndex")
        private Double doubleSpreadIndex;

        @JsonProperty("double_readIndex")
        private Double doubleReadIndex;

        @JsonProperty("double_cpeIndex")
        private Double doubleCpeIndex;

        @JsonProperty("double_followersCountIndex")
        private Double doubleFollowersCountIndex;

        @JsonProperty("double_searchAfterViewIndex")
        private Double doubleSearchAfterViewIndex;

        @JsonProperty("double_interateRateIndex")
        private Double doubleInterateRateIndex;

        @JsonProperty("double_expectedNaturalPlayIndex")
        private Double doubleExpectedNaturalPlayIndex;

        @JsonProperty("double_shareIndex")
        private Double doubleShareIndex;

        @JsonProperty("double_convertIndex")
        private Double doubleConvertIndex;

        @JsonProperty("double_likeIndex")
        private Double doubleLikeIndex;

        @JsonProperty("double_followersCoverIndex")
        private Double doubleFollowersCoverIndex;

        @JsonProperty("double_danmuIndex")
        private Double doubleDanmuIndex;

        @JsonProperty("double_pictureReadCostIndex")
        private Double doublePictureReadCost;

        @JsonProperty("double_videoReadCostIndex")
        private Double doubleVideoReadCostIndex;


        @JsonProperty("double_collectIndex")
        private Double doubleCollectIndex;
        // Getters and setters
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ObjectPostIndex {

        @JsonProperty("double_interactionMedian")
        private Double doubleInteractionMedian;

        @JsonProperty("double_interactionAvg")
        private Double doubleInteractionAvg;

        @JsonProperty("double_readCountMedian")
        private Double doubleReadCountMedian;

        @JsonProperty("double_readCountAvg")
        private Double doubleReadCountAvg;

        @JsonProperty("double_likeCountMedian")
        private Double doubleLikeCountMedian;

        @JsonProperty("double_likeCountAvg")
        private Double doubleLikeCountAvg;

        @JsonProperty("double_commentsCountMedian")
        private Double doubleCommentsCountMedian;

        @JsonProperty("double_commentsCountAvg")
        private Double doubleCommentsCountAvg;

        @JsonProperty("double_repostsCountMedian")
        private Double doubleRepostsCountMedian;

        @JsonProperty("double_repostsCountAvg")
        private Double doubleRepostsCountAvg;

        @JsonProperty("double_collectCountMedian")
        private Double doubleCollectCountMedian;

        @JsonProperty("double_collectCountAvg")
        private Double doubleCollectCountAvg;

        @JsonProperty("double_impCountMedian")
        private Double doubleImpCountMedian;

        @JsonProperty("double_impCountAvg")
        private Double doubleImpCountAvg;

        @JsonProperty("double_zaikanCountMedian")
        private Double doubleZaikanCountMedian;

        @JsonProperty("double_zaikanCountAvg")
        private Double doubleZaikanCountAvg;
    }
}

