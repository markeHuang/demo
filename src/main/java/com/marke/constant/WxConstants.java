package com.marke.constant;

/**
 * 微信公众号常量类
 *
 * @author jiangming.huang
 * @date 2018/10/8 0008 下午 5:37
 */
public final class WxConstants {

    private WxConstants() {
    }

    /**
     * 消息类型
     *
     * @author jiangming.huang
     * @date 2018/10/8 0008 下午 5:39
     */
    public final class MsgType {
        /**
         * 文本消息
         */
        public static final String TEXT = "text";

        /**
         * 图片消息
         */
        public static final String IMAGE = "image";

        /**
         * 声音消息
         */
        public static final String VOICE = "voice";

        /**
         * 视频消息
         */
        public static final String VIDEO = "video";

        /**
         * 地理位置
         */
        public static final String LOCATION = "location";

        /**
         * 事件信息
         */
        public static final String EVENT = "event";
    }

    /**
     * 事件类型
     *
     * @author jiangming.huang
     * @date 2018/10/8 0008 下午 5:45
     */
    public final class EventType {
        /**
         * 扫码订阅
         */
        public static final String SUBSCRIBE = "subscribe";

        /**
         * 重新扫码订阅
         */
        public static final String SCAN = "SCAN";

        /**
         * 取消关注
         */
        public static final String UNSUBSCRIBE = "unsubscribe";

        /**
         * 点击事件
         */
        public static final String CLICK = "CLICK";

    }

    /**
     * @author jiangming.huang
     * @date 2018/10/8 0008 下午 5:56
     */
    public final class Constans {
        /**
         * 关注标识
         */
        public static final String QRSCENE = "qrscene";

    }
}
