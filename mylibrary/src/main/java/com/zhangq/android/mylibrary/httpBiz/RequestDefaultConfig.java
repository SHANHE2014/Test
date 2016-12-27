package com.zhangq.android.mylibrary.httpBiz;

/**
 * @author zhangQ
 * @date 2015-12-18
 * 网络请求参数
 */
public class RequestDefaultConfig {
    // public static final String SERVER_ADDRESS =
    // "http://api.songdekuai.cc/Wap/";
    /**
     * 接口地址
     */
    public static final String SERVER_ADDRESS = "https://api.weitanr.com/Wap/Default.aspx/?";
    // public static final String SERVER_ADDRESS =
    // "https://api.weitanr.com/Wap/?";

    /**
     * 合作方编号
     */
    // public static final String PID = "0a24b0f712d753aed427d153e7a962b2";
    public static final String PID = "f14aa17c6ed1128428568618f6193f5c";

    /**
     * +加密密钥
     */
    // public static final String SIGNKEY = "549e24446f237b67b3f8b493de53055c";
    public static final String SIGNKEY = "6be98b2d308cb4a3d0b52265fb3194f3";

    /**
     * 短信请求方法名
     */
    public static final String method_SMS = "SendSMS";

    /**
     * 注册方法名
     */
    public static final String method_Register = "Registe";

    /**
     * 登录方法名
     */
    public static final String method_SignIn = "SignIn";

    /**
     * 上传头像方法名
     */
    public static final String method_AvatarUpload = "AvatarUpload";

    /**
     * 获取首页幻灯片图片列表用户名
     */
    public static final String method_GetHomeBanner = "GetHomeBanner";

    /**
     * 找回密码方法名
     */
    public static final String method_PasswordRecovery = "PasswordRecovery";

    /**
     * 添加或移除购物车中的物品
     */
    public static final String method_ShoppingCart_Append = "ShoppingCart_Append";

    /**
     * 获取用户购物车商品列表
     */
    public static final String method_ShoppingCartGet = "ShoppingCart_Get";

    /**
     * 创建订单_格局购物车的编码提交订单的方法名
     */
    public static final String method_CreateOrderShoppingCartCode = "CreateOrder_ShoppingCartCode";

    /**
     * 直接购买 根据商品编码提交订单方法名
     */
    public static final String method_CreateOrderGoodsCode = "CreateOrder_GoodsCode";

    /**
     * 获取附近各种类型店铺数量方法名
     */
    public static final String method_GetCountBusinessTypeFromCoordinate = "Get_CountBusinessTypeFromCoordinate";

    /**
     * 获取附近推荐商品方法名
     */
    public static final String method_GetRecommendedGoodsFromCoordinate = "Get_RecommendedGoodsFromCoordinate";

    /**
     * 获取附近店铺列表方法名
     */
    public static final String method_GetShopFromCoordinate = "Get_ShopFromCoordinate";

    /**
     * 获取店铺详情
     */
    public static final String method_GetShop = "Get_Shop";

    /**
     * 获取商品详情方法名
     */
    public static final String method_GetGoods = "Get_Goods";

    /**
     * 刷新用户数据方法名
     */
    public static final String method_GetUser = "Get_User";

    /**
     * 商品类型列表
     */
    public static final String method_GetGoodsCategory = "Get_GoodsCategory";

    /**
     * 商品列表
     */
    public static final String method_GetGoodsList = "Get_GoodsList";

    /**
     * 获取店铺自定义列表
     */
    public static final String method_ShopGetCustomCategory = "Shop_Get_CustomCategory";

    /**
     * 收藏列表
     */
    public static final String method_GetFavorite = "Get_Favorite";

    /**
     * 调整收藏
     */
    public static final String method_FavoriteModify = "Favorite_Modify";

    /**
     * 定单列表
     */
    public static final String method_OrderList = "OrderList";

    /**
     * 收货地址
     */
    public static final String method_DeliveryTemplate = "DeliveryTemplate";

    /**
     * 省市区三级列表
     */
    public static final String method_GetPCDList = "Get_PCDList";

    /**
     * 创建支付订单
     */
    public static final String method_CreatePay = "CreatePay";

    /**
     * 定单状态调整
     */
    public static final String method_OrderStateSet = "OrderStateSet";

    /**
     * 用户资料编辑
     */
    public static final String method_User_Modify = "User_Modify";

    /**
     * 商品属性
     */
    public static final String method_Goods_Property = "Goods_Property";

    /**
     * 物流模块查询
     */
    public static final String method_Shop_LogisticsTemplate = "Shop_LogisticsTemplate";

    /**
     * 商品交易评价
     */
    public static final String method_TradeComment = "TradeComment";

    /**
     * 特色市场列表
     */
    public static final String method_BusinessZoneList = "BusinessZoneList";

    /**
     * 订单详情
     */
    public static final String method_OrderDetail = "Order_Detail";

    /**
     * 用户钱包
     */
    public static final String method_ShopGetUseWallet = "Shop_GetUseWallet";

    /**
     * 用于获取用户绑定的所有提现银行卡.
     */
    public static final String method_GetAllWithdrawalsBank = "GetAllWithdrawalsBank";

    /**
     * 绑定提现银行卡
     */
    public static final String method_WithdrawalsBankAccount = "WithdrawalsBankAccount";

    /**
     * 提现及列表
     */
    public static final String method_Withdrawals = "Withdrawals";

    /**
     * 收支列表
     */
    public static final String method_GetPayLog = "Get_PayLog";

    /**
     * 设置为默认提现银行卡
     */
    public static final String method_SetDefaultWithdrawalsBank = "SetDefaultWithdrawalsBank";
}
