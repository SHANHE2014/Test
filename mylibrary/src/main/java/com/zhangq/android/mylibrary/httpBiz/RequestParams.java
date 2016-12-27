package com.zhangq.android.mylibrary.httpBiz;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangqiang on 16/5/25.
 */
@SuppressWarnings("unused")
public class RequestParams {
    /**
     * 注册一个用户
     */
    public static Map<String, String> register(OnHttpListener httpListener, String phone,
                                               String password, String yanzheng, String udid) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_Register);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("phone", phone);
        map.put("password", password);
        map.put("udid", udid);
        map.put("vcode", yanzheng);

        return map;
    }

    /**
     * vcodecategory 1: 注册 2: 找回密码 11: 设置支付密码 12: 绑定收款银行卡 13: 短信登录
     */
    public static Map<String, String> sendSMS(OnHttpListener httpListener, String phone,
                                              int vcodecategory) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_SMS);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("phone", phone);
        map.put("vcodecategory", vcodecategory + "");

        return map;
    }

    /**
     * 用户登录
     *
     * @param password 密码
     * @param vcode    验证码 (验证码与密码有且只能有一个)
     */
    public static Map<String, String> login(OnHttpListener httpListener, String phone,
                                            String password, String vcode, String udid) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_SignIn);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("phone", phone);
        if (password != null) {
            map.put("password", password);
        } else {
            map.put("vcode", vcode);
        }
        map.put("udid", udid);

        return map;
    }

    /**
     * 找回密码
     */
    public static Map<String, String> recoveryPassword(OnHttpListener httpListener,
                                                       String phone, String password, String yanzheng, String udid) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_PasswordRecovery);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("phone", phone);
        map.put("password", password);
        map.put("vcode", yanzheng);

        return map;
    }

    // 修改幻灯片
    public static Map<String, String> getGomeBanner(OnHttpListener httpListener) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetHomeBanner);
        map.put("pid", RequestDefaultConfig.PID);

        return map;
    }

    // 上传头像
    public static Map<String, String> avatarUpLoad(OnHttpListener httpListener, String token,
                                                   String udid, String avatarData) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_AvatarUpload);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("imageFormat", "8");
        map.put("avatarData", avatarData);

        return map;
    }

    // 获取购物车列表
    public static Map<String, String> getShoppingCar(OnHttpListener httpListener,
                                                     String token, String udid, String shopId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_ShoppingCartGet);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("shopId", shopId);

        return map;
    }

    /**
     * 获取附近各种类型店铺数量
     *
     * @param coordinate
     */
    public static Map<String, String> getCountBusinessTypeFromCoordinate(
            OnHttpListener httpListener, String coordinate) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method",
                RequestDefaultConfig.method_GetCountBusinessTypeFromCoordinate);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("coordinate", coordinate);

        return map;
    }

    // 获取附近推荐商品方法
    public static Map<String, String> getGoodsFromCoordinate(OnHttpListener httpListener,
                                                             String coordinate) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method",
                RequestDefaultConfig.method_GetRecommendedGoodsFromCoordinate);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("coordinate", coordinate);

        return map;
    }

    /**
     * 获取附近店铺列表
     *
     * @param businessZone 最小值为10000
     */
    public static Map<String, String> getShopFromCoor(OnHttpListener httpListener,
                                                      long businessType, int businessZone, String coordinate,
                                                      int pageSize, int pageIndex) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetShopFromCoordinate);
        map.put("pid", RequestDefaultConfig.PID);
        if (businessZone < 10000) {
            map.put("businessType", businessType + "");
        } else {
            map.put("businessZone", businessZone + "");
        }
        map.put("coordinate", coordinate);
        map.put("pageSize", pageSize + "");
        map.put("pageIndex", pageIndex + "");

        return map;
    }

    public static Map<String, String> getShopFromCoor(OnHttpListener httpListener,
                                                      long businessType, int businessZone, String coordinate,
                                                      int pageSize, int pageIndex, int sellingGoods, int hasGoods,
                                                      int local) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetShopFromCoordinate);
        map.put("pid", RequestDefaultConfig.PID);
        if (businessZone < 10000) {
            map.put("businessType", businessType + "");
        } else {
            map.put("businessZone", businessZone + "");
        }
        map.put("coordinate", coordinate);
        map.put("pageSize", pageSize + "");
        map.put("pageIndex", pageIndex + "");
        map.put("sellingGoods", sellingGoods + "");
        map.put("hasGoods", hasGoods + "");
        map.put("local", local + "");

        return map;
    }

    /**
     * 商店查询
     */
    public static Map<String, String> getShopFromCoor(OnHttpListener httpListener,
                                                      String shopName, String coordinate, int pageSize, int pageIndex,
                                                      int hasGoods, int local) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetShopFromCoordinate);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("shopName", shopName);
        map.put("coordinate", coordinate);
        map.put("pageSize", pageSize + "");
        map.put("pageIndex", pageIndex + "");
        map.put("hasGoods", hasGoods + "");
        map.put("local", local + "");

        return map;
    }

    /**
     * 获取店铺详情
     */
    public static Map<String, String> getShop(OnHttpListener httpListener, int shopId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetShop);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("shopId", shopId + "");

        return map;
    }

    /**
     * 获取商品详情
     */
    public static Map<String, String> getGoods(OnHttpListener httpListener, String goodsCode) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetGoods);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("goodsCode", goodsCode);

        return map;
    }

    /**
     * 刷新用户
     */
    public static Map<String, String> getUser(OnHttpListener httpListener, String token,
                                              String udid) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetUser);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);

        return map;
    }

    /**
     * 获取商品类型列表
     *
     * @param parentId parent为第一级时值为10000
     */
    public static Map<String, String> getGoodsCategory(OnHttpListener httpListener,
                                                       int parentId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetGoodsCategory);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("parentId", parentId + "");

        return map;
    }

    /**
     * 商品列表
     *
     * @param values    key属于{shopId,category1,category2,category3,cCategory1,
     *                  cCategory2,brand,title}
     * @param recommend 是否推荐（1为推荐，其他忽略）
     * @param orderBy   排序方式,null时默认为2 0 发布时间_倒序 1 发布时间_正序 2 与用户距离 3 上架时间七天一循环 4
     *                  在线销售数量 5 好评数 6 最后编辑时间_倒序 7 随机排序
     */
    public static Map<String, String> getGoodsList(OnHttpListener httpListener,
                                                   String coordinate, int pageSize, int pageIndex,
                                                   HashMap<String, String> values, int recommend, int orderBy, int tag) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetGoodsList);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("coordinate", coordinate);
        map.put("pageSize", pageSize + "");
        map.put("pageIndex", pageIndex + "");
        map.putAll(values);
        map.put("recommend", recommend + "");
        map.put("orderBy", orderBy + "");

        return map;
    }

    /**
     * note:已知shopid的情况下可以不传coordinate
     */
    public static Map<String, String> getGoodsList(OnHttpListener httpListener,
                                                   String coordinate, int pageSize, int pageIndex,
                                                   HashMap<String, String> values) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetGoodsList);
        map.put("pid", RequestDefaultConfig.PID);
        if (!TextUtils.isEmpty(coordinate)) {
            map.put("coordinate", coordinate);
        }
        map.put("pageSize", pageSize + "");
        map.put("pageIndex", pageIndex + "");
        map.put("orderBy", "2");
        map.putAll(values);

        return map;
    }

    /**
     * 获取商家自定义商品分类列表
     *
     * @param token 暂时不用
     */
    public static Map<String, String> shopGetCustomCategory(OnHttpListener httpListener,
                                                            String token, String udid, int shopId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_ShopGetCustomCategory);
        map.put("pid", RequestDefaultConfig.PID);
        // map.put("token", token);
        map.put("udid", udid);
        map.put("shopId", shopId + "");

        return map;
    }

    /**
     * 调整收藏
     *
     * @param action    0:移除 1：添加
     * @param category  1：店铺 2.商品
     * @param goodsCode 商品id
     * @param shopId    商店id
     */
    public static Map<String, String> favoriteModify(OnHttpListener httpListener,
                                                     String token, String udid, int action, int category,
                                                     String goodsCode, int shopId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_FavoriteModify);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("action", action + "");
        map.put("category", category + "");
        map.put("goodsCode", goodsCode + "");
        map.put("shopId", shopId + "");

        return map;
    }

    /**
     * 获取收藏列表
     *
     * @param category  查询对象：1.店铺 2.商品 3.商店是否收藏 4.商品是否收藏
     * @param shopId    可null,category为3时不能为空
     * @param goodsCode 可null,category为4时不能为空
     */
    public static Map<String, String> getFavorite(OnHttpListener httpListener, String udid,
                                                  String token, int category, int shopId, String goodsCode) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetFavorite);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("category", category + "");
        if (category == 3) {
            map.put("shopId", shopId + "");
        } else if (category == 4) {
            map.put("goodsCode", goodsCode);
        }

        return map;
    }

    /**
     * 同上
     */
    public static Map<String, String> getFavorite(OnHttpListener httpListener, String udid,
                                                  String token, int category, int shopId, String goodsCode,
                                                  int pageSize, int pageIndex) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetFavorite);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("category", category + "");
        if (category == 3) {
            map.put("shopId", shopId + "");
        } else if (category == 4) {
            map.put("goodsCode", goodsCode);
        }
        map.put("pageSize", pageSize + "");
        map.put("pageIndex", pageIndex + "");

        return map;
    }

    /**
     * @param status    定单状态，0为忽略；1待付款；2待发货；3待收货；4待买家评价 5已完成 6已关闭
     * @param pageSize  可空，默认10
     * @param pageIndex 可空，默认0
     */
    public static Map<String, String> orderList(OnHttpListener httpListener, String udid,
                                                String token, int userId, int status, int pageSize, int pageIndex) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_OrderList);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("userId", userId + "");
        map.put("status", status + "");
        map.put("pageSize", pageSize + "");
        map.put("pageIndex", pageIndex + "");

        return map;
    }

    /**
     * 创建定单--购物车
     *
     * @param payment      支付类型（1.货到付款2。在线支付）
     * @param deliveryMode 送货模式（固定值1）
     * @param couponCode1  商品优惠券
     * @param couponCode2  派送费优惠券
     * @param remark       留言
     */
    public static Map<String, String> createOrderShoppingCartCode(OnHttpListener httpListener,
                                                                  String udid, String token, int shopId, String consignee,
                                                                  String data, int payment, int deliveryMode, String logisticsFee,
                                                                  String couponCode1, String couponCode2, String remark) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_CreateOrderShoppingCartCode);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("shopId", shopId + "");
        map.put("consignee", consignee);
        map.put("data", data);
        map.put("payment", payment + "");
        map.put("deliveryMode", deliveryMode + "");
        if (logisticsFee != null) {
            map.put("logisticsFee", logisticsFee);
        }
        // map.put("couponCode1", couponCode1);
        // map.put("couponCode2", couponCode2);
        map.put("remark", remark);

        return map;
    }

    /**
     * 创建定单--商品
     *
     * @param consignee (结构与购物车的不同)
     */
    public static Map<String, String> createOrderGoodsCode(OnHttpListener httpListener,
                                                           String udid, String token, int shopId, String consignee,
                                                           String data, int payment, int deliveryMode, String logisticsFee,
                                                           String couponCode1, String couponCode2, String remark) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_CreateOrderGoodsCode);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("shopId", shopId + "");
        map.put("consignee", consignee);
        map.put("data", data);
        map.put("payment", payment + "");
        map.put("deliveryMode", deliveryMode + "");
        if (logisticsFee != null) {
            map.put("logisticsFee", logisticsFee);
        }
        // map.put("couponCode1", couponCode1);
        // map.put("couponCode2", couponCode2);
        map.put("remark", remark);

        return map;
    }

    /**
     * @param action    add/edit/dele/list
     * @param consignee add/edit不能为null
     * @param id        edit/dele不能为null
     */
    public static Map<String, String> deliveryTemplate(String udid, String token, String action,
                                                       String consignee, int id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_DeliveryTemplate);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("action", action);
        if ("add".equals(action) || "edit".equals(action)) {
            map.put("consignee", consignee);
        }
        if ("edit".equals(action) || "dele".equals(action)) {
            map.put("id", id + "");
        }

        return map;
    }

    /**
     * 获取省市区三级列表
     *
     * @param parentId 第一级传10000
     */
    public static Map<String, String> getPCDList(OnHttpListener httpListener, String udid,
                                                 String token, int parentId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetPCDList);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("parentId", parentId + "");

        return map;
    }

    /**
     * 创建支付订单
     *
     * @param payChannel 1.支付宝订单
     * @param orderCode  (可null)应用类型为充值支付时，不能为空
     * @param payMoney   要从第三方充值的金额，大于0.01元
     * @param balancePay 可空（payMoney+balancePay=订单应支付金额）
     */
    public static Map<String, String> createPay(OnHttpListener httpListener, String udid,
                                                String token, int payChannel, String orderCode, String payMoney,
                                                double balancePay) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_CreatePay);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("category", "1");
        map.put("payChannel", payChannel + "");
        map.put("orderCode", orderCode);
        map.put("payMoney", payMoney);
        // map.put("balancePay", balancePay + "");

        return map;
    }

    /**
     * 定单状态调整
     *
     * @param orderCode 定单编码
     * @param action    10.买家取消定单 11货到付款确认定单
     */
    public static Map<String, String> orderStateSet(OnHttpListener httpListener, String udid,
                                                    String token, String orderCode, int shopId, int action) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_OrderStateSet);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("orderCode", orderCode);
        map.put("shopId", shopId + "");
        map.put("action", action + "");

        return map;
    }

    /**
     * 用户资料修改
     */
    public static Map<String, String> UserModify(OnHttpListener httpListener, String udid,
                                                 String token, int action, String data) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_User_Modify);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);

        if (action == 1) {
            map.put("action", action + "");
            map.put("data", data);
        }

        return map;
    }

    /**
     * 商品属性查询
     *
     * @param category 2.当前级 3.子级
     */
    public static Map<String, String> goodsProperty(OnHttpListener httpListener, String udid,
                                                    String token, int category, int id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_Goods_Property);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        // TODO
        map.put("token", token);
        map.put("category", category + "");
        map.put("id", id + "");

        return map;
    }

    /**
     * 物流模块查询
     */
    public static Map<String, String> shopLogisticsTemplate(OnHttpListener httpListener,
                                                            String udid, String token, int id, int tag) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_Shop_LogisticsTemplate);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("id", id + "");

        return map;
    }

    /**
     * 商品交易评价
     */
    public static Map<String, String> tradeComment(OnHttpListener httpListener, String udid,
                                                   String token, int action, String data) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_TradeComment);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        // TODO
        map.put("token", token);
        map.put("action", action + "");
        map.put("data", data);

        return map;
    }

    /**
     * 特色市场列表
     */
    public static Map<String, String> businessZoneList(OnHttpListener httpListener,
                                                       int category, String address, int pageSize, int pageIndex) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_BusinessZoneList);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("category", category + "");
        map.put("address", address);
        map.put("pageSize", pageSize + "");
        map.put("pageIndex", pageIndex + "");

        return map;
    }

    /**
     * 定单详情
     */
    public static Map<String, String> orderDetail(OnHttpListener httpListener,
                                                  String udid, String token, String orderCode) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_OrderDetail);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("orderCode", orderCode);

        return map;
    }

    @Deprecated
    public static Map<String, String> shopGetUseWallet(OnHttpListener httpListener,
                                                       String udid, String token, int userId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_ShopGetUseWallet);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("shopId", userId + "");

        return map;
    }

    /**
     * 获取所有提现银行卡
     *
     * @param httpListener
     * @param udid
     * @param token
     */
    public static Map<String, String> getAllWithdrawalsBank(OnHttpListener httpListener,
                                                            String udid, String token) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetAllWithdrawalsBank);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);

        return map;
    }


    /**
     * 提现及列表
     *
     * @param httpListener
     * @param udid
     * @param token
     * @param action
     * @param values
     */
    public static Map<String, String> withdrawals(OnHttpListener httpListener, String udid, String token
            , String action, Map<String, String> values) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_Withdrawals);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("action", action);
        map.putAll(values);

        return map;
    }

    /**
     * 收支列表
     *
     * @param httpListener
     * @param udid
     * @param token
     * @param category
     * @param beginTime
     * @param endTime
     * @param pageSize
     * @param pageIndex
     */
    public static Map<String, String> getPayLog(OnHttpListener httpListener, String udid, String token,
                                                String category, String beginTime, String endTime,
                                                int pageSize, int pageIndex) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_GetPayLog);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("category", category);
        map.put("beginTime", beginTime);
//        map.put("endTime", endTime);
//        map.put("pageSize", pageSize + "");
//        map.put("pageIndex", pageIndex + "");

        return map;
    }

    public static Map<String, String> setDefaultWithdrawalsBank(OnHttpListener httpListener, String udid, String token, int id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("method", RequestDefaultConfig.method_SetDefaultWithdrawalsBank);
        map.put("pid", RequestDefaultConfig.PID);
        map.put("udid", udid);
        map.put("token", token);
        map.put("id", id + "");

        return map;
    }

}
