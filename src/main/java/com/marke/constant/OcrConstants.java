package com.marke.constant;

/**
 * Ocr常量类
 *
 * @author marke.huang
 * @date 2018/9/27 0027 下午 3:50
 */
public class OcrConstants {

    /**
     * 错误代号
     */
    public static final String ERROR_CODE = "error_code";

    /**
     * 识别结果WORDS
     */
    public static final String WORDS = "words";

    /**
     * 识别结果集合WORDS_RESULT
     */
    public static final String WORDS_RESULT = "words_result";

    /**
     * 识别结果数，表示words_result的元素个数
     */
    public static final String WORDS_RESULT_NUM = "words_result_num";

    /**
     * OPTION MAP KEY-检测图像朝向
     */
    public static final String OPTION_MAP_KEY_DETECT_DIRECTION = "detect_direction";

    /**
     * OPTION MAP KEY-开启身份证风险类型
     */
    public static final String OPTION_MAP_KEY_DETECT_RISK = "detect_risk";

    /**
     * OPTION MAP KEY-识别状态
     */
    public static final String MAP_KEY_IMAGE_STATUS = "image_status";

    /**
     * 未摆正身份证
     */
    public static final String IMAGE_STATUS_REVERSED_SIDE = "reversed_side";

    /**
     * 上传的图片中不包含身份证
     */
    public static final String IMAGE_STATUS_NON_IDCARD = "non_idcard";

    /**
     * 身份证模糊
     */
    public static final String IMAGE_STATUS_BLURRED = "blurred";

    /**
     * 身份证关键字段反光或过曝
     */
    public static final String IMAGE_STATUS_OVER_EXPOSURE = "over_exposure";

    /**
     * 无
     */
    public static final String NONE = "无";

}
